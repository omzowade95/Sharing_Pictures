package com.example.sharing_pictures.controller.User;

import com.example.sharing_pictures.DAO.Utilisateur.UtilisateurDAO;
import com.example.sharing_pictures.model.Album;
import com.example.sharing_pictures.model.Utilisateur;
import com.google.gson.Gson;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/Albums/searchUser")
public class SearchUserController extends HttpServlet {
    private Gson gson;
    private EntityManagerFactory entityManagerFactory = null;
    private EntityManager entityManager = null;
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        entityManagerFactory = Persistence.createEntityManagerFactory("sharing_pictures");
        entityManager = entityManagerFactory.createEntityManager();

        String username = request.getParameter("username");
        UtilisateurDAO dao = new UtilisateurDAO();
        Utilisateur u = dao.getUser(username);
        String utilisateurJsonString = new Gson().toJson(u);

        PrintWriter out = response.getWriter();
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        out.print(utilisateurJsonString.toString());
        out.flush();
    }
}
