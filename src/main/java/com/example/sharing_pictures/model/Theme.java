package com.example.sharing_pictures.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Theme {
    @Id
    @GeneratedValue(strategy =  GenerationType.AUTO)
    private int id ;

    private String libelle;

    public Theme(){

    }

    public Theme(String libelle) {
        this.libelle = libelle;
    }
}
