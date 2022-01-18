package com.example.sharing_pictures.DAO.Utilisateur;

import com.example.sharing_pictures.model.Role;
import com.example.sharing_pictures.model.Utilisateur;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.swing.text.html.parser.Entity;
import java.util.ArrayList;
import java.util.List;

public class UtilisateurDAO implements IUtilisateur {

    private EntityManager entityManager;
    private EntityManagerFactory entityManagerFactory;

    public UtilisateurDAO(){
        this.entityManagerFactory = Persistence.createEntityManagerFactory("sharing_pictures");
        this.entityManager = entityManagerFactory.createEntityManager();
    }
    @Override
    public void addUser(Utilisateur utilisateur) {
        entityManager.getTransaction().begin();
        entityManager.persist(utilisateur);
        entityManager.getTransaction().commit();
    }

    @Override
    public boolean updateUser(UtilisateurDAO utilisateurDAO) {
        return false;
    }

    @Override
    public void deleteUser(Utilisateur utilisateur) {
        entityManager.getTransaction().begin();
        entityManager.remove(utilisateur);
        entityManager.getTransaction().commit();
    }

    @Override
    public List<Utilisateur> listUser() {
        List<Utilisateur> utilisateurList = new ArrayList<>();
        entityManager.getTransaction().begin();
        utilisateurList = entityManager.createQuery("SELECT i FROM Utilisateur i ").getResultList();
        entityManager.getTransaction().commit();

        return utilisateurList;
    }
    public boolean searchUsername(String username){
        List<String> usernames = new ArrayList<>();
        entityManager.getTransaction().begin();
        usernames = entityManager.createQuery("SELECT u.username FROM Utilisateur u").getResultList();
        entityManager.getTransaction().commit();

        for (String login : usernames){
            if(username.equals(login))
                return true;
        }
        return false;
    }
    @Override
    public UtilisateurDAO getUser(int id) {
        return null;
    }
}
