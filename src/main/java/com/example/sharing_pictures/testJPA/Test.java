
package com.example.sharing_pictures.testJPA;

import com.example.sharing_pictures.DAO.Album.AlbumDAO;
import com.example.sharing_pictures.DAO.Image.ImageDAO;
import com.example.sharing_pictures.model.Album;
import com.example.sharing_pictures.model.Image;
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
            AlbumDAO  al = new AlbumDAO(entityManager);
           Album a = al.getAlbum(1) ;
            ImageDAO img = new ImageDAO(entityManager);

            List<Image> l = img.listeImageFromAlbum(1);

            for (Image i:
                  l) {
                System.out.println(i.toString());
            }


        }catch (Exception e){

            e.printStackTrace();


        } finally {
            if ( entityManager != null ) entityManager.close();
            if ( entityManagerFactory != null ) entityManagerFactory.close();
        }
    }
}