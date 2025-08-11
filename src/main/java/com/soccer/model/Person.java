package com.soccer.model;

import org.springframework.data.annotation.Id;

public abstract class Person {

    @Id
    private int id;
    protected String name;
    protected int age;
    protected String gender;
    protected String phone;
    protected String email;
    protected String password;
    protected String role;

}
