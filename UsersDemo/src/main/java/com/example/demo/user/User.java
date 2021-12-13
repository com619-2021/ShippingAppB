package com.example.demo.user;

import javax.persistence.*;

@Entity
//@Table
public class User {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    @SequenceGenerator(
//            name="user_sequence",
//            sequenceName = "user_sequence",
//            allocationSize = 1
//    )
//    @GeneratedValue(
//            strategy = GenerationType.SEQUENCE,
//            generator = "user_sequence"
//    )
    private Long id;
    private String name;
    private String role;
    private String pswd;

    public User() {
    }

    public User(Long id, String name, String role, String pswd) {
        this.id = id;
        this.name = name;
        this.role = role;
        this.pswd = pswd;
    }

    public User(String name, String role, String pswd) {
        this.name = name;
        this.role = role;
        this.pswd = pswd;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getPswd() {
        return pswd;
    }

    public void setPswd(String pswd) {
        this.pswd = pswd;
    }

   @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", Name='" + name + '\'' +
                ", Role='" + role + '\'' +
                ", pswd='" + pswd + '\'' +
                '}';
    }
    
    
}
