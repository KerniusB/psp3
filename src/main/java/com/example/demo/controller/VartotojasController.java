package com.example.demo.controller;

import com.example.demo.model.User;
import com.example.demo.service.CashRegisterService;
import com.example.demo.validators.EmailValidator.EmailValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;

@Controller
public class VartotojasController {


    private EmailValidator emailValidator = new EmailValidator();

    @Autowired
    private CashRegisterService vartotojasService;

    //@RequestMapping(value = "/", method= RequestMethod.GET)
    @GetMapping("/vartotojas")
    public String getVartotojai(ModelMap model) {
        model.put("vartotojai", vartotojasService.findAll());
        return "vartotojas"; // view resolver /WEB-INF/jsp/welcome.jsp
    }

    @GetMapping("/add-vartotojas")
    public String showAddPage(ModelMap model) {
        model.addAttribute("vartotojas", new User());
        return "add-vartotojas";
    }

    @PostMapping("/add-vartotojas")
    public String add(ModelMap model, @ModelAttribute("vartotojas") User vartotojas, BindingResult result) {
        if (!emailValidator.isValid(vartotojas.getEmail(), Arrays.asList("!"), Arrays.asList("gmail.com"))) {
            model.addAttribute("errorMessage", "Not valid email input!");
            return "add-vartotojas";
        }
        vartotojasService.add(vartotojas);
        System.out.println();
        return "redirect:/vartotojas";
    }

    @GetMapping("/update-vartotojas/{id}")
    public String showUpdatePage(ModelMap model, @PathVariable long id) {
        model.addAttribute("vartotojas", vartotojasService.findById(id));
        return "add-vartotojas";
    }

    @PostMapping("/update-vartotojas/{id}")
    public String update(ModelMap model, @ModelAttribute("vartotojas") User vartotojas, BindingResult result) {
        if (result.hasErrors()) {
            return "add-vartotojas";
        }
        vartotojasService.update(vartotojas);
        return "redirect:/vartotojas";
    }

    @GetMapping("/delete-vartotojas/{id}")
    public String delete(@PathVariable long id) {
        vartotojasService.deleteById(id);
        return "redirect:/vartotojas";
    }

}
