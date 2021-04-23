package com.example.test;

import com.example.entities.Usera;
import com.example.service.RegionService;
import com.example.service.UserService;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

/**
 * @className SpringHbnTest
 * @date 2021/4/21 10:25
 * @description
 **/

public class SpringHbnTest {
    
    @Test
    public void test1(){
        ClassPathXmlApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
        SessionFactory sessionFactory = (SessionFactory) ac.getBean("sessionFactory");
        Session session = sessionFactory.openSession();
        List<Usera> list = session.createQuery("from Usera u left join fetch u.region").list();

        for(Usera usera : list)
            System.out.println(usera);
    }

    @Test
    public void test2(){
        ClassPathXmlApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
        UserService userService = (UserService) ac.getBean("userService");

        System.out.println(userService.list());

        System.out.println(ac.getBean("userAction"));
    }

    @Test
    public void test3(){
        ClassPathXmlApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
        RegionService regionService = (RegionService) ac.getBean("regionService");
        System.out.println(regionService.list());
    }
}
