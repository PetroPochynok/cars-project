package org.project.cars.entity;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.util.List;

@Entity
@Table(name = "car")
public class Car {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @NotNull(message = "Please fill in the form")
    @Pattern(regexp = "[A-Z][a-zA-Z\\-\\s]+", message = "Invalid brand")
    @Size(min = 1, max = 30, message = "Must not be shorter than 1 and longer than 30 characters")
    @Column(name = "brand")
    private String brand;

    @NotNull(message = "Please fill in the form")
    @Pattern(regexp = "[a-zA-Z0-9\\.\\-\\s\\/]+", message = "Invalid model")
    @Size(min = 1, max = 40, message = "Must not be shorter than 1 and longer than 40 characters")
    @Column(name = "model")
    private String model;

    @NotNull(message = "Please fill in the form")
    @Pattern(regexp = "[A-Z][a-zA-Z0-9\\.\\-\\s]+", message = "Invalid color")
    @Size(min = 2, max = 40, message = "Must not be shorter than 2 and longer than 40 characters")
    @Column(name = "color")
    private String color;

    @NotNull(message = "Please fill in the form")
    @Min(value = 1, message = "Must be greater than or equals to 1")
    @Max(value = 15, message = "Must be less than or equals to 15")
    @Column(name = "seats")
    private Integer seats;

    @NotNull(message = "Please fill in the form")
    @Pattern(regexp = "[A-Z][a-zA-Z0-9\\.\\-\\s]+", message = "Invalid fuel type")
    @Size(min = 3, max = 30, message = "Must not be shorter than 3 and longer than 30 characters")
    @Column(name = "fuel_type")
    private String fuelType;

    @Column(name = "status")
    private String status;

    @Column(name = "mileage")
    private double mileage;

    @NotNull(message = "Please fill in the form")
    @Min(value = 2500, message = "Must be greater than or equals to 2500")
    @Max(value = 250000, message = "Must be less than or equals to 250000")
    @Column(name = "price")
    private Integer price;

    @OneToMany(mappedBy = "car", cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private List<Info> info;


    public Car(){}

    public Car(int id, String brand, String model, String color, Integer seats, String fuelType, String status, double mileage, Integer price) {
        this.id = id;
        this.brand = brand;
        this.model = model;
        this.color = color;
        this.seats = seats;
        this.fuelType = fuelType;
        this.status = status;
        this.mileage = mileage;
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public Integer getSeats() {
        return seats;
    }

    public void setSeats(Integer seats) {
        this.seats = seats;
    }

    public String getFuelType() {
        return fuelType;
    }

    public void setFuelType(String fuelType) {
        this.fuelType = fuelType;
    }

    public double getMileage() {
        return mileage;
    }

    public void setMileage(double mileage) {
        this.mileage = mileage;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public List<Info> getInfo() {
        return info;
    }

    public void setInfo(List<Info> info) {
        this.info = info;
    }

    @Override
    public String toString() {
        return "Car{" +
                "id=" + id +
                ", brand='" + brand + '\'' +
                ", model='" + model + '\'' +
                ", color='" + color + '\'' +
                ", seats=" + seats +
                ", fuelType='" + fuelType + '\'' +
                ", status='" + status + '\'' +
                ", mileage=" + mileage +
                ", price=" + price +
                '}';
    }
}
