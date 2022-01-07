package com.example.sharing_pictures.controller.photo;

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

@WebServlet("/photos")
public class PhotoListController extends HttpServlet {


    private static final String VUE_PHOTOS = "/WEB-INF/website/photo/list.jsp";
    private static final String VUE_lIST_ALBUM = "/WEB-INF/website/albums/list.jsp";
    public String uploadPath;

    EntityManagerFactory entityManagerFactory = null;
    EntityManager entityManager = null;
    ImageDAO imageDAO;
    List<Image> imagesList;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("activePhoto", true);

        try {
            entityManagerFactory = Persistence.createEntityManagerFactory("sharing_pictures");
            entityManager = entityManagerFactory.createEntityManager();
            imageDAO = new ImageDAO(entityManager);
            AlbumDAO albdao = new AlbumDAO(entityManager);
            List<Album> albums = albdao.getAlbumByStatus(Status.PUBLIC);

            imagesList = new ArrayList<>();
            for (Album a : albums) {
                List<Image> img = imageDAO.listeImageFromAlbum(a.getId());
                for (Image i : img) {
                    imagesList.add(i);
                }
            }


            request.setAttribute("imageList", imagesList);
            for (Image a: imagesList ) {
                System.out.println(a.toString());

            }

        }catch (Exception e){

            e.printStackTrace();


        } finally {

        }
        request.getRequestDispatcher(VUE_PHOTOS).forward(request, response);
    }
}
