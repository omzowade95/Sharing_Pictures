package com.example.sharing_pictures.controller.Album;

import com.example.sharing_pictures.DAO.Album.AlbumDAO;
import com.example.sharing_pictures.DAO.Theme.ThemeDAO;
import com.example.sharing_pictures.model.Album;
import com.example.sharing_pictures.model.Theme;

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
import java.time.LocalDate;


@WebServlet(name="operation" , urlPatterns= {"/Albums/update","/Albums/delete"})
public class FormAction extends HttpServlet {

    private static final String VUE_UPDATE = "/WEB-INF/website/albums/modifier.jsp";
    EntityManagerFactory entityManagerFactory ;
    EntityManager entityManager;
    private static final String CHAMP_THEME="theme";
    private static final String CHAMP_NOM="nomAlbum";
    private static final String CHAMP_STATUS="statue";

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            StringBuffer url = request.getRequestURL();
            entityManagerFactory = Persistence.createEntityManagerFactory("sharing_pictures");
            entityManager = entityManagerFactory.createEntityManager();
            AlbumDAO albumDAO = new AlbumDAO(entityManager);
            String id = request.getParameter("id");
            Album albUp = new Album();


            int o = url.indexOf("update");
            if (o != -1) {
                if (id != null){
                    int ida = Integer.parseInt(id);
                    albUp= albumDAO.getAlbum(ida);
                    System.out.println(albUp);
                    if (albUp != null){
                        request.setAttribute("al",albUp);
                        request.getServletContext().getRequestDispatcher(VUE_UPDATE).forward(request, response);
                    }else {
                        response.sendRedirect(request.getContextPath()+"/Albums/myAlbum");
                    }

                }


            }else {

                id = request.getParameter("id");

                if (id != null && id.matches("[0-9]+")) {
                    albumDAO.delete(Integer.parseInt(id));
                    response.sendRedirect(request.getContextPath()+"/Albums/myAlbum");
                }

            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            entityManager.close();
            entityManagerFactory.close();
        }

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            StringBuffer url = request.getRequestURL();
            int o = url.indexOf("update");
            HttpSession session = request.getSession();

            if (o != -1) {
                entityManagerFactory = Persistence.createEntityManagerFactory("sharing_pictures");
                entityManager = entityManagerFactory.createEntityManager();
                AlbumDAO albumDAO = new AlbumDAO(entityManager);
                ThemeDAO themeDAO = new ThemeDAO(entityManager);

                Album al = new Album();
                Theme theme = themeDAO.getTheme( request.getParameter(CHAMP_THEME));
                if (theme == null) {
                    themeDAO.add(new Theme(request.getParameter(CHAMP_THEME)));
                    theme = themeDAO.getTheme( request.getParameter(CHAMP_THEME));
                }
                al.setTheme(theme);
                al.setNom(request.getParameter(CHAMP_NOM));
                al.setDate(LocalDate.now().toString());

                if (albumDAO.update(al)) {
                    response.sendRedirect(request.getContextPath()+"/Albums/myAlbum");

                }else {
                    response.sendRedirect(request.getContextPath()+"/Albums/myAlbum");
                }

            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
entityManager.close();
entityManagerFactory.close();

    }

}
}
