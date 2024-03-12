package org.example.backend.advert;

import jakarta.transaction.Transactional;
import org.example.backend.advert.Advert;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.UUID;

@Transactional
public interface AdvertRepository extends CrudRepository<Advert, UUID> {

    List<Advert> findAll();

    List<Advert> findByNameContainingAllIgnoringCase(String name);

    Advert save(Advert advert);

    String deleteAdvertsById(UUID advertId);

}


