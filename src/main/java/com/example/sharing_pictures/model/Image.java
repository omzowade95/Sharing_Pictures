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
    private String dateCreation;
    private String dateMAJ;

    @Lob
    private byte[] location;

    @ManyToOne
    @JoinColumn(name = "album_id")
    private Album album;

    public Image(String titre, String description, int hauteur, int largeur, String dateCreation, String dateMAJ, byte[] location, Album album) {
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

    public String getDateCreation() {
        return dateCreation;
    }

    public void setDateCreation(String dateCreation) {
        this.dateCreation = dateCreation;
    }

    public String getDateMAJ() {
        return dateMAJ;
    }

    public void setDateMAJ(String dateMAJ) {
        this.dateMAJ = dateMAJ;
    }

    public byte[] getLocation() {
        return location;
    }

    public void setLocation(byte[] location) {
        this.location = location;
    }

    public Album getAlbum() {
        return album;
    }

    public void setAlbum(Album album) {
        this.album = album;
    }
}
