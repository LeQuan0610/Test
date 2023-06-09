package com.example.registrationlogindemo.controller;

import com.example.registrationlogindemo.entity.User;
import com.example.registrationlogindemo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.ui.Model;


@Controller
public class UsersController {

    @Autowired
    private UserRepository userRepository;

//    public UsersController(UserRepository userRepository) {
//        this.userRepository = userRepository;
//    }
    @GetMapping("/edit")
    public String showEditPage() {
        return "editUser";
    }

    @PostMapping("/delete/{id}")
    public String deleteUser(@PathVariable("id") Long id) {
        userRepository.deleteById(id);
        return "redirect:/users";
    }

//    @DeleteMapping("/{id}")
//    public String delete(@PathVariable("id") Long id) {
//        userService.delete(id);
//        return "redirect:/users";
//    }



    @GetMapping("/users/edit/{id}")
    public String editUser(@PathVariable Long id, Model model) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid user Id:" + id));
        model.addAttribute("user", user);
        return "users/edit";
    }

    @PostMapping("/users/update")
    public String updateUser(@RequestBody User user, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "users/edit";
        }
        userRepository.save(user);
        model.addAttribute("users", userRepository.findAll());
        return "users/index";
    }
}

