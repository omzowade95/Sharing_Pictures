package com.example.sharing_pictures.controller.Album;

import com.example.sharing_pictures.DAO.Album.AlbumDAO;
import com.example.sharing_pictures.DAO.Authorisation.AuthorisationDAO;
import com.example.sharing_pictures.model.*;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/Albums")
@MultipartConfig( fileSizeThreshold = 1024 * 1024,
        maxFileSize = 1024 * 1024 * 5,
        maxRequestSize = 1024 * 1024 * 5 * 5 )
public class AlbumListController extends HttpServlet {

    private static final String VUE_lIST_ALBUM = "/WEB-INF/website/albums/list.jsp";
    public String uploadPath;

    private EntityManagerFactory entityManagerFactory = null;
    private EntityManager entityManager = null;
    private AlbumDAO  album;
    HttpSession session;



    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.setAttribute("activeAlbum", true);
        request.setCharacterEncoding("UTF-8");

        session = request.getSession();
        Utilisateur u = (Utilisateur) request.getSession().getAttribute("user");

        try {
            entityManagerFactory = Persistence.createEntityManagerFactory("sharing_pictures");
            entityManager = entityManagerFactory.createEntityManager();
            List<Album> albumList ;
            album = new AlbumDAO(entityManager);
            albumList = album.getAlbumByStatus(Status.PUBLIC) ;
            List<Image> imageAlb = new ArrayList<>();

            if (u != null){
                AuthorisationDAO authorisationDAO = new AuthorisationDAO(entityManager);
                List<Authorisation> auth = authorisationDAO.listeAuth(u.getId());
                for (Authorisation a: auth) {
                    albumList.add(a.getAlbum());
                }

            }


            request.setAttribute("listAlbum", albumList);
            request.setAttribute("listImage", imageAlb);


        }catch (Exception e){

            e.printStackTrace();


        } finally {
            entityManager.close();
            entityManagerFactory.close();
        }



        request.getRequestDispatcher(VUE_lIST_ALBUM).forward(request, response);
    }


}
