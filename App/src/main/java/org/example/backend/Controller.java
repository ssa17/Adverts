package org.example.backend;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
public class Controller {

    private AdvertRepository advertRepository;

    public Controller(AdvertRepository advertRepository) {
        this.advertRepository = advertRepository;
    }

    @GetMapping("/hello")
    public List<Adverts> hello() {
         return advertRepository.findAll();
    }
}
