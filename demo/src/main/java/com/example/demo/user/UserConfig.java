package com.example.demo.user;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class UserConfig {

    @Bean
    CommandLineRunner commandLineRunner(UserRepository repository){
        return args -> {
            User a=new User("Fname","Sname","USER","23456");
            User b=new User("Fname","Sname","USER","23456");

            repository.saveAll(List.of(a,b));
        };

     };
}
