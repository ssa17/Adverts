package org.example.backend.user;

import jakarta.persistence.*;
import org.example.backend.advert.Advert;

import java.io.Serializable;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name="users")
public class User implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(nullable = false)
    private String username; // Add username property

    @Column(nullable = false)
    private String password;

    @OneToMany(mappedBy = "user")
    private List<Advert> adverts;

    // ... additional members, often include @OneToMany mappings

    protected User() {
        // no-args constructor required by JPA spec
        // this one is protected since it should not be used directly
    }

    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public UUID getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

}

