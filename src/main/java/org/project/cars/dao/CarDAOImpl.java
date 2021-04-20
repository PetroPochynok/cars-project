package org.project.cars.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.project.cars.entity.Car;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CarDAOImpl implements CarDAO{

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public List<Car> getCars() {
        Session session = sessionFactory.getCurrentSession();

        Query<Car> query = session.createQuery("from Car order by id asc", Car.class);

        List<Car> cars = query.getResultList();

        return cars;
    }

    @Override
    public Car getCar(int id) {
        Session session = sessionFactory.getCurrentSession();

        Car car = session.get(Car.class, id);

        return car;
    }

    @Override
    public void deleteCar(int id) {
        Session session = sessionFactory.getCurrentSession();

        Query query = session.createQuery("delete from Car where id=:carId");

        query.setParameter("carId", id);

        query.executeUpdate();
    }

    @Override
    public void saveCar(Car car) {
        Session session = sessionFactory.getCurrentSession();

        session.saveOrUpdate(car);
    }


    @Override
    public List<Car> getListOfUsedCarsOnSale() {
        Session session = sessionFactory.getCurrentSession();

        Query<Car> query = session.createQuery("from Car where status='USED CAR ON SALE'");

        List<Car> cars = query.getResultList();

        return cars;
    }

    @Override
    public List<Car> getListOfNewCarsOnSale() {
        Session session = sessionFactory.getCurrentSession();

        Query<Car> query = session.createQuery("from Car where status='NEW CAR ON SALE'");

        List<Car> cars = query.getResultList();

        return cars;
    }

    @Override
    public List<Car> getListOfCarsToRentOnSale() {
        Session session = sessionFactory.getCurrentSession();

        Query<Car> query = session.createQuery("from Car where status='CAR TO RENT ON SALE'");

        List<Car> cars = query.getResultList();

        return cars;
    }

    @Override
    public List<Car> searchCar(String car) {
        Session session = sessionFactory.getCurrentSession();

        Query<Car> query = session.createQuery("from Car where status in ('CAR TO RENT ON SALE', 'NEW CAR ON SALE', 'USED CAR ON SALE') and lower(brand) like :theName or lower(model) like :theName", Car.class);

        query.setParameter("theName", "%" + car.toLowerCase() + "%");

        List<Car> cars = query.getResultList();

        return cars;
    }

    // Soring New Cars By Price Range
    @Override
    public List<Car> findNewCarsByPriceRange(Integer min, Integer max) {
        Session session = sessionFactory.getCurrentSession();

        Query<Car> query = session.createQuery("from Car where status='NEW CAR ON SALE' and price between :firstValue and :secondValue order by price desc", Car.class);

        query.setParameter("firstValue", min);
        query.setParameter("secondValue", max);

        List<Car> cars = query.getResultList();

        return cars;
    }


    // Soring Used Cars By Price Range
    @Override
    public List<Car> findUsedCarsByPriceRange(Integer min, Integer max) {
        Session session = sessionFactory.getCurrentSession();

        Query<Car> query = session.createQuery("from Car where status='USED CAR ON SALE' and price between :firstValue and :secondValue order by price desc", Car.class);

        query.setParameter("firstValue", min);
        query.setParameter("secondValue", max);

        List<Car> cars = query.getResultList();

        return cars;
    }


    // Sorting Used Cars On Sale
    @Override
    public List<Car> getListOfUsedCarsOnSaleOrderByBrandAsc(){
        Session session = sessionFactory.getCurrentSession();

        Query<Car> query = session.createQuery("from Car where status='USED CAR ON SALE' order by brand asc", Car.class);

        List<Car> cars = query.getResultList();

        return cars;
    }

    @Override
    public List<Car> getListOfUsedCarsOnSaleOrderBySeatsDesc(){
        Session session = sessionFactory.getCurrentSession();

        Query<Car> query = session.createQuery("from Car where status='USED CAR ON SALE' order by seats desc", Car.class);

        List<Car> cars = query.getResultList();

        return cars;
    }

    @Override
    public List<Car> getListOfUsedCarsOnSaleOrderByMileageAsc(){
        Session session = sessionFactory.getCurrentSession();

        Query<Car> query = session.createQuery("from Car where status='USED CAR ON SALE' order by mileage asc", Car.class);

        List<Car> cars = query.getResultList();

        return cars;
    }

    @Override
    public List<Car> getListOfUsedCarsOnSaleOrderByPriceDesc(){
        Session session = sessionFactory.getCurrentSession();

        Query<Car> query = session.createQuery("from Car where status='USED CAR ON SALE' order by price desc", Car.class);

        List<Car> cars = query.getResultList();

        return cars;
    }


    // Sorting New Cars On Sale
    @Override
    public List<Car> getListOfNewCarsOnSaleOrderByBrandAsc() {
        Session session = sessionFactory.getCurrentSession();

        Query<Car> query = session.createQuery("from Car where status='NEW CAR ON SALE' order by brand asc");

        List<Car> cars = query.getResultList();

        return cars;
    }

    @Override
    public List<Car> getListOfNewCarsOnSaleOrderBySeatsDesc() {
        Session session = sessionFactory.getCurrentSession();

        Query<Car> query = session.createQuery("from Car where status='NEW CAR ON SALE' order by seats desc");

        List<Car> cars = query.getResultList();

        return cars;
    }

    @Override
    public List<Car> getListOfNewCarsOnSaleOrderByMileageAsc() {
        Session session = sessionFactory.getCurrentSession();

        Query<Car> query = session.createQuery("from Car where status='NEW CAR ON SALE' order by mileage asc");

        List<Car> cars = query.getResultList();

        return cars;
    }

    @Override
    public List<Car> getListOfNewCarsOnSaleOrderByPriceDesc() {
        Session session = sessionFactory.getCurrentSession();

        Query<Car> query = session.createQuery("from Car where status='NEW CAR ON SALE' order by price desc");

        List<Car> cars = query.getResultList();

        return cars;
    }


    // Sorting Cars To Rent On Sale
    @Override
    public List<Car> getListOfCarsToRentOnSaleOrderByBrandAsc() {
        Session session = sessionFactory.getCurrentSession();

        Query<Car> query = session.createQuery("from Car where status='CAR TO RENT ON SALE' order by brand asc");

        List<Car> cars = query.getResultList();

        return cars;
    }

    @Override
    public List<Car> getListOfCarsToRentOnSaleOrderBySeatsDesc() {
        Session session = sessionFactory.getCurrentSession();

        Query<Car> query = session.createQuery("from Car where status='CAR TO RENT ON SALE' order by seats desc");

        List<Car> cars = query.getResultList();

        return cars;
    }

    @Override
    public List<Car> getListOfCarsToRentOnSaleOrderByMileageAsc() {
        Session session = sessionFactory.getCurrentSession();

        Query<Car> query = session.createQuery("from Car where status='CAR TO RENT ON SALE' order by mileage asc");

        List<Car> cars = query.getResultList();

        return cars;
    }


    // Sorting List Of All Cars
    @Override
    public List<Car> getListOfAllCarsOrderByIdAsc() {
        Session session = sessionFactory.getCurrentSession();

        Query<Car> query = session.createQuery("from Car order by id asc");

        List<Car> cars = query.getResultList();

        return cars;
    }

    @Override
    public List<Car> getListOfAllCarsOrderByBrandAsc() {
        Session session = sessionFactory.getCurrentSession();

        Query<Car> query = session.createQuery("from Car order by brand asc");

        List<Car> cars = query.getResultList();

        return cars;
    }

    @Override
    public List<Car> getListOfAllCarsOrderBySeatsDesc() {
        Session session = sessionFactory.getCurrentSession();

        Query<Car> query = session.createQuery("from Car order by seats desc");

        List<Car> cars = query.getResultList();

        return cars;
    }

    @Override
    public List<Car> getListOfAllCarsOrderByStatusAsc() {
        Session session = sessionFactory.getCurrentSession();

        Query<Car> query = session.createQuery("from Car order by status asc");

        List<Car> cars = query.getResultList();

        return cars;
    }

    @Override
    public List<Car> getListOfAllCarsOrderByMileageAsc() {
        Session session = sessionFactory.getCurrentSession();

        Query<Car> query = session.createQuery("from Car order by mileage asc");

        List<Car> cars = query.getResultList();

        return cars;
    }

    @Override
    public List<Car> getListOfAllCarsOrderByPriceDesc() {
        Session session = sessionFactory.getCurrentSession();

        Query<Car> query = session.createQuery("from Car order by price desc");

        List<Car> cars = query.getResultList();

        return cars;
    }
}
