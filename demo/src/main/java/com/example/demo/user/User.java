package com.example.demo.user;

import javax.persistence.*;

@Entity
@Table
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
    private String FName;
    private String SName;
    private String Role;
    private String pswd;

    public User(String FName, String SName, String role, String pswd) {
        this.FName = FName;
        this.SName = SName;
        Role = role;
        this.pswd = pswd;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setFName(String FName) {
        this.FName = FName;
    }

    public void setSName(String SName) {
        this.SName = SName;
    }

    public void setRole(String role) {
        Role = role;
    }

    public void setPswd(String pswd) {
        this.pswd = pswd;
    }

    public long getId() {
        return id;
    }

    public String getFName() {
        return FName;
    }

    public String getSName() {
        return SName;
    }

    public String getRole() {
        return Role;
    }

    public String getPswd() {
        return pswd;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", FName='" + FName + '\'' +
                ", SName='" + SName + '\'' +
                ", Role='" + Role + '\'' +
                ", pswd='" + pswd + '\'' +
                '}';
    }
}
