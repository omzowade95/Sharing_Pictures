package com.example.sharing_pictures.DAO.Theme;

import com.example.sharing_pictures.model.Album;
import com.example.sharing_pictures.model.Theme;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

public class ThemeDAO implements ITheme{

    private final EntityManager entityManager ;

    public ThemeDAO(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public void add(Theme a) {
        entityManager.getTransaction().begin();
        entityManager.persist(a);
        entityManager.getTransaction().commit();

       // this.entityManager.close();
    }

    @Override
    public boolean update(Theme a) {
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
    public List<Theme> listeTheme() {
        Query query = entityManager.createQuery("select a from Theme a", Theme.class);
        return query.getResultList();
    }

    @Override
    public Theme getTheme(String libelle) {
        Query query = entityManager.createQuery("select a from Theme a where a.libelle = :libelle", Theme.class).setParameter("libelle",libelle);
        Theme theme = null;

        List<Theme> results = query.getResultList();
        if (!results.isEmpty())
            theme = results.get(0);

        return theme;
    }
}
