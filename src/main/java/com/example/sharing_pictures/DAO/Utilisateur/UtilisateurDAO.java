package com.example.sharing_pictures.DAO.Utilisateur;

import com.example.sharing_pictures.model.Role;
import com.example.sharing_pictures.model.Utilisateur;

import javax.persistence.*;
import javax.swing.text.html.parser.Entity;
import java.util.List;
@PersistenceContext( unitName = "sharing_pictures" )
public class UtilisateurDAO implements IUtilisateur {
    private EntityManager  em;

    public UtilisateurDAO(){}
    public UtilisateurDAO(EntityManager entityManager){
        this.em = entityManager;
    }
    @Override
    public void addUser(Utilisateur utilisateur , EntityManager entityManager) {
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

    public Utilisateur getUser(String username)
    {
        Utilisateur utilisateur = null;

            Query query  = em.createQuery("SELECT u FROM Utilisateur u WHERE u.username =:username");
            query.setParameter("username", username).getSingleResult();
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
