package org.project.cars.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.project.cars.entity.Info;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class InfoDAOImpl implements InfoDAO{

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public List<Info> getInfoList() {
        Session session = sessionFactory.getCurrentSession();

        Query<Info> query = session.createQuery("from Info order by id asc", Info.class);

        List<Info> infoList = query.getResultList();

        return infoList;
    }

    @Override
    public void saveInfo(Info info) {
        Session session = sessionFactory.getCurrentSession();

        session.saveOrUpdate(info);
    }

    @Override
    public Info getInfo(int id) {
        Session session = sessionFactory.getCurrentSession();

        Info info = session.get(Info.class, id);

        return info;
    }

    @Override
    public void deleteInfo(int id) {
        Session session = sessionFactory.getCurrentSession();

        Query query = session.createQuery("delete from Info where id=:infoId");

        query.setParameter("infoId", id);

        query.executeUpdate();
    }

    @Override
    public List<Info> getInfoListOfCarsInRent() {
        Session session = sessionFactory.getCurrentSession();

        Query<Info> query = session.createQuery("from Info where status='CAR IN RENT'");

        List<Info> infoList = query.getResultList();

        return infoList;
    }

    @Override
    public List<Info> getInfoListOfBoughtCars() {
        Session session = sessionFactory.getCurrentSession();

        Query<Info> query = session.createQuery("from Info where status='BOUGHT CAR'");

        List<Info> infoList = query.getResultList();

        return infoList;
    }

    @Override
    public List<Info> getInfoListOfReturnedCars() {
        Session session = sessionFactory.getCurrentSession();

        Query<Info> query = session.createQuery("from Info where status='RETURNED CAR'");

        List<Info> infoList = query.getResultList();

        return infoList;
    }
}
