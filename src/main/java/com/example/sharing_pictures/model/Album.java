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
    @NaturalId
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
}
