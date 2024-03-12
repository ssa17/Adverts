package org.example.backend.user;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/login")
    String processLogin(Model model, @RequestParam String username, @RequestParam String password) {
        if (username.trim().isEmpty() || password.trim().isEmpty()) {
            model.addAttribute("error", "Username and password are required. controller");
            return "login";
        }

        if (userService.isValidUser(username, password)) {
            return "redirect:/adverts";
        } else {
            model.addAttribute("error", "Invalid username or password");
            return "redirect:/error";
        }
    }
}
