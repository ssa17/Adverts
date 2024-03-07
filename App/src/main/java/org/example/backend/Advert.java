package org.example.backend;

import jakarta.persistence.*;

import java.io.Serializable;
import java.util.UUID;

@Entity
@Table(name="adverts")
public class Advert implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    public UUID id;

    @Column(nullable = false)
    public String name;

    @Column()
    public String link;

    // ... additional members, often include @OneToMany mappings

    protected Advert() {
        // no-args constructor required by JPA spec
        // this one is protected since it should not be used directly
    }

    public UUID getId() {
        return id;
    }

    public Advert(String name, String link) {
        this.name = name;
        this.link = link;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String getLink() {
        return this.link;
    }

    // ... etc

}

