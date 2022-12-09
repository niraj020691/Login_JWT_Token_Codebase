package com.demologin.logintask.entity;

import javax.persistence.*;

@Entity
@Table(name="users")
public class User {


    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="userid")
    private Long user_id;
    @Id
    @Column(name="email")
    private String email;

    @Column(name="password")
    private String password;
    @Column(name="username")
    private String first_name;

    public User() {
    }

    public Long getUser_id() {
        return user_id;
    }

    public void setUser_id(Long user_id) {
        this.user_id = user_id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public User(String email, String password, String first_name) {
        this.email = email;
        this.password = password;
        this.first_name = first_name;
    }

    public User(String email, String password) {
        this.email = email;
        this.password = password;
    }
}
