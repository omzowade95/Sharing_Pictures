package com.example.sharing_pictures.DAO.Authorisation;

import com.example.sharing_pictures.model.Album;
import com.example.sharing_pictures.model.Authorisation;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

public class AuthorisationDAO implements IAuthorisation{

    private final EntityManager entityManager ;

    public AuthorisationDAO(EntityManager entityManager) {
        this.entityManager = entityManager;
    }


    @Override
    public void add(Authorisation a) {
        entityManager.getTransaction().begin();
        entityManager.persist(a);
        entityManager.getTransaction().commit();
    }

    @Override
    public boolean update(Authorisation a) {
        Boolean bool = false;
        try {
            entityManager.getTransaction().begin();
            entityManager.merge(a);
            entityManager.getTransaction().commit();
            bool = true ;
        }catch (Exception e){

        }

        return bool;
    }

    @Override
    public boolean delete(int id) {
        Boolean bool = false;
        try {
            entityManager.getTransaction().begin();
            Album s=entityManager.find(Album.class,id);
            entityManager.remove(s);
            entityManager.getTransaction().commit();
            bool = true ;
        }catch (Exception e){

        }

        return bool;
    }

    @Override
    public List<Authorisation> listeAuth(int idUser) {
        Query query = entityManager.createQuery("select a from Authorisation a where a.utilisateur.id = :idUser", Authorisation.class).setParameter("idUser", idUser);
        return query.getResultList();
    }
}
