package com.example.sharing_pictures.DAO.Image;

import com.example.sharing_pictures.model.Album;
import com.example.sharing_pictures.model.Image;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

public class ImageDAO implements IImage{

    private final EntityManager entityManager;

    public ImageDAO(EntityManager entityManager) {
        this.entityManager = entityManager;
    }


    @Override
    public void add(Image a) {
        entityManager.getTransaction().begin();
        entityManager.persist(a);
        entityManager.getTransaction().commit();

        this.entityManager.close();
    }

    @Override
    public boolean update(Image a) {
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
            Image s=entityManager.find(Image.class,id);
            entityManager.remove(s);
            entityManager.getTransaction().commit();
            bool = true ;
        }catch (Exception e){

        }

        return bool;

    }

    @Override
    public List<Image> listeImage() {
        Query query = entityManager.createQuery("select a from Image a", Image.class);
        return query.getResultList();
    }
}
