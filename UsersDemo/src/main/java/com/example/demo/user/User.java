package com.example.demo.user;

import javax.persistence.*;

@Entity
@Table(name="user_table")
public class User {
    @Id
    @SequenceGenerator(
            name="user_sequence",
            sequenceName = "user_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "user_sequence"
    )
    private Long id;
    private String Name;
    private String Role;
    private String pswd;

    public User() {
    }

    public User(Long id, String name, String role, String pswd) {
        this.id = id;
        Name = name;
        Role = role;
        this.pswd = pswd;
    }

    public User(String name, String role, String pswd) {
        Name = name;
        Role = role;
        this.pswd = pswd;
    }

    public Long getId() {
        return id;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", Name='" + Name + '\'' +
                ", Role='" + Role + '\'' +
                ", pswd='" + pswd + '\'' +
                '}';
    }

    public String getName() {
        return Name;
    }

    public String getRole() {
        return Role;
    }

    public String getPswd() {
        return pswd;
    }
}
