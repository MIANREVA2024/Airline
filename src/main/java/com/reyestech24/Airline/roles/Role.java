package com.reyestech24.Airline.roles;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.reyestech24.Airline.User.User;
import jakarta.persistence.*;

import java.util.Set;

@Entity
@Table(name = "roles")
public class Role {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_role", nullable = false)
    private Long id;
    private String name;

    public Role() {
    }

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }

    @JsonIgnore
    @ManyToMany(mappedBy = "roles")
    Set<User> users;

    public String getName() {
        return name;
    }
}