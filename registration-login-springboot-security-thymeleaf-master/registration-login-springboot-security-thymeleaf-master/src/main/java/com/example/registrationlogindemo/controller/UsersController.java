package com.example.registrationlogindemo.controller;

import com.example.registrationlogindemo.entity.User;
import com.example.registrationlogindemo.repository.UserRepository;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.ui.Model;


@Controller
public class UsersController {

    private final UserRepository userRepository;

    public UsersController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @GetMapping("/delete/{id}")
    public String deleteUser(@PathVariable("id") long id) {
        userRepository.deleteById(id);
        return "redirect:/users";
    }

    @GetMapping("/users/edit/{id}")
    public String editUser(@PathVariable("id") Long id, Model model) {
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

