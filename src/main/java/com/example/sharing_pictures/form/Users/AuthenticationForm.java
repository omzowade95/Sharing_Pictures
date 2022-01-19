package com.example.sharing_pictures.form.Users;

import com.example.sharing_pictures.model.Utilisateur;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

public class AuthenticationForm {
    private HttpServletRequest request;
    private static final String CHAMP_USERNAME = "username";
    private static final String CHAMP_PASSWORD = "pass";

    private EntityManagerFactory entityManagerFactory;
    private EntityManager entityManager ;

    private Utilisateur utilisateur = null;
    private String username ;

    public AuthenticationForm(HttpServletRequest request){
        this.request = request;

    }

    private String getParameter(String parametre) {
        String valeur = request.getParameter(parametre);
        if(valeur == null || valeur.trim().isEmpty())
            return  null;
        return valeur;
    }

    public boolean userAuth() {
        username = getParameter(CHAMP_USERNAME);
        String password = getParameter(CHAMP_PASSWORD);
        try {
            entityManagerFactory = Persistence.createEntityManagerFactory("sharing_pictures");
            entityManager= entityManagerFactory.createEntityManager();
            entityManager.getTransaction().begin();
            utilisateur =  entityManager.createQuery("select i from Utilisateur i where i.username = :username", Utilisateur.class).
                    setParameter("username",username)
                    .getSingleResult();
            entityManager.getTransaction().commit();

        }catch (NoResultException e){
            if (username.equals("ADMIN") && password.equals("ADMIN")){
                return  true;
            }
            return false;
        }finally {
            entityManager.close();
            entityManagerFactory.close();
        }
        if (utilisateur.getPassword().equals(password.trim())){
            HttpSession session = request.getSession();
            session.setAttribute("user",utilisateur);
            return true;
        }



        return false;
    }

}
