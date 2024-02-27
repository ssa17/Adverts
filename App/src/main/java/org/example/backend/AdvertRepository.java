package org.example.backend;

import org.springframework.data.repository.Repository;

import java.util.List;

public interface AdvertRepository extends Repository<Adverts, String> {

    List<Adverts> findAll();

    Adverts findByNameAndLinkAllIgnoringCase(String name, String link);

}


