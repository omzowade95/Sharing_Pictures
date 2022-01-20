package com.example.sharing_pictures.controller.Album;

import com.example.sharing_pictures.DAO.Album.AlbumDAO;
import com.example.sharing_pictures.DAO.Image.ImageDAO;
import com.example.sharing_pictures.DAO.Utilisateur.UtilisateurDAO;
import com.example.sharing_pictures.form.AddAlbumForm;
import com.example.sharing_pictures.form.ImageUploader;
import com.example.sharing_pictures.model.Album;
import com.example.sharing_pictures.model.Image;
import com.example.sharing_pictures.model.Status;
import com.example.sharing_pictures.model.Utilisateur;
import org.hibernate.Session;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.*;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@WebServlet("/Albums/add")
@MultipartConfig(fileSizeThreshold = 1024 * 1024,
        maxFileSize = 1024 * 1024 * 5,
        maxRequestSize = 1024 * 1024 * 5 * 5)
public class AddAlbum  extends HttpServlet {

    private static final String VUE_AJOUT_ALBUM = "/WEB-INF/website/albums/add.jsp";
    private static final String VUE_ALBUM = "/WEB-INF/website/albums/list.jsp";
    private static  String lIST_IMAGES = "/Images_Upload";
    HttpSession session;
    UtilisateurDAO utilisateurDAO ;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        session = request.getSession();
        request.getRequestDispatcher(VUE_AJOUT_ALBUM).forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        EntityManager entityManager = null;
        EntityManagerFactory entityManagerFactory = null;
        try {
            entityManagerFactory = Persistence.createEntityManagerFactory("sharing_pictures");
            entityManager = entityManagerFactory.createEntityManager();
            List<Utilisateur> utilisateurList = new ArrayList<>();
            utilisateurDAO = new UtilisateurDAO(entityManager);
            String auth = request.getParameter("autorisations");



            if (auth != null) {
                String[] arrOfStr = auth.split(",");
                for (String a : arrOfStr) {
                    System.out.println(a);
                    if (!a.equals("")) {
                        int id = Integer.parseInt(a);
                        Utilisateur user = utilisateurDAO.getUser(id);
                        System.out.println("user");
                        System.out.println(user);
                        utilisateurList.add(user);
                    }
                }
            }

            for (Utilisateur u : utilisateurList) {
                System.out.println(u);
                System.out.println("list");
            }
            request.setAttribute("utilisateurAuthoriser", utilisateurList);


            String[] results = request.getParameterValues("statue");
            if (results != null)
                request.setAttribute("statue", results[0]);

            String[] desc = request.getParameterMap().get("images[descriptions][]");
            String[] titre = request.getParameterMap().get("images[titles][]");

            ImageUploader imgUp = new ImageUploader(request);
            List<Image> images = imgUp.saveImages();

            AddAlbumForm addAlbumForm = new AddAlbumForm(request, session);

            for (int i = 0; i < desc.length; i++) {
                images.get(i).setDescription(desc[i]);
                images.get(i).setTitre(titre[i]);
                images.get(i).setDateCreation(LocalDate.now().toString());
                images.get(i).setDateMAJ(LocalDate.now().toString());
                images.get(i).setHauteur(100);
                images.get(i).setLargeur(100);
            }

            request.setAttribute("listeImage", images);

            if (addAlbumForm.add()) {
                response.sendRedirect(request.getContextPath() + "/Albums");
            } else {
                response.sendRedirect(request.getContextPath() + "/Albums/add");

            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            entityManager.close();
            entityManagerFactory.close();
        }


    }



}
