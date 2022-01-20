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
import java.io.Console;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet("/Albums/searchUser")
public class SearchUserController extends HttpServlet {

    private EntityManagerFactory entityManagerFactory = null;
    private EntityManager entityManager = null;
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        try {
            entityManagerFactory = Persistence.createEntityManagerFactory("sharing_pictures");
            entityManager = entityManagerFactory.createEntityManager();

            String username = request.getParameter("username");
            UtilisateurDAO dao = new UtilisateurDAO(entityManager);
            List<Utilisateur> u = dao.getUser(username);
            String user ;
            if(u.size() > 0){
                 user = Integer.toString(u.get(0).getId());
            }else{
                user = "undefined";
            }
            //String gson = new Gson().toJson(u);
            //String utilisateurTrouve = gson.toJson(u);
            //System.out.println("Server: pass: " + utilisateurTrouve);
            //response.setContentType("application/json");
            // response.setCharacterEncoding("UTF-8");

            System.out.println("response: " + user);
            response.getWriter().write(user);
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            entityManager.close();
            entityManagerFactory.close();
        }
    }
}
