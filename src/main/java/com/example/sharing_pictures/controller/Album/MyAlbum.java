package com.example.sharing_pictures.controller.Album;

import com.example.sharing_pictures.DAO.Album.AlbumDAO;
import com.example.sharing_pictures.model.Album;
import com.example.sharing_pictures.model.Image;
import com.example.sharing_pictures.model.Utilisateur;
import org.hibernate.Session;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.OutputStream;
import java.util.List;


@WebServlet("/Albums/myAlbum")
public class MyAlbum extends HttpServlet {

    private static final String VUE_DETAIL_ALBUM = "/WEB-INF/website/albums/MyAlbum.jsp";
    private AlbumDAO albumDAO;
    private EntityManagerFactory entityManagerFactory = null;
    private EntityManager entityManager = null;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        try {
            HttpSession session  =request.getSession();
            Utilisateur user = (Utilisateur) session.getAttribute("user");

            entityManagerFactory = Persistence.createEntityManagerFactory("sharing_pictures");
            entityManager = entityManagerFactory.createEntityManager();
            albumDAO = new AlbumDAO(entityManager);
            List<Album> albumListUser = albumDAO.getMyAlbum(user.getId());
            request.setAttribute("listeAlbumUser", albumListUser);

            request.getRequestDispatcher(VUE_DETAIL_ALBUM).forward(request, response);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            entityManager.close();
            entityManagerFactory.close();
        }


    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }
}
