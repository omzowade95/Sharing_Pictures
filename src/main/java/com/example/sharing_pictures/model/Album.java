package com.example.sharing_pictures.model;

import org.hibernate.annotations.NaturalId;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Album {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)

    private int id ;

    private String nom;

    @Basic
    @Temporal(TemporalType.TIMESTAMP)
    private Date date ;

    @Enumerated(EnumType.STRING)
    @Column(length = 60)
    private Status status;

    @ManyToOne
    @JoinColumn(name = "utilisateur_id")
    private Utilisateur utilisateur;

    @ManyToOne
    @JoinColumn(name = "theme_id")
    private Theme theme;


    public Album(String nom, Date date, Status status, Utilisateur utilisateur, Theme theme) {
        this.nom = nom;
        this.date = date;
        this.status = status;
        this.utilisateur = utilisateur;
        this.theme = theme;
    }

    public Album() {

    }


    @Override
    public String toString() {
        return "Album{" +
                "id=" + id +
                ", nom='" + nom + '\'' +
                ", date=" + date +
                ", status=" + status +
                ", utilisateur=" + utilisateur.toString() +
                ", theme=" + theme.toString() +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public Utilisateur getUtilisateur() {
        return utilisateur;
    }

    public void setUtilisateur(Utilisateur utilisateur) {
        this.utilisateur = utilisateur;
    }

    public Theme getTheme() {
        return theme;
    }

    public void setTheme(Theme theme) {
        this.theme = theme;
    }
}
