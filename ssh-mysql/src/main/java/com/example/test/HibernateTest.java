package com.example.test;

import com.example.entities.Usera;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.junit.Test;

import java.util.List;

/**
 * @className HibernateTest
 * @date 2021/4/20 19:47
 * @description
 **/
public class HibernateTest {


    @Test
    public void test1(){

        StandardServiceRegistry registry = new StandardServiceRegistryBuilder().configure().build();
        SessionFactory sessionFactory = new MetadataSources(registry).buildMetadata().buildSessionFactory();
        Session session = sessionFactory.openSession();

        System.out.println(session.get(Usera.class, 1));
    }

    @Test
    public void test2(){
        StandardServiceRegistry registry = new StandardServiceRegistryBuilder().configure().build();
        SessionFactory sessionFactory = new MetadataSources(registry).buildMetadata().buildSessionFactory();
        Session session = sessionFactory.openSession();
        List<Usera> userList = session.createQuery("from Usera u left join fetch u.region").list();

        for(Usera usera : userList)
            System.out.println(usera);
    }
}
