package com.example.demo.orders;

import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.Month;

@Service
public class OrderService {
    public String hi(){
        Order a=new Order(LocalDate.of(2020, Month.APRIL,6),50.0,50.0,50.0,"FERRY");
        return a.toString();
    }
}
