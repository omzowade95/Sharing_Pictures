package com.example.sharing_pictures.model;

import org.hibernate.annotations.NaturalId;

import javax.persistence.*;
import java.util.List;

@Entity
public class Role{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id ;

    @Enumerated(EnumType.STRING)
    @NaturalId
    @Column(length = 60)
    private Rolename role;

    public Role(Rolename role) {
        this.role = role;
    }

    public Role() {

    }

    @Override
    public String toString() {
        return "Role{" +
                "id=" + id +
                ", role=" + role +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Rolename getRole() {
        return role;
    }

    public void setRole(Rolename role) {
        this.role = role;
    }
}
