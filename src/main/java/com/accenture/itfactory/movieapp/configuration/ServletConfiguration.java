package com.accenture.itfactory.movieapp.configuration;

import com.accenture.itfactory.movieapp.servlet.Login;
import com.accenture.itfactory.movieapp.servlet.Register;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import javax.servlet.http.HttpServlet;

@Configuration
@ComponentScan("com.accenture.itfactory.movieapp")
public class ServletConfiguration{
    @Bean
    public ServletRegistrationBean<HttpServlet> servletRegister() {
        ServletRegistrationBean<HttpServlet> bean = new ServletRegistrationBean<>();
        bean.setServlet(new Register());
        bean.addUrlMappings("/user/register");
        bean.setLoadOnStartup(1);
        return bean;
    }

    @Bean
    public ServletRegistrationBean<HttpServlet> servletLogin() {
        ServletRegistrationBean<HttpServlet> bean = new ServletRegistrationBean<>();
        bean.setServlet(new Login());
        bean.addUrlMappings("/user/login");
        bean.setLoadOnStartup(1);
        return bean;
    }

//    @Bean
//    public UserService getUserRepository() {
//        return new UserRepositoryImpl();
//    }

}
