package com.example.sharing_pictures.controller;

import com.example.sharing_pictures.DAO.Album.AlbumDAO;
import com.example.sharing_pictures.DAO.Image.ImageDAO;
import com.example.sharing_pictures.model.Album;
import com.example.sharing_pictures.model.Image;
import com.example.sharing_pictures.model.Status;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


@WebServlet("")
public class HomeController extends HttpServlet {
    private static final String HOME_VUE = "/index.jsp";
    private AlbumDAO albumDAO;
    private EntityManagerFactory entityManagerFactory = null;
    private EntityManager entityManager = null;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("activeLogin", true);


        try {
            entityManagerFactory = Persistence.createEntityManagerFactory("sharing_pictures");
            entityManager = entityManagerFactory.createEntityManager();
            albumDAO = new AlbumDAO(entityManager);
            ImageDAO imageDAO = new ImageDAO(entityManager);
            List<Image> imageList = new ArrayList<>();

            List<Album> alb = albumDAO.getAlbumByStatus(Status.PUBLIC);

            if (alb != null) {
                for (Album a: alb) {
                    List<Image> l = imageDAO.listeImageFromAlbum(a.getId());
                    if (l != null) {
                        for (Image i: l) {
                            imageList.add(i);
                        }
                    }

                }
            }


            request.setAttribute("listeImgpub",imageList);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            entityManager.close();
            entityManagerFactory.close();
        }

        request.getRequestDispatcher(HOME_VUE).forward(request, response);

    }
}
