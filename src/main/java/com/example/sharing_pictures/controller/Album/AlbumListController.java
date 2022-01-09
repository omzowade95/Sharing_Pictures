package com.example.sharing_pictures.controller.Album;

import com.example.sharing_pictures.DAO.Album.AlbumDAO;
import com.example.sharing_pictures.DAO.Image.ImageDAO;
import com.example.sharing_pictures.model.Album;
import com.example.sharing_pictures.model.Image;
import com.example.sharing_pictures.model.Status;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.File;
import java.io.IOException;
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


   /* @Override
    public void init() throws ServletException {
        uploadPath = getServletContext().getRealPath( "/" );
        File uploadDir = new File( uploadPath );
        if ( ! uploadDir.exists() ) uploadDir.mkdir();
    }*/

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        for ( Part part : request.getParts() ) {
            String fileName = getFileName( part );
            String fullPath = uploadPath + File.separator + fileName;
            part.write( fullPath );
            System.out.println(fullPath);
            System.out.println("okkkk");
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("activeAlbum", true);

        try {
            entityManagerFactory = Persistence.createEntityManagerFactory("sharing_pictures");
            entityManager = entityManagerFactory.createEntityManager();
            album = new AlbumDAO(entityManager);
            List<Album> albumList = album.getAlbumByStatus(Status.PUBLIC) ;

            request.setAttribute("listAlbum", albumList);
            for (Album a: albumList ) {
                System.out.println(a.toString());

            }

        }catch (Exception e){

            e.printStackTrace();


        } finally {

        }

        request.getRequestDispatcher(VUE_lIST_ALBUM).forward(request, response);
    }

    private String getFileName( Part part ) {
        for ( String content : part.getHeader( "content-disposition" ).split( ";" ) ) {
            if ( content.trim().startsWith( "filename" ) )
                return content.substring( content.indexOf( "=" ) + 2, content.length() - 1 );
        }
        return "Default.file";
    }
}
