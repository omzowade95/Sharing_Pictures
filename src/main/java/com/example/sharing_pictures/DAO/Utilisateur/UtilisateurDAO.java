package com.example.sharing_pictures.DAO.Utilisateur;

import com.example.sharing_pictures.model.Role;
import com.example.sharing_pictures.model.Utilisateur;

import javax.persistence.*;
import javax.swing.text.html.parser.Entity;
import java.util.ArrayList;
import java.util.List;
@PersistenceContext( unitName = "sharing_pictures" )
public class UtilisateurDAO implements IUtilisateur {

    private EntityManager entityManager;

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
    public Utilisateur getUser(int id) {
        entityManager.getTransaction().begin();
        Utilisateur user = null;
        user = entityManager.find(Utilisateur.class,id);
        entityManager.getTransaction().commit();
        return user;
    }

    public List<Utilisateur> getUser(String username)
    {
        List<Utilisateur> utilisateurs = null;
            //Utilisateur utilisateur = null;
            entityManager.getTransaction().begin();
            Query query  = entityManager.createQuery("FROM Utilisateur u WHERE u.username =:username", Utilisateur.class);
            query.setParameter("username", username);
            try{
                System.out.println("requet: " + query);

                utilisateurs =  query.getResultList();
               System.out.println("taille: " + utilisateurs.size());
               // System.out.println("Utilisateur: " + utilisateur.getPrenom());

                entityManager.getTransaction().commit();
                entityManager.close();
            }catch (NoResultException e){
                e.printStackTrace();
            }


            return utilisateurs;

    }
}
