package com.example.sharing_pictures.model;

import javax.persistence.*;

@Entity
@Table(uniqueConstraints = {
        @UniqueConstraint(columnNames = {
                "username"
        })
})
public class Utilisateur {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id ;

    private String nom ;
    private String prenom ;
    private String username;
    private String password;

    @ManyToOne
    @JoinColumn(name = "role_id")
    private Role role;

    public Utilisateur() {
    }

    public Utilisateur(String nom, String prenom, String username, String password, Role role) {
        this.nom = nom;
        this.prenom = prenom;
        this.username = username;
        this.password = password;
        this.role = role;
    }
}










