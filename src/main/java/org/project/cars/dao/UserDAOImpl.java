package org.project.cars.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.project.cars.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserDAOImpl implements UserDAO{

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public List<User> getUsers() {
        Session session = sessionFactory.getCurrentSession();

        Query<User> query = session.createQuery("from User", User.class);

        List<User> users = query.getResultList();

        return users;
    }

    @Override
    public void saveUser(User user) {
        Session session = sessionFactory.getCurrentSession();

        session.saveOrUpdate(user);
    }

    @Override
    public User getUser(int id) {
        Session session = sessionFactory.getCurrentSession();

        User user = session.get(User.class, id);

        return user;
    }

    @Override
    public void deleteUser(int id) {
        Session session = sessionFactory.getCurrentSession();

        Query query = session.createQuery("delete from User where id=:userId");

        query.setParameter("userId", id);

        query.executeUpdate();
    }

    @Override
    public User loadUserByUsername(String username) {
        Session session = sessionFactory.getCurrentSession();

        Query<User> query = session.createQuery("select u from User u join fetch u.roles where u.username=:theUsername");

        query.setParameter("theUsername", username);

        User user = query.getSingleResult();

        return user;
    }


}
