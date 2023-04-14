package com.example.registrationlogindemo.controller;

import com.example.registrationlogindemo.entity.User;
import com.example.registrationlogindemo.repository.UserRepository;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.ui.Model;


@Controller
public class UsersController {

    private final UserRepository userRepository; // khai báo đối tượng userRepository

    public UsersController(UserRepository userRepository) {
        this.userRepository = userRepository; // inject đối tượng userRepository vào trong constructor
    }

    @GetMapping("/users/delete/{id}")
    public String deleteUser(@PathVariable Long id, Model model) {
        userRepository.deleteById(id);
        model.addAttribute("users", userRepository.findAll());
        return "users/index";
    }
    @GetMapping("/users/edit/{id}")
    public String editUser(@PathVariable Long id, Model model) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid user Id:" + id));
        model.addAttribute("user", user);
        return "users/edit";
    }

    @PostMapping("/users/update")
    public String updateUser(@ModelAttribute("user") User user, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "users/edit";
        }

        userRepository.save(user);
        model.addAttribute("users", userRepository.findAll());
        return "users/index";
    }


}
