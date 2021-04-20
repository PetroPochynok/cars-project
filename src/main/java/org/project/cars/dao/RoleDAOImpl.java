package org.project.cars.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.project.cars.entity.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public class RoleDAOImpl implements RoleDAO{

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    @Transactional
    public Role findRoleByName(String roleName) {
        Session session = sessionFactory.getCurrentSession();

        Query<Role> query = session.createQuery("from Role where name=:theRoleName");

        query.setParameter("theRoleName", roleName);

        Role role = null;

        try{
            role = query.getSingleResult();
        } catch (Exception exc){
            role = null;
        }

        return role;
    }
}
