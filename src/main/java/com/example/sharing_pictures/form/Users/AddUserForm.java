package com.example.sharing_pictures.form.Users;

import com.example.sharing_pictures.DAO.Utilisateur.UtilisateurDAO;
import com.example.sharing_pictures.model.Role;
import com.example.sharing_pictures.model.Rolename;
import com.example.sharing_pictures.model.Utilisateur;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.servlet.http.HttpServletRequest;

public class AddUserForm {
    private  static final String CHAMP_NOM = "nom";
    private  static final String CHAMP_PRENOM = "prenom";
    private  static final String CHAMP_LOGIN = "username";
    private  static final String CHAMP_PASSWORD = "pass";
    private  static final String CHAMP_PASSWORD_CONFIRM = "passConfirm";
    private  static final String CHAMP_ROLE = "role";

    private EntityManagerFactory entityManagerFactory = null;
    private EntityManager entityManager = null;
    private HttpServletRequest request;
    private Utilisateur utilisateur;
    private UtilisateurDAO utilisateurDAO = new UtilisateurDAO();
    private Role role;

    public AddUserForm(HttpServletRequest request){
        this.request = request ;
    }

    public boolean add(){
        String nom = getParameter(CHAMP_NOM);
        String prenom = getParameter(CHAMP_PRENOM);
        String username  = getParameter(CHAMP_LOGIN);
        String password = getParameter(CHAMP_PASSWORD);
        String role_name = getParameter(CHAMP_ROLE);

        entityManagerFactory = Persistence.createEntityManagerFactory("sharing_pictures");
        entityManager = entityManagerFactory.createEntityManager();

        Role role = entityManager.find(Role.class,Integer.parseInt(role_name));
        utilisateur = new Utilisateur(nom,prenom,username,password,role);

        utilisateurDAO.addUser(utilisateur , entityManager);

        if (utilisateur != null){
            utilisateur = null;
            return true;
        }
        return false;
    }

    private String getParameter(String parametre) {
        String valeur = request.getParameter(parametre);
        if(valeur == null || valeur.trim().isEmpty())
            return  null;

        return valeur;
    }
}
