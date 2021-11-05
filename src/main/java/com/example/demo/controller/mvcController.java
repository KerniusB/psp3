package com.example.demo.controller;

import com.example.demo.model.User;
import com.example.demo.service.CashRegisterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class mvcController {


    @Autowired
    private CashRegisterService userService;

    @GetMapping("/mvc")
    public String getKazkas(ModelMap model){
        return "welcome";
    }

    @GetMapping("/add-user")
    public String showAddPage(ModelMap model) {
        model.addAttribute("vartotojas", new User());
        return "add-user";
    }

    @PostMapping("/add-user")
    public String add(ModelMap model, @ModelAttribute("vartotojas") User user, BindingResult result) {
        if (result.hasErrors()) {
            return "add-user";
        }
        userService.add(user);
        return "redirect:/user";
    }

    @GetMapping("/update-user/{id}")
    public String showUpdatePage(ModelMap model, @PathVariable long id) {
        model.addAttribute("vartotojas", userService.findById(id));
        return "add-user";
    }

    @PostMapping("/update-user/{id}")
    public String update(ModelMap model, @ModelAttribute("vartotojas") User user, BindingResult result) {
        if (result.hasErrors()) {
            return "add-user";
        }
        userService.update(user);
        return "redirect:/ ";
    }

    @GetMapping("/delete-user/{id}")
    public String delete(@PathVariable long id) {
        userService.deleteById(id);
        return "redirect:/user";
    }
}
