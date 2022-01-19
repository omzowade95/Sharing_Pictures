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
<<<<<<< HEAD
        this.entityManager = entityManager;
=======
        this.entityManagerFactory = Persistence.createEntityManagerFactory("sharing_pictures");
        this.entityManager = entityManagerFactory.createEntityManager();
    }
    public UtilisateurDAO(){
        this.entityManagerFactory = Persistence.createEntityManagerFactory("sharing_pictures");
        this.entityManager = entityManagerFactory.createEntityManager();
>>>>>>> aa400aa13695e3d0f6b8d37d5ecc59780ac629bb
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
        Utilisateur user = null;
        user = entityManager.find(Utilisateur.class,id);
        return user;
    }

    public Utilisateur getUser(String username)
    {
            Utilisateur utilisateur = null;
            Query query  = entityManager.createQuery("SELECT u FROM Utilisateur u WHERE u.username =:username");
            query.setParameter("username", username).getSingleResult();
            try{
                utilisateur = (Utilisateur) query.getSingleResult();
                System.out.println("Utilisateur: " + utilisateur.getPrenom());
            }catch (NoResultException e){
                utilisateur = null;
            }
            catch (Exception e){

            }
            return utilisateur;

    }
}
