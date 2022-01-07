package com.example.sharing_pictures.form;

import com.example.sharing_pictures.DAO.Album.AlbumDAO;
import com.example.sharing_pictures.model.Album;
import com.example.sharing_pictures.model.Status;
import com.example.sharing_pictures.model.Theme;
import com.example.sharing_pictures.model.Utilisateur;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;
import java.io.File;
import java.io.IOException;
import java.util.*;

public class AddAlbumForm {

    private static final String CHAMP_THEME="theme";
    private static final String CHAMP_NOM="nom";
    private static final String CHAMP_STATUS="statue";
    private static final String CHAMP_IMAGE="image";

    private HttpServletRequest request;
    private HttpSession session;
    private Map<String, String> erreurs;
    private AlbumDAO albumDAO;
    private EntityManagerFactory entityManagerFactory = null;
    private EntityManager entityManager = null;

    public AddAlbumForm(HttpServletRequest request, HttpSession session){
        this.erreurs = new HashMap<>();
        this.request= request;
        this.session = session;
    }

    public boolean add(){
        entityManagerFactory = Persistence.createEntityManagerFactory("sharing_pictures");
        entityManager = entityManagerFactory.createEntityManager();

        String uploadPath="";
        String nom = getParameter(CHAMP_NOM);
        String theme = getParameter(CHAMP_THEME);
       // Status status = (Status) getParameter(CHAMP_STATUS);
        List<String> images = new ArrayList<>();
        try {
            for ( Part part : request.getParts() ) {
                String fileName = getFileName( part );
                String fullPath = uploadPath + File.separator + fileName;
                part.write( fullPath );
                System.out.println(fullPath);
                images.add(fullPath);
                System.out.println("okkkk");

            }
            Date date = new Date();

            //Album album = new Album(nom,date.getTime(),,(Utilisateur) session.getAttribute("utilisateur"),new Theme(theme));
            albumDAO = new AlbumDAO(entityManager);
            //albumDAO.add();
        } catch (Exception e) {
            e.printStackTrace();
        }




        return false;
    }


    private String getFileName( Part part ) {
        for ( String content : part.getHeader( "content-disposition" ).split( ";" ) ) {
            if ( content.trim().startsWith( "filename" ) )
                return content.substring( content.indexOf( "=" ) + 2, content.length() - 1 );
        }
        return "Default.file";
    }
    private void validerChamps(String ...champs){
        for (String champ : champs) {
            if (getParameter(champ) == null) {
                erreurs.put(champ, "Vous devez remplir ce champ");
            }
        }
    }

    private String getParameter(String parametre) {
        String valeur = request.getParameter(parametre);
        if (valeur == null || valeur.trim().isEmpty()) {
            return null;
        }
        return valeur ;
    }
}
