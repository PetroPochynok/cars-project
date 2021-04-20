package org.project.cars.controller;

import org.project.cars.entity.Car;
import org.project.cars.entity.Info;
import org.project.cars.entity.User;
import org.project.cars.exception.NoSuchResultException;
import org.project.cars.exception.NotEnoughMoneyException;
import org.project.cars.service.CarService;
import org.project.cars.service.InfoService;
import org.project.cars.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/cars")
public class CarController {

    @Autowired
    private UserService userService;

    @Autowired
    private CarService carService;

    @Autowired
    private InfoService infoService;

    // Remove leading and trailing whitespace
    @InitBinder
    private void initBinder(WebDataBinder webDataBinder) {
        StringTrimmerEditor stringTrimmerEditor = new StringTrimmerEditor(true);

        webDataBinder.registerCustomEditor(String.class, stringTrimmerEditor);
    }

    @GetMapping("/listOfNewCarsOnSale")
    public String getListOfNewCarsOnSale(Model model, Authentication authentication){
        List<Car> cars = carService.getListOfNewCarsOnSale();

        String username = authentication.getName();
        User user = (User) userService.loadUserByUsername(username);

        model.addAttribute("cars", cars);
        model.addAttribute("user", user);

        return "list-of-new-cars";
    }

    @GetMapping("/listOfUsedCarsOnSale")
    public String getListOfUsedCarsOnSale(Model model, Authentication authentication){
        List<Car> cars = carService.getListOfUsedCarsOnSale();

        String username = authentication.getName();
        User user = (User) userService.loadUserByUsername(username);

        model.addAttribute("cars", cars);
        model.addAttribute("user", user);
        return "list-of-used-cars";
    }

    @GetMapping("/listOfCarsToRentOnSale")
    public String getListOfCarsToRentOnSale(Model model, Authentication authentication){
        List<Car> cars = carService.getListOfCarsToRentOnSale();

        String username = authentication.getName();
        User user = (User) userService.loadUserByUsername(username);

        model.addAttribute("cars", cars);
        model.addAttribute("user", user);

        return "list-of-cars-to-rent";
    }


    @GetMapping("/showFormForAddNewCarForSale")
    @PreAuthorize("hasRole('ADMIN')")
    public String showFormForAddNewCarForSale(Model model, Authentication authentication){
        String username = authentication.getName();
        User user = (User) userService.loadUserByUsername(username);

        Car car = new Car();

        model.addAttribute("car", car);
        model.addAttribute("user", user);

        return "form-for-add-new-car";
    }

    @PostMapping("/saveFormForAddNewCar")
    @PreAuthorize("hasRole('ADMIN')")
    public String saveFormForNewCar(@Valid @ModelAttribute("car") Car car, BindingResult bindingResult){

        if(bindingResult.hasErrors()){
            return "form-for-add-new-car";
        } else{
            car.setStatus("NEW CAR ON SALE");

            carService.saveCar(car);

            return "redirect:listOfNewCarsOnSale";
        }
    }

    @GetMapping("/showFormForAddUsedCarForSale")
    @PreAuthorize("hasRole('ADMIN')")
    public String showFormForAddUsedCarForSale(Model model, Authentication authentication){
        String username = authentication.getName();
        User user = (User) userService.loadUserByUsername(username);

        Car car = new Car();

        model.addAttribute("car", car);
        model.addAttribute("user", user);

        return "form-for-add-used-car";
    }

    @PostMapping("/saveFormForAddUsedCar")
    @PreAuthorize("hasRole('ADMIN')")
    public String saveFormForAddUsedCar(@Valid @ModelAttribute("car") Car car, BindingResult bindingResult){
        if (bindingResult.hasErrors()){
            return "form-for-add-used-car";
        } else{
            car.setStatus("USED CAR ON SALE");

            carService.saveCar(car);

            return "redirect:listOfUsedCarsOnSale";
        }
    }

    @GetMapping("/showFormForAddCarToRent")
    @PreAuthorize("hasRole('ADMIN')")
    public String showFormForAddRentCarForSale(Model model, Authentication authentication){
        String username = authentication.getName();
        User user = (User) userService.loadUserByUsername(username);

        Car car = new Car();

        model.addAttribute("car", car);
        model.addAttribute("user", user);

        return "form-for-add-car-to-rent";
    }

    @PostMapping("/saveFormForAddCarToRent")
    @PreAuthorize("hasRole('ADMIN')")
    public String saveFormForAddRentCar(@Valid @ModelAttribute("car") Car car, BindingResult bindingResult){
        if (bindingResult.hasErrors()){
            return "form-for-add-car-to-rent";
        } else{
            car.setStatus("CAR TO RENT ON SALE");

            carService.saveCar(car);

            return "redirect:listOfCarsToRentOnSale";
        }
    }

    @GetMapping("/showFormForUpdateNewCar")
    @PreAuthorize("hasRole('ADMIN')")
    public String showFormForUpdateNewCars(@RequestParam("carId") int id, Model model, Authentication authentication){
        String username = authentication.getName();
        User user = (User) userService.loadUserByUsername(username);

        Car car = carService.getCar(id);

        model.addAttribute("car", car);
        model.addAttribute("user", user);

        return "form-for-add-new-car";
    }

    @GetMapping("/deleteNewCar")
    @PreAuthorize("hasRole('ADMIN')")
    public String deleteNewCar(@RequestParam("carId") int id){
        carService.deleteCar(id);

        return "redirect:listOfNewCarsOnSale";
    }

    @GetMapping("/showFormForUpdateUsedCar")
    @PreAuthorize("hasRole('ADMIN')")
    public String showFormForUpdateUsedCar(@RequestParam("carId") int id, Model model, Authentication authentication){
        String username = authentication.getName();
        User user = (User) userService.loadUserByUsername(username);

        Car car = carService.getCar(id);

        model.addAttribute("car", car);
        model.addAttribute("user", user);

        return "form-for-add-used-car";
    }

    @GetMapping("/deleteUsedCar")
    @PreAuthorize("hasRole('ADMIN')")
    public String deleteUsedCar(@RequestParam("carId") int id){
        carService.deleteCar(id);

        return "redirect:listOfUsedCarsOnSale";
    }

    @GetMapping("/buyNewCar")
    public String buyNewCar(@RequestParam("carId") int id, Model model, Authentication authentication){
        String username = authentication.getName();
        User user = (User) userService.loadUserByUsername(username);

        Car car = carService.getCar(id);

        model.addAttribute("car", car);
        model.addAttribute("user", user);

        return "form-for-buy-new-car";
    }

    @PostMapping("/saveFormForBuyNewCar")
    public String saveFormForBuyNewCar(@ModelAttribute("car")Car car, Authentication authentication) {
        String username = authentication.getName();
        User user = (User) userService.loadUserByUsername(username);

        car.setStatus("BOUGHT CAR");

        Info info = new Info();
        info.setCar(car);
        info.setUser(user);
        info.setStatus("BOUGHT CAR");
        info.setDate(new Date());

        if (user.getMoney() < car.getPrice()){
            throw new NotEnoughMoneyException("NOT ENOUGH MONEY");
        }

        user.setMoney(user.getMoney() - car.getPrice());

        infoService.saveInfo(info);
        userService.saveUser(user);
        carService.saveCar(car);

        return "redirect:listOfNewCarsOnSale";
    }

    @GetMapping("/buyUsedCar")
    public String buyUsedCar(@RequestParam("carId") int id, Model model, Authentication authentication){
        String username = authentication.getName();
        User user = (User) userService.loadUserByUsername(username);

        Car car = carService.getCar(id);

        model.addAttribute("car", car);
        model.addAttribute("user", user);

        return "form-for-buy-used-car";
    }

    @PostMapping("/saveFormForBuyUsedCar")
    public String saveFormForBuyUsedCar(@ModelAttribute("car")Car car, Authentication authentication) {
        String username = authentication.getName();
        User user = (User) userService.loadUserByUsername(username);

        car.setStatus("BOUGHT CAR");

        Info info = new Info();
        info.setCar(car);
        info.setUser(user);
        info.setStatus("BOUGHT CAR");
        info.setDate(new Date());

        if (user.getMoney() < car.getPrice()){
            throw new NotEnoughMoneyException("NOT ENOUGH MONEY");
        }

        user.setMoney(user.getMoney() - car.getPrice());

        infoService.saveInfo(info);
        userService.saveUser(user);
        carService.saveCar(car);

        return "redirect:listOfUsedCarsOnSale";
    }

    @GetMapping("/showFormForRentCar")
    public String showFormForRentCar(@RequestParam("carId") int id, Model model, Authentication authentication){
        String username = authentication.getName();
        User user = (User) userService.loadUserByUsername(username);

        Car car = carService.getCar(id);

        int pricePerOneDay = car.getPrice() / 1000;

        model.addAttribute("car", car);
        model.addAttribute("pricePerOneDay", pricePerOneDay);
        model.addAttribute("user", user);

        return "form-for-rent-car";
    }

    @PostMapping("/saveFormForRentCar")
    public String saveFormForRentCar(@ModelAttribute("car") Car car, @RequestParam("paidDays") int paidDays, Authentication authentication){
        String username = authentication.getName();
        User user = (User) userService.loadUserByUsername(username);

        car.setStatus("IN RENT");

        Info info = new Info();
        info.setUser(user);
        info.setCar(car);
        info.setStatus("CAR IN RENT");
        info.setDate(new Date());
        info.setPaidDays(paidDays);

        int pricePerOneDay = car.getPrice() / 1000;
        int priceForRent = pricePerOneDay * paidDays;

        if(user.getMoney() < priceForRent){
            throw new NotEnoughMoneyException("NOT ENOUGH MONEY");
        }

        user.setMoney(user.getMoney() - priceForRent);

        infoService.saveInfo(info);
        carService.saveCar(car);
        userService.saveUser(user);

        return "redirect:listOfCarsToRentOnSale";
    }

    @GetMapping("/showFormForUpdateCarToRent")
    @PreAuthorize("hasRole('ADMIN')")
    public String showFormForUpdateCarToRent(@RequestParam("carId") int id, Model model, Authentication authentication){
        String username = authentication.getName();
        User user = (User) userService.loadUserByUsername(username);

        Car car = carService.getCar(id);

        model.addAttribute("car", car);
        model.addAttribute("user", user);

        return "form-for-add-car-to-rent";
    }

    @GetMapping("/deleteCarToRent")
    @PreAuthorize("hasRole('ADMIN')")
    public String deleteCarToRent(@RequestParam("carId") int id){
        carService.deleteCar(id);

        return "redirect:listOfCarsToRentOnSale";
    }


    @GetMapping("/listOfAllCars")
    @PreAuthorize("hasRole('ADMIN')")
    public String listOfAllCars(Model model, Authentication authentication){
        String username = authentication.getName();
        User user = (User) userService.loadUserByUsername(username);

        List<Car> cars = carService.getCars();

        model.addAttribute("cars", cars);
        model.addAttribute("user", user);

        return "list-of-all-cars";
    }

    @GetMapping("/deleteCar")
    @PreAuthorize("hasRole('ADMIN')")
    public String deleteCar(@RequestParam("carId") int id){

        carService.deleteCar(id);

        return "redirect:/cars/listOfAllCars";
    }

    @GetMapping("/showFormForUpdateCar")
    @PreAuthorize("hasRole('ADMIN')")
    public String showFormForUpdateCar(@RequestParam("carId") int id, Model model, Authentication authentication){
        String username = authentication.getName();
        User user = (User) userService.loadUserByUsername(username);

        Car car = carService.getCar(id);

        model.addAttribute("car", car);
        model.addAttribute("user", user);

        return "form-for-update-car";
    }

    @PostMapping("/saveFormForUpdateCar")
    public String saveFormForUpdateCar(@Valid @ModelAttribute("car") Car car, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            return "form-for-update-car";
        } else{
            carService.saveCar(car);

            return "redirect:/cars/listOfAllCars";
        }
    }

    @GetMapping("searchCar")
    public String searchCar(@RequestParam("searchCar") String searchCar, Model model, Authentication authentication){
        String username = authentication.getName();
        User user = (User) userService.loadUserByUsername(username);

        List<Car> cars = carService.searchCar(searchCar);

        model.addAttribute("user", user);
        model.addAttribute("cars", cars);

        return "found-cars";
    }

    // Soring New Cars By Price Range
    @PostMapping("/listOfNewCarsOnSaleByPriceRange")
    public String listOfNewCarsOnSaleByPriceRange(@RequestParam("min") Integer min, @RequestParam("max") Integer max, Model model, Authentication authentication){
        if(min > max){
            return "redirect:/cars/listOfNewCarsOnSale";
        }
            String username = authentication.getName();
            User user = (User) userService.loadUserByUsername(username);

            List<Car> cars = carService.findNewCarsByPriceRange(min, max);

            model.addAttribute("user", user);
            model.addAttribute("cars", cars);

            return "list-of-new-cars";
    }

    // Soring Used Cars By Price Range
    @PostMapping("/listOfUsedCarsOnSaleByPriceRange")
    public String listOfUsedCarsOnSaleByPriceRange(@RequestParam("min") Integer min, @RequestParam("max") Integer max, Model model, Authentication authentication){
        if(min > max){
            return "redirect:/cars/listOfUsedCarsOnSale";
        }
        String username = authentication.getName();
        User user = (User) userService.loadUserByUsername(username);

        List<Car> cars = carService.findUsedCarsByPriceRange(min, max);

        model.addAttribute("user", user);
        model.addAttribute("cars", cars);

        return "list-of-used-cars";
    }



    // Sorting Used Cars On Sale
    @GetMapping("/listOfUsedCarsOnSaleOrderByBrandAsc")
    public String listOfUsedCarsOnSaleOrderByBrandAsc(Model model, Authentication authentication){
        String username = authentication.getName();
        User user = (User) userService.loadUserByUsername(username);

        List<Car> cars = carService.getListOfUsedCarsOnSaleOrderByBrandAsc();

        model.addAttribute("cars", cars);
        model.addAttribute("user", user);

        return "list-of-used-cars";
    }

    @GetMapping("/listOfUsedCarsOnSaleOrderBySeatsDesc")
    public String listOfUsedCarsOnSaleOrderBySeatsDesc(Model model, Authentication authentication){
        String username = authentication.getName();
        User user = (User) userService.loadUserByUsername(username);

        List<Car> cars = carService.getListOfUsedCarsOnSaleOrderBySeatsDesc();

        model.addAttribute("cars", cars);
        model.addAttribute("user", user);

        return "list-of-used-cars";
    }

    @GetMapping("/listOfUsedCarsOnSaleOrderByMileageAsc")
    public String listOfUsedCarsOnSaleOrderByMileageAsc(Model model, Authentication authentication){
        String username = authentication.getName();
        User user = (User) userService.loadUserByUsername(username);

        List<Car> cars = carService.getListOfUsedCarsOnSaleOrderByMileageAsc();

        model.addAttribute("cars", cars);
        model.addAttribute("user", user);

        return "list-of-used-cars";
    }

    @GetMapping("/listOfUsedCarsOnSaleOrderByPriceDesc")
    public String listOfUsedCarsOnSaleOrderByPriceDesc(Model model, Authentication authentication){
        String username = authentication.getName();
        User user = (User) userService.loadUserByUsername(username);

        List<Car> cars = carService.getListOfUsedCarsOnSaleOrderByPriceDesc();

        model.addAttribute("cars", cars);
        model.addAttribute("user", user);

        return "list-of-used-cars";
    }


    // Sorting New Cars On Sale
    @GetMapping("/listOfNewCarsOnSaleOrderByBrandAsc")
    public String listOfNewCarsOnSaleOrderByBrandAsc(Model model, Authentication authentication){
        String username = authentication.getName();
        User user = (User) userService.loadUserByUsername(username);

        List<Car> cars = carService.getListOfNewCarsOnSaleOrderByBrandAsc();

        model.addAttribute("cars", cars);
        model.addAttribute("user", user);

        return "list-of-new-cars";
    }

    @GetMapping("/listOfNewCarsOnSaleOrderBySeatsDesc")
    public String listOfNewCarsOnSaleOrderBySeatsDesc(Model model, Authentication authentication){
        String username = authentication.getName();
        User user = (User) userService.loadUserByUsername(username);

        List<Car> cars = carService.getListOfNewCarsOnSaleOrderBySeatsDesc();

        model.addAttribute("cars", cars);
        model.addAttribute("user", user);

        return "list-of-new-cars";
    }

    @GetMapping("/listOfNewCarsOnSaleOrderByMileageAsc")
    public String listOfNewCarsOnSaleOrderByMileageAsc(Model model, Authentication authentication){
        String username = authentication.getName();
        User user = (User) userService.loadUserByUsername(username);

        List<Car> cars = carService.getListOfNewCarsOnSaleOrderByMileageAsc();

        model.addAttribute("cars", cars);
        model.addAttribute("user", user);

        return "list-of-new-cars";
    }

    @GetMapping("/listOfNewCarsOnSaleOrderByPriceDesc")
    public String listOfNewCarsOnSaleOrderByPriceDesc(Model model, Authentication authentication){
        String username = authentication.getName();
        User user = (User) userService.loadUserByUsername(username);

        List<Car> cars = carService.getListOfNewCarsOnSaleOrderByPriceDesc();

        model.addAttribute("cars", cars);
        model.addAttribute("user", user);

        return "list-of-new-cars";
    }


    // Sorting Cars To Rent On Sale
    @GetMapping("/listOfCarsToRentOnSaleOrderByBrandAsc")
    public String listOfCarsToRentOnSaleOrderByBrandAsc(Model model, Authentication authentication){
        String username = authentication.getName();
        User user = (User) userService.loadUserByUsername(username);

        List<Car> cars = carService.getListOfCarsToRentOnSaleOrderByBrandAsc();

        model.addAttribute("cars", cars);
        model.addAttribute("user", user);

        return "list-of-cars-to-rent";
    }

    @GetMapping("/listOfCarsToRentOnSaleOrderBySeatsDesc")
    public String listOfCarsToRentOnSaleOrderBySeatsDesc(Model model, Authentication authentication){
        String username = authentication.getName();
        User user = (User) userService.loadUserByUsername(username);

        List<Car> cars = carService.getListOfCarsToRentOnSaleOrderBySeatsDesc();

        model.addAttribute("cars", cars);
        model.addAttribute("user", user);

        return "list-of-cars-to-rent";
    }

    @GetMapping("/listOfCarsToRentOnSaleOrderByMileageAsc")
    public String listOfCarsToRentOnSaleOrderByMileageAsc(Model model, Authentication authentication){
        String username = authentication.getName();
        User user = (User) userService.loadUserByUsername(username);

        List<Car> cars = carService.getListOfCarsToRentOnSaleOrderByMileageAsc();

        model.addAttribute("cars", cars);
        model.addAttribute("user", user);

        return "list-of-cars-to-rent";
    }


    // Sorting List Of All Cars
    @GetMapping("/listOfAllCarsOrderByIdAsc")
    public String listOfAllCarsOrderByIdAsc(Model model, Authentication authentication){
        String username = authentication.getName();
        User user = (User) userService.loadUserByUsername(username);

        List<Car> cars = carService.getListOfAllCarsOrderByIdAsc();

        model.addAttribute("cars", cars);
        model.addAttribute("user", user);

        return "list-of-all-cars";
    }

    @GetMapping("/listOfAllCarsOrderByBrandAsc")
    public String listOfAllCarsOrderByBrandAsc(Model model, Authentication authentication){
        String username = authentication.getName();
        User user = (User) userService.loadUserByUsername(username);

        List<Car> cars = carService.getListOfAllCarsOrderByBrandAsc();

        model.addAttribute("cars", cars);
        model.addAttribute("user", user);

        return "list-of-all-cars";
    }

    @GetMapping("/listOfAllCarsOrderBySeatsDesc")
    public String listOfAllCarsOrderBySeatsDesc(Model model, Authentication authentication){
        String username = authentication.getName();
        User user = (User) userService.loadUserByUsername(username);

        List<Car> cars = carService.getListOfAllCarsOrderBySeatsDesc();

        model.addAttribute("cars", cars);
        model.addAttribute("user", user);

        return "list-of-all-cars";
    }

    @GetMapping("/listOfAllCarsOrderByStatusAsc")
    public String listOfAllCarsOrderByStatusAsc(Model model, Authentication authentication){
        String username = authentication.getName();
        User user = (User) userService.loadUserByUsername(username);

        List<Car> cars = carService.getListOfAllCarsOrderByStatusAsc();

        model.addAttribute("cars", cars);
        model.addAttribute("user", user);

        return "list-of-all-cars";
    }

    @GetMapping("/listOfAllCarsOrderByMileageAsc")
    public String listOfAllCarsOrderByMileageAsc(Model model, Authentication authentication){
        String username = authentication.getName();
        User user = (User) userService.loadUserByUsername(username);

        List<Car> cars = carService.getListOfAllCarsOrderByMileageAsc();

        model.addAttribute("cars", cars);
        model.addAttribute("user", user);

        return "list-of-all-cars";
    }

    @GetMapping("/listOfAllCarsOrderByPriceDesc")
    public String listOfAllCarsOrderByPriceDesc(Model model, Authentication authentication){
        String username = authentication.getName();
        User user = (User) userService.loadUserByUsername(username);

        List<Car> cars = carService.getListOfAllCarsOrderByPriceDesc();

        model.addAttribute("cars", cars);
        model.addAttribute("user", user);

        return "list-of-all-cars";
    }
}

