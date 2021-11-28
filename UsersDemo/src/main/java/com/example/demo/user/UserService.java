package com.example.demo.user;

import org.springframework.stereotype.Service;

@Service
public class UserService {
    public String hi(){
        User a=new User("Ivan","petkov","sth","123");
        return a.toString();
    }
}
