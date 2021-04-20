package org.project.cars.controller;

import org.project.cars.dao.UserDAO;
import org.project.cars.entity.User;
import org.project.cars.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;

@Controller
@RequestMapping("/deposit")
public class DepositController {

    @Autowired
    private UserService userService;

    @GetMapping("/showPage")
    public String showPage(Model model, Authentication authentication){
        String username = authentication.getName();
        User user = (User) userService.loadUserByUsername(username);

        model.addAttribute("user", user);

        return "deposit-page";
    }

    @PostMapping("/saveForm")
    public String saveForm(@RequestParam("money") int money, Authentication authentication){
        String name = authentication.getName();
        User user = (User) userService.loadUserByUsername(name);

        user.addMoney(money);
        userService.saveUser(user);
        return "redirect:/cars/listOfNewCarsOnSale";
    }
}
