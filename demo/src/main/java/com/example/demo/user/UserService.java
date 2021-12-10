package com.example.demo.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<User> getUsers(){
        return userRepository.findAll();
    }




    public String hi(){
        User a=new User("Ivan","petkov","sth","123");
        return a.toString();
    }

    public void addUser(User user) {
        System.out.println("test");
    }
}
