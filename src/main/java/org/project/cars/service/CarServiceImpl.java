package org.project.cars.service;

import org.project.cars.dao.CarDAO;
import org.project.cars.entity.Car;
import org.project.cars.exception.NoSuchResultException;
import org.project.cars.exception.NotEnoughMoneyException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class CarServiceImpl implements CarService{

    @Autowired
    private CarDAO carDAO;

    @Override
    @Transactional
    public List<Car> getCars() {
        return carDAO.getCars();
    }

    @Override
    @Transactional
    public Car getCar(int id) {
        return carDAO.getCar(id);
    }

    @Override
    @Transactional
    public void deleteCar(int id) {
        carDAO.deleteCar(id);
    }

    @Override
    @Transactional
    public void saveCar(Car car) {
        carDAO.saveCar(car);
    }

    @Override
    @Transactional
    public List<Car> getListOfUsedCarsOnSale() {
        return carDAO.getListOfUsedCarsOnSale();
    }

    @Override
    @Transactional
    public List<Car> getListOfNewCarsOnSale() {
        return carDAO.getListOfNewCarsOnSale();
    }

    @Override
    @Transactional
    public List<Car> getListOfCarsToRentOnSale() {
        return carDAO.getListOfCarsToRentOnSale();
    }

    @Override
    @Transactional
    public List<Car> searchCar(String car) {
        List<Car> cars = carDAO.searchCar(car);

        if(cars.isEmpty()){
            throw new NoSuchResultException("No Such Result");
        }

        return cars;
    }


    // Soring New Cars By Price Range
    @Override
    @Transactional
    public List<Car> findNewCarsByPriceRange(Integer min, Integer max) {
        List<Car> cars = carDAO.findNewCarsByPriceRange(min, max);

        if(cars.isEmpty()){
            throw new NoSuchResultException("No Such Result");
        }

        return cars;
    }


    // Soring Used Cars By Price Range
    @Override
    @Transactional
    public List<Car> findUsedCarsByPriceRange(Integer min, Integer max) {
        List<Car> cars = carDAO.findUsedCarsByPriceRange(min, max);

        if(cars.isEmpty()){
            throw new NoSuchResultException("No Such Result");
        }

        return cars;
    }


    // Sorting Used Cars On Sale
    @Override
    @Transactional
    public List<Car> getListOfUsedCarsOnSaleOrderByBrandAsc() {
        return carDAO.getListOfUsedCarsOnSaleOrderByBrandAsc();
    }

    @Override
    @Transactional
    public List<Car> getListOfUsedCarsOnSaleOrderBySeatsDesc() {
        return carDAO.getListOfUsedCarsOnSaleOrderBySeatsDesc();
    }

    @Override
    @Transactional
    public List<Car> getListOfUsedCarsOnSaleOrderByMileageAsc() {
        return carDAO.getListOfUsedCarsOnSaleOrderByMileageAsc();
    }

    @Override
    @Transactional
    public List<Car> getListOfUsedCarsOnSaleOrderByPriceDesc() {
        return carDAO.getListOfUsedCarsOnSaleOrderByPriceDesc();
    }


    // Sorting New Cars On Sale
    @Override
    @Transactional
    public List<Car> getListOfNewCarsOnSaleOrderByBrandAsc() {
        return carDAO.getListOfNewCarsOnSaleOrderByBrandAsc();
    }

    @Override
    @Transactional
    public List<Car> getListOfNewCarsOnSaleOrderBySeatsDesc() {
        return carDAO.getListOfNewCarsOnSaleOrderBySeatsDesc();
    }

    @Override
    @Transactional
    public List<Car> getListOfNewCarsOnSaleOrderByMileageAsc() {
        return carDAO.getListOfNewCarsOnSaleOrderByMileageAsc();
    }

    @Override
    @Transactional
    public List<Car> getListOfNewCarsOnSaleOrderByPriceDesc() {
        return carDAO.getListOfNewCarsOnSaleOrderByPriceDesc();
    }


    // Sorting Cars To Rent On Sale
    @Override
    @Transactional
    public List<Car> getListOfCarsToRentOnSaleOrderByBrandAsc() {
        return carDAO.getListOfCarsToRentOnSaleOrderByBrandAsc();
    }

    @Override
    @Transactional
    public List<Car> getListOfCarsToRentOnSaleOrderBySeatsDesc() {
        return carDAO.getListOfCarsToRentOnSaleOrderBySeatsDesc();
    }

    @Override
    @Transactional
    public List<Car> getListOfCarsToRentOnSaleOrderByMileageAsc() {
        return carDAO.getListOfCarsToRentOnSaleOrderByMileageAsc();
    }


    // Sorting List Of All Cars
    @Override
    @Transactional
    public List<Car> getListOfAllCarsOrderByIdAsc() {
        return carDAO.getListOfAllCarsOrderByIdAsc();
    }

    @Override
    @Transactional
    public List<Car> getListOfAllCarsOrderByBrandAsc() {
        return carDAO.getListOfAllCarsOrderByBrandAsc();
    }

    @Override
    @Transactional
    public List<Car> getListOfAllCarsOrderBySeatsDesc() {
        return carDAO.getListOfAllCarsOrderBySeatsDesc();
    }

    @Override
    @Transactional
    public List<Car> getListOfAllCarsOrderByStatusAsc() {
        return carDAO.getListOfAllCarsOrderByStatusAsc();
    }

    @Override
    @Transactional
    public List<Car> getListOfAllCarsOrderByMileageAsc() {
        return carDAO.getListOfAllCarsOrderByMileageAsc();
    }

    @Override
    @Transactional
    public List<Car> getListOfAllCarsOrderByPriceDesc() {
        return carDAO.getListOfAllCarsOrderByPriceDesc();
    }


}
