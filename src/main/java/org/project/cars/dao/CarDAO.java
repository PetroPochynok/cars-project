package org.project.cars.dao;

import org.project.cars.entity.Car;

import java.util.List;

public interface CarDAO {

    List<Car> getCars();

    Car getCar(int id);

    void deleteCar(int id);

    void saveCar(Car car);

    List<Car> getListOfUsedCarsOnSale();

    List<Car> getListOfNewCarsOnSale();

    List<Car> getListOfCarsToRentOnSale();

    List<Car> searchCar(String car);


    // Soring New Cars By Price Range
    List<Car> findNewCarsByPriceRange(Integer min, Integer max);

    // Soring Used Cars By Price Range
    List<Car> findUsedCarsByPriceRange(Integer min, Integer max);


    // Sorting Used Cars On Sale
    List<Car> getListOfUsedCarsOnSaleOrderByBrandAsc();

    List<Car> getListOfUsedCarsOnSaleOrderBySeatsDesc();

    List<Car> getListOfUsedCarsOnSaleOrderByMileageAsc();

    List<Car> getListOfUsedCarsOnSaleOrderByPriceDesc();


    // Sorting New Cars On Sale
    List<Car> getListOfNewCarsOnSaleOrderByBrandAsc();

    List<Car> getListOfNewCarsOnSaleOrderBySeatsDesc();

    List<Car> getListOfNewCarsOnSaleOrderByMileageAsc();

    List<Car> getListOfNewCarsOnSaleOrderByPriceDesc();


    // Sorting Cars To Rent On Sale
    List<Car> getListOfCarsToRentOnSaleOrderByBrandAsc();

    List<Car> getListOfCarsToRentOnSaleOrderBySeatsDesc();

    List<Car> getListOfCarsToRentOnSaleOrderByMileageAsc();


    // Sorting List Of All Cars
    List<Car> getListOfAllCarsOrderByIdAsc();

    List<Car> getListOfAllCarsOrderByBrandAsc();

    List<Car> getListOfAllCarsOrderBySeatsDesc();

    List<Car> getListOfAllCarsOrderByStatusAsc();

    List<Car> getListOfAllCarsOrderByMileageAsc();

    List<Car> getListOfAllCarsOrderByPriceDesc();
}
