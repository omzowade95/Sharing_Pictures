package com.example.sharing_pictures.DAO.Utilisateur;

import com.example.sharing_pictures.model.Role;
import com.example.sharing_pictures.model.Utilisateur;

import javax.persistence.*;
import javax.swing.text.html.parser.Entity;
import java.util.ArrayList;
import java.util.List;
@PersistenceContext( unitName = "sharing_pictures" )
public class UtilisateurDAO implements IUtilisateur {
    private EntityManager  em;

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

    public Utilisateur getUser(String username)
    {
            Utilisateur utilisateur = null;
            entityManager.getTransaction().begin();
            Query query  = entityManager.createQuery("SELECT u FROM Utilisateur u WHERE u.username =:username");
            query.setParameter("username", username).getSingleResult();
            entityManager.getTransaction().commit();
            try{
                utilisateur = (Utilisateur) query.getSingleResult();
                System.out.println("Utilisateur: " + utilisateur.getPrenom());
            }catch (NoResultException e){
                return null;
            }
            catch (Exception e){

            }
            return utilisateur;

    }
}
