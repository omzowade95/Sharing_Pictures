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

    public Image() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getHauteur() {
        return hauteur;
    }

    public void setHauteur(int hauteur) {
        this.hauteur = hauteur;
    }

    public int getLargeur() {
        return largeur;
    }

    public void setLargeur(int largeur) {
        this.largeur = largeur;
    }

    public Date getDateCreation() {
        return dateCreation;
    }

    public void setDateCreation(Date dateCreation) {
        this.dateCreation = dateCreation;
    }

    public Date getDateMAJ() {
        return dateMAJ;
    }

    public void setDateMAJ(Date dateMAJ) {
        this.dateMAJ = dateMAJ;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public Album getAlbum() {
        return album;
    }

    public void setAlbum(Album album) {
        this.album = album;
    }
}
