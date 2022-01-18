package com.example.sharing_pictures.DAO.Utilisateur;

import com.example.sharing_pictures.model.Role;
import com.example.sharing_pictures.model.Utilisateur;

import javax.persistence.EntityManager;
import java.util.List;

public interface IUtilisateur {

    public void addUser(Utilisateur utilisateur, EntityManager entityManager);
    public boolean updateUser(UtilisateurDAO utilisateurDAO);
    public boolean deleteUser(int id);

    public List<UtilisateurDAO> listUser();
    public UtilisateurDAO getUser(int id);
}
