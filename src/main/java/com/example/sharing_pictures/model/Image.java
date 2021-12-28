package com.example.sharing_pictures.model;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Image {

    @Id
    @GeneratedValue(strategy =  GenerationType.AUTO)
    private int id ;
    private String titre ;
    private String description ;
    private int hauteur;
    private int largeur;
    @Temporal(TemporalType.DATE)
    private Date dateCreation;
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateMAJ;
    private String location;

    @ManyToOne
    @JoinColumn(name = "album_id")
    private Album album;

    public Image(String titre, String description, int hauteur, int largeur, Date dateCreation, Date dateMAJ, String location, Album album) {
        this.description = description;
        this.hauteur = hauteur;
        this.largeur = largeur;
        this.titre = titre;
        this.dateCreation = dateCreation;
        this.dateMAJ = dateMAJ;
        this.location = location;
        this.album = album;
    }
}
