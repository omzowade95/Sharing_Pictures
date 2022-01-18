package com.example.sharing_pictures.form.Users;

import com.example.sharing_pictures.model.Utilisateur;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.servlet.http.HttpServletRequest;

public class AuthenticationForm {
    private HttpServletRequest request;
    private static final String CHAMP_USERNAME = "username";
    private static final String CHAMP_PASSWORD = "pass";
    private EntityManager entityManager;
    private EntityManagerFactory entityManagerFactory;

    private Utilisateur utilisateur;
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

        /*entityManagerFactory = Persistence.createEntityManagerFactory("sharing_pictures");
        entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();*/

        if(utilisateur != null)
            return true;
        else
            return false;
    }

}
