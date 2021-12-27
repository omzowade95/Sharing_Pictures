package com.example.sharing_pictures.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.List;

@Entity
public class Role {

    @Id
    int id ;
    private Rolename role;


    @OneToMany(mappedBy = "role")
    private List<Utilisateur> utilisateurs;
}
