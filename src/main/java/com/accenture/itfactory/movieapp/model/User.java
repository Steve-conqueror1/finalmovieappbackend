package com.accenture.itfactory.movieapp.model;

import org.hibernate.usertype.UserType;
import org.springframework.context.annotation.Primary;

import javax.persistence.*;


@Entity
@Table(name = "UserData")
public class User{

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "cust")
    @SequenceGenerator(name = "cust", sequenceName = "seq_cust")
    private Long id;

    @Column(unique = true)
    private String login;
    private String name;

    private String password;
    private String userType;

    public User() {
    }

    public User(String name, String login, String password, String userType) {
        this.name = name;
        this.login = login;
        this.password = password;
        this.userType = userType;
    }



    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUserType() {
        return userType;
    }

    public void setUserType(String userType) {
        this.userType = userType;
    }
}
