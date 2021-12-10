package com.example.demo.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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
        Optional<User> tempuser=userRepository.findUserByCred(user.getPswd(), user.getSName());
        if(tempuser.isPresent() ){
            //WRITE HERE
        }
        System.out.println("test");
    }

    public void deleteUser(Long id){
        userRepository.deleteById(id);
    }

    public void deleteUserByName(String fName, String lName){
        userRepository.deleteByName(fName,lName);
    }
}
