
package com.example.sharing_pictures.testJPA;

import com.example.sharing_pictures.DAO.Album.AlbumDAO;
import com.example.sharing_pictures.DAO.Image.ImageDAO;
import com.example.sharing_pictures.model.Album;
import com.example.sharing_pictures.model.Image;
import com.example.sharing_pictures.model.Utilisateur;
import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.engine.jdbc.BlobProxy;
import org.hibernate.type.LocalDateType;


import java.io.*;
import java.sql.Blob;
import java.time.LocalDate;
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

           /* String path = "C:/Users/User/Pictures/Screenshots/img.png";
            File f = new File(path);
            InputStream fstream = new FileInputStream(f);
            ByteArrayOutputStream buffer = new ByteArrayOutputStream();

            int nRead;
            byte[] data = new byte[16384];

            while ((nRead = fstream.read(data, 0, data.length)) != -1) {
                buffer.write(data, 0, nRead);
            }

             buffer.toByteArray();


            Image im = new Image("blandine","bbbbbb",2,3, LocalDate.now().toString(),LocalDate.now().toString(), buffer.toByteArray(),a);

            img.add(im);*/

        }catch (Exception e){

            e.printStackTrace();


        } finally {
            if ( entityManager != null ) entityManager.close();
            if ( entityManagerFactory != null ) entityManagerFactory.close();
        }
    }
}