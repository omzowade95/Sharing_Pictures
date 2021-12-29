
package com.example.sharing_pictures.testJPA;

import com.example.sharing_pictures.DAO.Album.AlbumDAO;
import com.example.sharing_pictures.model.Album;
import com.example.sharing_pictures.model.Utilisateur;


import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;


public class Test {

    public static void main(String[] args) throws Exception {
        EntityManagerFactory entityManagerFactory = null;
        EntityManager entityManager = null;
        try {
            entityManagerFactory = Persistence.createEntityManagerFactory("sharing_pictures");
            entityManager = entityManagerFactory.createEntityManager();

            AlbumDAO ab = new AlbumDAO(entityManager);

            Album a = ab.getAlbum(1);
            System.out.println("okk");
            System.out.println(a.toString());
            System.out.println("okk");

            //entityManager.close();
           //
            // *entityManagerFactory.close();


        }catch (Exception e){

            e.printStackTrace();


        } finally {
            if ( entityManager != null ) entityManager.close();
            if ( entityManagerFactory != null ) entityManagerFactory.close();
        }
    }
}