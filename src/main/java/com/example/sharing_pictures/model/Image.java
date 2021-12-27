package com.example.sharing_pictures.model;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Image {

    @Id
    @GeneratedValue(strategy =  GenerationType.AUTO)
    private int id ;
    private String description ;
    private int hauteur;
    private int largeur;
    private String titre ;
    @Temporal(TemporalType.DATE)
    private Date dateCreation;
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateMAJ;
    private String location;

    @ManyToOne
    @JoinColumn(name = "album_id")
    private Album album;

}
