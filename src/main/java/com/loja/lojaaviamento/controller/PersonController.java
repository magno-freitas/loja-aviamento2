package com.loja.lojaaviamento.controller;

import com.loja.lojaaviamento.model.Person;
import com.loja.lojaaviamento.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/people")
public class PersonController {
    @Autowired
    private PersonService service;

    @GetMapping
    public String list(Model model) {
        model.addAttribute("people", service.listAll());
        return "people/list";
    }

    @GetMapping("/new")
    public String showForm(Model model) {
        model.addAttribute("person", new Person());
        return "people/form";
    }

    @PostMapping
    public String save(@ModelAttribute Person person) {
        service.save(person);
        return "redirect:/people";
    }

    @GetMapping("/edit/{id}")
    public String edit(@PathVariable Long id, Model model) {
        model.addAttribute("person", service.findById(id).orElse(new Person()));
        return "people/form";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable Long id) {
        service.delete(id);
        return "redirect:/people";
    }
}