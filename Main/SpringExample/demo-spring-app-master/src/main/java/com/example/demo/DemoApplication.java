package com.example.demo;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.servers.Server;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.File;

@OpenAPIDefinition( 
    servers = {
       @Server(url = "/", description = "Default Server URL")
    }
) 
@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args)
	{
		SpringApplication.run(DemoApplication.class, args);
	}

}
