package com.testCoffee.testCoffee.controller;

import com.testCoffee.testCoffee.entity.Coffee;
import com.testCoffee.testCoffee.entity.User;
import com.testCoffee.testCoffee.repository.CoffeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.ClassPathResource;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.UUID;

@Controller
public class MainController {

    private final CoffeeRepository coffeeRepository;

    @Value("${upload.path}")
    private String uploadPath;

    @Autowired
    public MainController(CoffeeRepository coffeeRepository) {
        this.coffeeRepository = coffeeRepository;
    }

    @GetMapping("/")
    public String greeting(Model model) {
        return "greeting";
    }

    @GetMapping("/main")
    public String main(@RequestParam(required = false, defaultValue = "") String filter, Model model) {
        Iterable<Coffee> coffees = coffeeRepository.findAll();

        if (filter != null && !filter.isEmpty()) {
            coffees = coffeeRepository.findByName(filter);

        } else {
            coffees = coffeeRepository.findAll();
        }
        model.addAttribute("coffees", coffees);
        model.addAttribute("filter", filter);
        return "main";
    }

    @PostMapping("/main")
    public String add(
            @RequestParam("file") MultipartFile file,
            @AuthenticationPrincipal User user,
            @RequestParam String coffee_name,
            Model model) throws IOException {

        Coffee coffee = new Coffee(coffee_name, user);

        if (file != null && !file.getOriginalFilename().isEmpty()) {
            File uploadDir = new File(uploadPath);

            if (!uploadDir.exists()) {
                uploadDir.mkdir();
            }

            String uuidFile = UUID.randomUUID().toString();
            String resultFilename = uuidFile + "." + file.getOriginalFilename();
            file.transferTo(new File(uploadPath + "/" + resultFilename));

            coffee.setFilename(resultFilename);
        }
        coffee.setCreationDate(LocalDateTime.now());
        coffeeRepository.save(coffee);
        Iterable<Coffee> coffees = coffeeRepository.findAll();
        model.addAttribute("coffees", coffees);
        return "redirect:/main";
    }

//    @PostMapping("{id}")
//    public void delete(@PathVariable("id")Coffee coffee){
//        coffeeRepository.delete(coffee);
//    }
}