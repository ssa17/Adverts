package org.example.backend.advert;

import org.example.backend.advert.Advert;
import org.example.backend.advert.AdvertRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
class AdvertService {

    private final AdvertRepository advertRepository;

    public AdvertService(AdvertRepository advertRepository) {
        this.advertRepository = advertRepository;
    }

    public List<Advert> getAllAdverts() {
        return advertRepository.findAll();
    }

    public List<Advert> findByNameAllIgnoringCase(String make) {
        return advertRepository.findByNameContainingAllIgnoringCase(make);
    }

    public void save(Advert advert) {
        advertRepository.save(advert);
    }

    public void deleteAdvertsById(UUID advertId) {
        advertRepository.deleteAdvertsById(advertId);
    }
}
