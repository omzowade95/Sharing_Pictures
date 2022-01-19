package com.example.sharing_pictures.DAO.Image;

import com.example.sharing_pictures.model.Album;
import com.example.sharing_pictures.model.Image;
import com.example.sharing_pictures.model.Theme;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
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

    public Image getImage(int id){
        Query query = entityManager.createQuery("select a from Image a where a.id = :id", Image.class).setParameter("id",id);
        Image theme = null;

        List<Image> results = query.getResultList();
        if (!results.isEmpty())
            theme = results.get(0);

        return theme;
    }

    @Override
    public  List<Image> listeImageFromAlbum(int idA) {
        List results =entityManager.createQuery("SELECT r FROM Image  r WHERE r.album.id = :idA", Image.class)
                        .setParameter("idA", idA).getResultList();
       // results = query.getResultList();
        return results;

    }
}
