package com.example.test;

import com.example.dao.AccountDao;
import com.example.domain.Account;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;

/**
 * @className TestMybatis
 * @date 2021/3/30 15:35
 * @description
 **/
public class TestMybatis {

    @Test
    public void test1() throws IOException {
        InputStream is = Resources.getResourceAsStream("MybatisConfig.xml");
        SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
        SqlSessionFactory factory = builder.build(is);
        SqlSession session = factory.openSession(true);

        AccountDao accountDao = session.getMapper(AccountDao.class);

        for(Account account : accountDao.findAll())
            System.out.println(account);
    }

}
