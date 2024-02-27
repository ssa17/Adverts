package org.example.backend;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

import java.io.Serializable;

@Entity
public class Adverts implements Serializable {

    @Id
    @GeneratedValue
    private String id;

    @Column(nullable = false)
    private String name;

    @Column()
    private String link;

    // ... additional members, often include @OneToMany mappings

    protected Adverts() {
        // no-args constructor required by JPA spec
        // this one is protected since it should not be used directly
    }

    public Adverts(String name, String link) {
        this.name = name;
        this.link = link;
    }

    public String getName() {
        return this.name;
    }

    public String getLink() {
        return this.link;
    }

    // ... etc

}
