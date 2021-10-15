package com.example.spring_demo.demo;

import com.example.spring_demo.demo.ComandHandlers.BookShipCommandHandler;
import com.example.spring_demo.demo.ComandHandlers.CommandHandlerProcess;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@SpringBootApplication
@RestController
public class SpringDemoApplication
{
	private static CommandHandlerProcess commandHandlerProcess;

	public static void main(String[] args)
	{
		Initialize();
		SpringApplication.run(SpringDemoApplication.class, args);
	}

	private static void Initialize()
	{
		List<IRestCallHandler> commandHandlers = Arrays.asList(new BookShipCommandHandler());
		commandHandlerProcess = new CommandHandlerProcess(commandHandlers);
	}

	@GetMapping("/hello")
	public String hello(@RequestParam(value = "name", defaultValue = "World") String name)
	{
		return String.format("Hello %s!", name);
	}

	@GetMapping("/")
	public String receiveCommand(@RequestParam(value = "command", defaultValue = "") String command)
	{
		try
		{
			var handler = commandHandlerProcess.GetCommandHandler(command);
			return handler.handle(command);
		}
		catch(Exception e)
		{
			return String.format("error 400, bad request");
		}
	}
}

