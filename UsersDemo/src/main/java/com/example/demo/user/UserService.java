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






    public void addUser(User user) {
        Optional<User> tempuser=userRepository.findUserByCred(user.getPswd(), user.getName());
        if(tempuser.isPresent() ){
            //WRITE HERE HANDLING IF USER IS ALREADY IN THE SYSTEM
        }
       userRepository.save(tempuser);
        System.out.println("test");
    }

    public void deleteUser(Long id){
        userRepository.deleteById(id);
    }


}
