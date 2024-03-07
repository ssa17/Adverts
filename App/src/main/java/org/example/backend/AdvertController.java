package org.example.backend;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;
import java.util.UUID;

@Controller
public class AdvertController {

    private final AdvertService advertService;


    AdvertController(AdvertService advertService) {
        this.advertService = advertService;
    }

//    @GetMapping("/adverts")
//    String allAdverts(Model model) {
//        List<Advert> adverts = advertService.getAllAdverts();
//        model.addAttribute("adverts", adverts);
//        return "adverts";
//    }

//    @GetMapping("/adverts/{name}")
//    String findAdverts(@PathVariable String name, Model model) {
//        List<Advert> adverts = advertService.findByNameAllIgnoringCase(name);
//        model.addAttribute("adverts", adverts);
//        return "adverts";
//    }

    @GetMapping("/adverts")
    String findAdverts(@RequestParam(name = "name", required = false) String name,
                       @RequestParam(name = "reset", required = false) String reset,
                       Model model) {
        if (Objects.equals(reset, "reset")) {
            return "redirect:/adverts";
        }
        if (name != null) {
            List<Advert> adverts = advertService.findByNameAllIgnoringCase(name);
            model.addAttribute("adverts", adverts);
        } else {
            // If no name is provided, handle it accordingly (e.g., show all adverts)
            List<Advert> allAdverts = advertService.getAllAdverts();
            model.addAttribute("adverts", allAdverts);
        }

        return "adverts";
    }


    @GetMapping("/add-advert")
    public String advertForm(Model model) {
        model.addAttribute("advert", new Advert());
        return "add_advert";
    }

    @PostMapping("/add_advert")
    public String advertSave(@ModelAttribute Advert advert, Model model) {;
        model.addAttribute("advert", advert);
        advertService.save(advert);
        return "redirect:/adverts";
    }

    @RequestMapping(value = "/delete_advert", method = RequestMethod.GET)
    public String handleDeleteAdvert(@RequestParam(name="id") UUID id) {
        advertService.deleteAdvertsById(id);
        return "redirect:/adverts";
    }

}

