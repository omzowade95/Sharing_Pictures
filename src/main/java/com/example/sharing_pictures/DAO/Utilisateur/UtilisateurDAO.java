package com.example.sharing_pictures.DAO.Utilisateur;

import com.example.sharing_pictures.model.Utilisateur;

import javax.persistence.EntityManager;
import javax.swing.text.html.parser.Entity;
import java.util.List;

public class UtilisateurDAO implements IUtilisateur {
    private final EntityManager entityManager;

    public UtilisateurDAO(EntityManager entityManager){
        this.entityManager = entityManager;
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
    public boolean deleteUser(int id) {
        return false;
    }

    @Override
    public List<UtilisateurDAO> listUser() {
        return null;
    }

    @Override
    public UtilisateurDAO getUser(int id) {
        return null;
    }
}
