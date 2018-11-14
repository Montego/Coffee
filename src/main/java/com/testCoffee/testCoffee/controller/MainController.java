package com.testCoffee.testCoffee.controller;

import com.testCoffee.testCoffee.entity.Coffee;
import com.testCoffee.testCoffee.entity.User;
import com.testCoffee.testCoffee.repository.CoffeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Controller
public class MainController {

    private final CoffeeRepository coffeeRepository;
    @Autowired
    public MainController(CoffeeRepository coffeeRepository) {
        this.coffeeRepository=coffeeRepository;
    }

    @GetMapping("/")
    public String greeting(Model model) {
        return "greeting";
    }

    @GetMapping("/main")
    public String main(@RequestParam(required = false, defaultValue = "") String filter, Model model){
        Iterable<Coffee> coffees=coffeeRepository.findAll();

        if(filter!=null&&!filter.isEmpty()){
            coffees = coffeeRepository.findByName(filter);

        }else{
            coffees=coffeeRepository.findAll();
        }
        model.addAttribute("coffees",coffees);
        model.addAttribute("filter", filter);
        return "main";
    }

    @PostMapping("/main")
    public String add(
            @RequestParam("file")MultipartFile file,
            @AuthenticationPrincipal User user,
            @RequestParam String coffee_name,
            Model model){
        Coffee coffee = new Coffee(coffee_name,user);
        coffeeRepository.save(coffee);
        Iterable<Coffee> coffees=coffeeRepository.findAll();
        model.addAttribute("coffees",coffees);
        return "main";
    }

}