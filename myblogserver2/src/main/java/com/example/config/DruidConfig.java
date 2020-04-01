package com.example.config;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.support.http.StatViewServlet;
import com.alibaba.druid.support.http.WebStatFilter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.servlet.ServletRegistration;
import javax.sql.DataSource;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Create by Administrator on 2020/4/1.
 *
 *
 * Druid连接池配置
 */
@Configuration
public class DruidConfig {

    @ConfigurationProperties(prefix = "spring.datasource")
    @Bean //(initMethod = "init",destroyMethod = "close")
    public DataSource dataSource(){
        return new DruidDataSource();
    }

    //1.配置一个后台管理的servlet
    @Bean
    public ServletRegistrationBean statViewServlet(){
        ServletRegistrationBean<StatViewServlet> registrationBean = new ServletRegistrationBean<>(new StatViewServlet(), "/druid/*");

        //设置初始化参数
        Map<String, String> init = new HashMap<>();
        init.put(StatViewServlet.PARAM_NAME_USERNAME, "root");
        init.put(StatViewServlet.PARAM_NAME_PASSWORD, "root");

        //如果不写 则默认所有ip都能访问
        init.put(StatViewServlet.PARAM_NAME_ALLOW, "192.168.11.1");
        init.put(StatViewServlet.PARAM_NAME_DENY, "");

        registrationBean.setInitParameters(init);

        return registrationBean;
    }

    //2.配置druid的filter
    @Bean
    public FilterRegistrationBean druidFilter(){
        FilterRegistrationBean filterRegistrationBean = new FilterRegistrationBean();
        filterRegistrationBean.setFilter(new WebStatFilter());

        Map initparam = new HashMap();
        initparam.put(WebStatFilter.PARAM_NAME_EXCLUSIONS, "*.js,*.css,/druid/*");
        filterRegistrationBean.setInitParameters(initparam);

        //设置拦截请求
        filterRegistrationBean.setUrlPatterns(Arrays.asList("/*"));
        return filterRegistrationBean;
    }
}
