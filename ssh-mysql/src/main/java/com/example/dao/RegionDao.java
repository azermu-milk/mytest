package com.example.dao;

import com.example.entities.Region;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @className RegionDao
 * @date 2021/4/21 21:05
 * @description
 **/
@Repository
public class RegionDao {
    @Autowired
    private SessionFactory sessionFactory;
    private Session getSession(){
        return sessionFactory.getCurrentSession();
    }

    public List<Region> list(){
        return getSession().createQuery("from Region").list();
    }
}
