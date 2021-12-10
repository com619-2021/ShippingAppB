package com.example.demo.user;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository <User,Long> {

  //  @Query ( "SELECT u FROM User u WHERE u.pswd=? AND u.SName=?")
    Optional<User> findUserByCred(String pass, String name);
}
