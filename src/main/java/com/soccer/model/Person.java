package com.soccer.model;


import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Field;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public abstract class Person {
    @Id
    private String id;

    @Field
    protected String name;
    protected String email;
    protected String password;
    protected String role;
    protected int age;
    protected String phone;




}
