package com.example.sharing_pictures.controller.Album;

import com.example.sharing_pictures.DAO.Album.AlbumDAO;
import com.example.sharing_pictures.model.Image;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.OutputStream;
import java.util.List;


@WebServlet("/Albums/details")
public class AlbumDetail extends HttpServlet {

    private static final String VUE_DETAIL_ALBUM = "/WEB-INF/website/albums/details.jsp";
    private AlbumDAO albumDAO;
    private EntityManagerFactory entityManagerFactory = null;
    private EntityManager entityManager = null;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            String id = request.getParameter("id");
            entityManagerFactory = Persistence.createEntityManagerFactory("sharing_pictures");
            entityManager = entityManagerFactory.createEntityManager();
            albumDAO = new AlbumDAO(entityManager);
            if (id != null) {


                    List<Image> imageList = albumDAO.listeImageFromAlbum(Integer.parseInt(id));
                    request.setAttribute("listeImg", imageList);

            }
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            entityManager.close();
        entityManagerFactory.close();}

        request.getRequestDispatcher(VUE_DETAIL_ALBUM).forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }
}
