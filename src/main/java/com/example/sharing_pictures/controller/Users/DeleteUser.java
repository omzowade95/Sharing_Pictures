package com.example.sharing_pictures.controller.Users;

import com.example.sharing_pictures.DAO.Utilisateur.UtilisateurDAO;
import com.example.sharing_pictures.model.Utilisateur;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/deleteUser")
public class DeleteUser extends HttpServlet {
    private static final String VUE_LIST_USERS = "/WEB-INF/website/utilisateur/list.jsp";

    private Utilisateur utilisateur;
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("sharing_pictures");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        UtilisateurDAO utilisateurDAO = new UtilisateurDAO(entityManager);
        utilisateur = utilisateurDAO.getUser(Integer.parseInt(request.getParameter("id")));
        utilisateurDAO.deleteUser(utilisateur);
        entityManager.close();
        response.sendRedirect(request.getContextPath() + "/listUser");
    }


}
