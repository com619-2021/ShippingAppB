package com.example.spring_demo.demo;

public interface IRestCallHandler
{
    Boolean canHandle(String command);

    String handle(String command);
}
