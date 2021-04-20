package org.project.cars.service;

import org.project.cars.dao.InfoDAO;
import org.project.cars.entity.Info;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class InfoServiceImpl implements InfoService{

    @Autowired
    private InfoDAO infoDAO;

    @Override
    @Transactional
    public List<Info> getInfoList() {
        return infoDAO.getInfoList();
    }

    @Override
    @Transactional
    public void saveInfo(Info info) {
        infoDAO.saveInfo(info);
    }

    @Override
    @Transactional
    public Info getInfo(int id) {
        return infoDAO.getInfo(id);
    }

    @Override
    @Transactional
    public void deleteInfo(int id) {
        infoDAO.deleteInfo(id);
    }

    @Override
    @Transactional
    public List<Info> getInfoListOfCarsInRent() {
        return infoDAO.getInfoListOfCarsInRent();
    }

    @Override
    @Transactional
    public List<Info> getInfoListOfBoughtCars() {
        return infoDAO.getInfoListOfBoughtCars();
    }

    @Override
    @Transactional
    public List<Info> getInfoListOfReturnedCars() {
        return infoDAO.getInfoListOfReturnedCars();
    }
}
