package com.example.dao;

import com.example.entities.Usera;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserDao {

    @Autowired
    private SessionFactory sessionFactory;

    private Session getSession(){
        return sessionFactory.getCurrentSession();
    }
    public List<Usera> list(){
        return  getSession().createQuery("from Usera u left join fetch u.region").list();
    }

    public void insert(Usera usera){
        getSession().saveOrUpdate(usera);
    }

    public Usera queryById(int id) {
        return getSession().get(Usera.class,id);
    }

    public void delete(Usera usera) {
        getSession().delete(usera);
    }
}
