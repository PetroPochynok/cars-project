package org.project.cars.controller;

import org.project.cars.entity.User;
import org.project.cars.exception.NoSuchResultException;
import org.project.cars.exception.NotEnoughMoneyException;
import org.project.cars.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionController {

    @Autowired
    private UserService userService;

    @ExceptionHandler(NotEnoughMoneyException.class)
    public String handleNotEnoughMoneyException(Model model, Authentication authentication){
        String username = authentication.getName();
        User user = (User) userService.loadUserByUsername(username);

        model.addAttribute("user", user);

        return "not-enough-money";
    }


    @ExceptionHandler(NoSuchResultException.class)
    public String handleNoSuchResultException(Model model, Authentication authentication){
        String username = authentication.getName();
        User user = (User) userService.loadUserByUsername(username);

        model.addAttribute("user", user);

        return "no-such-result";
    }

    @ExceptionHandler(Exception.class)
    public String handleGlobalException(Model model, Authentication authentication){
        String username = authentication.getName();
        User user = (User) userService.loadUserByUsername(username);

        model.addAttribute("user", user);

        return "global-exception";
    }
}
