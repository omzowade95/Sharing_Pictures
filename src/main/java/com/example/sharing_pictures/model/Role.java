package com.example.sharing_pictures.model;

import org.hibernate.annotations.NaturalId;

import javax.persistence.*;
import java.util.List;

@Entity
public class Role{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    int id ;

    @Enumerated(EnumType.STRING)
    @NaturalId
    @Column(length = 60)
    private Rolename role;

    public Role(Rolename role) {
        this.role = role;
    }
}
