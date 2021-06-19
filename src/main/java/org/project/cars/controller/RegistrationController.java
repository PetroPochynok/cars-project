package org.project.cars.controller;

import org.project.cars.dao.RoleDAO;
import org.project.cars.entity.User;
import org.project.cars.exception.UsernameAlreadyExistsException;
import org.project.cars.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.Collections;

@Controller
@RequestMapping("/registration")
public class RegistrationController {

    @Autowired
    private UserService userService;

    @Autowired
    private RoleDAO roleDAO;

    @Autowired
    private PasswordEncoder passwordEncoder;

    // Remove leading and trailing whitespace
    @InitBinder
    private void initBinder(WebDataBinder webDataBinder) {
        StringTrimmerEditor stringTrimmerEditor = new StringTrimmerEditor(true);

        webDataBinder.registerCustomEditor(String.class, stringTrimmerEditor);
    }

    @GetMapping("/showForm")
    public String showForm(Model model){
        model.addAttribute("user", new User());

        return "registration-form";
    }

    @PostMapping("/saveForm")
    public String saveForm(@Valid @ModelAttribute("user") User user, BindingResult bindingResult, Model model){

        if(bindingResult.hasErrors()){
            return "registration-form";
        } else{
            // setting up user role by default "USER"
            user.setRoles(Collections.singletonList(roleDAO.findRoleByName("ROLE_USER")));

            // encrypting password
            user.setPassword(passwordEncoder.encode(user.getPassword()));
            user.setMoney(0);

            // if username already exists
            try {
                userService.saveUser(user);
                return "redirect:/cars/listOfNewCarsOnSale";
            } catch (Exception exc){
                throw new UsernameAlreadyExistsException("Username already exists");
            }

        }

    }

    @GetMapping("/showFormForUpdateUser")
    @PreAuthorize("hasRole('USER')")
    public String showFormForUpdateUser(Model model, Authentication authentication){
        String username = authentication.getName();
        User user = (User) userService.loadUserByUsername(username);

        model.addAttribute("user", user);

        return "form-for-update-user";
    }

    @PostMapping("/saveFormForUpdateUser")
    public String saveFormForUpdateUser(@Valid @ModelAttribute("user") User user, BindingResult bindingResult){

        if(bindingResult.hasErrors()){
            return "form-for-update-user";
        } else{
            user.setPassword(passwordEncoder.encode(user.getPassword()));
            user.setRoles(Collections.singletonList(roleDAO.findRoleByName("ROLE_USER")));

            userService.saveUser(user);
            return "redirect:/cars/listOfNewCarsOnSale";
        }
    }

    @GetMapping("/showFormForUpdateAdmin")
    @PreAuthorize("hasRole('ADMIN')")
    public String showFormForUpdateADMIN(Model model, Authentication authentication){
        String username = authentication.getName();
        User user = (User) userService.loadUserByUsername(username);

        model.addAttribute("user", user);

        return "form-for-update-admin";
    }

    @PostMapping("/saveFormForUpdateAdmin")
    public String saveFormForUpdateAdmin(@Valid @ModelAttribute("user") User user, BindingResult bindingResult){

        if(bindingResult.hasErrors()){
            return "form-for-update-admin";
        }else{
            user.setPassword(passwordEncoder.encode(user.getPassword()));
            user.setRoles(Collections.singletonList(roleDAO.findRoleByName("ROLE_ADMIN")));

            userService.saveUser(user);
            return "redirect:/cars/listOfNewCarsOnSale";
        }
    }
}
