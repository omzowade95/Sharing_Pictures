
package com.example.sharing_pictures.testJPA;

import com.example.sharing_pictures.DAO.Album.AlbumDAO;
import com.example.sharing_pictures.DAO.Image.ImageDAO;
import com.example.sharing_pictures.DAO.Utilisateur.UtilisateurDAO;
import com.example.sharing_pictures.model.*;
import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.engine.jdbc.BlobProxy;
import org.hibernate.type.LocalDateType;


import java.io.*;
import java.sql.Blob;
import java.time.LocalDate;
import java.util.Base64;
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

            Role roleA = new Role(Rolename.ADMIN);
            Role roleB = new Role(Rolename.USER);

            entityManager.getTransaction().begin();
            entityManager.persist(roleA);
            entityManager.persist(roleB);
            entityManager.getTransaction().commit();

            UtilisateurDAO ud = new UtilisateurDAO(entityManager);
            Utilisateur u = new Utilisateur("Balde","blandine","blanblan","passer",roleA);
            Utilisateur u2 = new Utilisateur("Balde","blandine","blanblan2","passer",roleB);

            //ud.addUser(u,entityManager);
            //ud.addUser(u2,entityManager);

        }catch (Exception e){

            e.printStackTrace();


        } finally {
            if ( entityManager != null ) entityManager.close();
            if ( entityManagerFactory != null ) entityManagerFactory.close();
        }
    }
}