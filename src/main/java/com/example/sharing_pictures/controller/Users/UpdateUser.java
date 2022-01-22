package com.example.sharing_pictures.controller.Users;

import com.example.sharing_pictures.DAO.Utilisateur.UtilisateurDAO;
import com.example.sharing_pictures.model.Role;
import com.example.sharing_pictures.model.Utilisateur;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.rmi.CORBA.Util;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/updateUser")
public class UpdateUser extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("idHide");
        String nom = request.getParameter("nom");
        String prenom = request.getParameter("prenom");
        String username = request.getParameter("username");
        String password = request.getParameter("pass");
        String role_name = request.getParameter("role");

        EntityManager entityManager;
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("sharing_pictures");
        entityManager = entityManagerFactory.createEntityManager();
        UtilisateurDAO utilisateurDAO = new UtilisateurDAO(entityManager);
        Role role = entityManager.find(Role.class,Integer.parseInt(role_name));

        Utilisateur utilisateur = new Utilisateur(nom,prenom,username,password,role);
        if(utilisateurDAO.updateUser(utilisateur,Integer.parseInt(id))){
            response.sendRedirect(request.getContextPath() + "/listUser");
        }
        else
            System.out.println("Echec Mise A Jour");

    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }
}
