package org.project.cars.controller;

import org.project.cars.entity.Car;
import org.project.cars.entity.Info;
import org.project.cars.entity.User;
import org.project.cars.service.CarService;
import org.project.cars.service.InfoService;
import org.project.cars.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping("/info")
@PreAuthorize("hasRole('ADMIN')")
public class InfoController {

    @Autowired
    private InfoService infoService;

    @Autowired
    private UserService userService;

    @Autowired
    private CarService carService;

    @GetMapping("/showListOfInfo")
    public String showListOfInfo(Model model, Authentication authentication){
        String username = authentication.getName();
        User user = (User) userService.loadUserByUsername(username);

        List<Info> infoList = infoService.getInfoList();

        model.addAttribute("infoList", infoList);
        model.addAttribute("user", user);

        return "list-of-info";
    }

    @GetMapping("/showInfoListOfCarsInRent")
    public String showInfoListOfCarsInRent(Model model, Authentication authentication){
        String username = authentication.getName();
        User user = (User) userService.loadUserByUsername(username);

        List<Info> infoList = infoService.getInfoListOfCarsInRent();

        model.addAttribute("infoList", infoList);
        model.addAttribute("user", user);

        return "list-of-cars-in-rent";
    }

    @GetMapping("/showInfoListOfBoughtCars")
    public String showInfoListOfBoughtCars(Model model, Authentication authentication){
        String username = authentication.getName();
        User user = (User) userService.loadUserByUsername(username);

        List<Info> infoList = infoService.getInfoListOfBoughtCars();

        model.addAttribute("infoList", infoList);
        model.addAttribute("user", user);

        return "list-of-bought-cars";
    }

    @GetMapping("/showInfoListOfReturnedCars")
    public String showInfoListOfReturnedCars(Model model, Authentication authentication){
        String username = authentication.getName();
        User user = (User) userService.loadUserByUsername(username);

        List<Info> infoList = infoService.getInfoListOfReturnedCars();

        model.addAttribute("infoList", infoList);
        model.addAttribute("user", user);

        return "list-of-returned-cars";
    }

    @GetMapping("/changeStatus")
    @PreAuthorize("hasRole('ADMIN')")
    public String changeStatus(@RequestParam("infoId") int id){
        Info info = infoService.getInfo(id);
        Car car = info.getCar();

        car.setStatus("RETURNED CAR");
        info.setStatus("RETURNED CAR");
        info.setPaidDays(0);

        carService.saveCar(car);
        infoService.saveInfo(info);

        return "redirect:/info/showInfoListOfReturnedCars";
    }

    @GetMapping("/addCarToRentOnSale")
    @PreAuthorize("hasRole('ADMIN')")
    public String addCarToRentOnSale(@RequestParam("infoId") int id){
        Info info = infoService.getInfo(id);
        Car car = info.getCar();

        car.setStatus("CAR TO RENT ON SALE");
        carService.saveCar(car);

        infoService.deleteInfo(id);

        return "redirect:/cars/listOfCarsToRentOnSale";
    }

    @GetMapping("/deleteInfo")
    public String deleteInfo(@RequestParam("infoId") int id){
        infoService.deleteInfo(id);

        return "redirect:/info/showListOfInfo";
    }

    @GetMapping("/showMoreInfo")
    public String showMoreInfo(@RequestParam("infoId") int id, Model model, Authentication authentication){
        String username = authentication.getName();
        User user = (User) userService.loadUserByUsername(username);

        Info info = infoService.getInfo(id);

        model.addAttribute("info", info);
        model.addAttribute("user", user);

        return "more-information";
    }
}
