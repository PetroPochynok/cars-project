package org.project.cars.service;

import org.project.cars.entity.Info;

import java.util.List;

public interface InfoService {

    List<Info> getInfoList();

    void saveInfo(Info info);

    Info getInfo(int id);

    void deleteInfo(int id);

    List<Info> getInfoListOfCarsInRent();

    List<Info> getInfoListOfBoughtCars();

    List<Info> getInfoListOfReturnedCars();
}
