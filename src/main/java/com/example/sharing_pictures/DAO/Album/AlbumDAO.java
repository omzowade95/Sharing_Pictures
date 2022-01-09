package com.example.sharing_pictures.DAO.Album;

import com.example.sharing_pictures.model.Album;
import com.example.sharing_pictures.model.Status;

import javax.persistence.*;
import java.util.List;

public class AlbumDAO implements IAlbum {

    private final EntityManager entityManager ;

    public AlbumDAO(EntityManager entityManager) {
        this.entityManager = entityManager;
    }


    @Override
    public void add(Album a) {

        entityManager.getTransaction().begin();
        entityManager.persist(a);
        entityManager.getTransaction().commit();

        //this.entityManager.close();

    }



    @Override
    public boolean update(Album a) {

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
    public List<Album> listeAlbum() {

        Query query = entityManager.createQuery("select a from Album a", Album.class);
        return query.getResultList();
    }

    @Override
    public List<Album> getAlbumByStatus(Status status) {

       Query query  = entityManager.createQuery("SELECT r FROM Album r WHERE r.status = :status", Album.class)
                    .setParameter("status", status);

        return query.getResultList();
    }

    @Override
    public Album getAlbum(int id) {

        Album album = entityManager.find(Album.class, id);
        if (album == null) {
            return null ;
        }
        return album;
    }




}
