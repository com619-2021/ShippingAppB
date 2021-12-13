package com.example.demo.user;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;

@Configuration
public class UserConfig {


//    @Bean
//    @Autowired
//    CommandLineRunner commandLineRunner(UserRepository repository){
//        return args -> {
//            User a=new User("ship1","USER","23456");
//            User b=new User("ship2","USER","23456");
//
//            repository.saveAll(List.of(a,b));
//        };
//
//     };
    private UserRepository userRepository;

    @Autowired
    public UserConfig(UserRepository userRepository) {
        this.userRepository = userRepository;
        LoadUsers();
    }

    private void LoadUsers() {
        System.out.println("*********** debug - adding users");
        User a = new User("ship1", "USER", "23456");
        User b = new User("ship2", "USER", "23456");
        userRepository.saveAll(List.of(a, b));
    }

}
