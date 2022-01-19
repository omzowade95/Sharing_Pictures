package com.example.sharing_pictures.form;



import java.io.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.Part;

import com.example.sharing_pictures.model.Image;



public class ImageUploader
{
    private HashMap<String, String> errors = new HashMap<String, String>();
    private String UPLOAD_DIRECTORY;
    private static final int TAILLE_TAMPON = 10240;
    private String resultat;
    private HttpServletRequest request;

    public ImageUploader()
    {

    }

    public ImageUploader(HttpServletRequest request)
    {
        this.request = request;
        String uploadDirectory = this.request.getServletContext().getInitParameter("directory");
        File directory = new File(uploadDirectory);
        System.out.println("UPLOAD FOLDER PATH ========== " +
                directory.getAbsolutePath());
        if (!directory.exists())
        {
            directory.mkdir();
        }
        this.UPLOAD_DIRECTORY = uploadDirectory;
    }

    public HashMap<String, String> getErrors()
    {
        return this.errors;
    }

    public String getResultat()
    {
        return this.resultat;
    }

    private String getFileName(final Part part)
    {
        for (String content : part.getHeader("content-disposition").split(";"))
        {
            if (content.trim().startsWith("filename"))
            {
                return content.substring(content.indexOf('=') + 1).trim().replace("\"", "");
            }
        }
        return null;
    }

    public List<Image> saveImages()
    {
        List<Image> images = new ArrayList<Image>();
        Collection<Part> parts = null;
        try{
            parts = this.request.getParts();
            for (Part part : parts)
            {
                String nomFichier = this.getFileName(part);
                InputStream contenuFichier = null;
                if (nomFichier != null && !nomFichier.isEmpty())
                {
                    nomFichier = nomFichier.substring(nomFichier.lastIndexOf('/') + 1)
                            .substring(nomFichier.lastIndexOf('\\') + 1);
                    contenuFichier = part.getInputStream();

                        try
                        {
                            this.writeFile(contenuFichier, nomFichier);
                            Image img = new Image();

                            String fichier = UPLOAD_DIRECTORY +"/"+ nomFichier;
                            File f = new File(fichier);
                            InputStream fstream = new FileInputStream(f);
                            ByteArrayOutputStream buffer = new ByteArrayOutputStream();

                            int nRead;
                            byte[] data = new byte[16384];

                            while ((nRead = fstream.read(data, 0, data.length)) != -1) {
                                buffer.write(data, 0, nRead);
                            }

                            buffer.toByteArray();
                            img.setLocation(buffer.toByteArray());
                            images.add(img);
                            fstream.close();
                            buffer.close();
                        } catch (IOException e)
                        {
                            this.errors.put("writeError", "Erreur lors de l'ecriture du fichier.");
                            e.printStackTrace();
                        }
                    }
                }

        }catch (Exception e){
            e.printStackTrace();
        }

        return images;
    }

    private void writeFile(InputStream contenu, String nomFichier) throws IOException
    {
        BufferedInputStream entree = null;
        BufferedOutputStream sortie = null;
        try
        {
            // System.out.println("On y est\
            // ----------------------------");
            entree = new BufferedInputStream(contenu, TAILLE_TAMPON);
            sortie = new BufferedOutputStream(new FileOutputStream(new File(UPLOAD_DIRECTORY + "/" + nomFichier)),
                    TAILLE_TAMPON);
            byte[] tampon = new byte[TAILLE_TAMPON];
            int longueur = 0;
            while ((longueur = entree.read(tampon)) > 0)
            {
                sortie.write(tampon, 0, longueur);
            }
        } finally
        {
            try
            {
                if(sortie != null) {
                    sortie.close();
                }


            } catch (IOException ignore)
            {
            }
            try
            {
                entree.close();
            } catch (IOException ignore)
            {
            }
        }

    }

    public String getValeur(Part part) throws IOException
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(part.getInputStream(), "UTF-8"));
        StringBuilder valeur = new StringBuilder();
        char[] buffer = new char[1024];
        int longueur = 0;
        while ((longueur = reader.read(buffer)) > 0)
        {
            valeur.append(buffer, 0, longueur);
        }
        return valeur.toString();
    }

}

