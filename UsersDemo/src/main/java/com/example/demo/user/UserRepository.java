package com.example.demo.user;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository <User,Long> {

    @Query ( "SELECT u FROM User u WHERE u.pswd=?1 AND u.name=?1 ")
    Optional<User> findUserByCred(String pass, String name);

    Optional<User> save(Optional<User> user);

}
