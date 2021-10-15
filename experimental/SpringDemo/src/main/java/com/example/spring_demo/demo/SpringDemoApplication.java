package com.example.spring_demo.demo;

import com.example.spring_demo.demo.ComandHandlers.BookShipCommandHandler;
import com.example.spring_demo.demo.ComandHandlers.BookingCancellation;
import com.example.spring_demo.demo.ComandHandlers.CommandHandlerProcess;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
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
	/**
	 * object that configures the command handlers
	 */
	private static CommandHandlerProcess commandHandlerProcess;

	/**
	 * The logger.
	 */
	private static final Logger logger = LogManager.getLogger(SpringApplication.class);

	/**
	 * The entry point for the application.
	 * @param args command line arguments
	 */
	public static void main(String[] args)
	{
		Initialize();
		logger.info("Starting the application");
		SpringApplication.run(SpringDemoApplication.class, args);
	}

	/**
	 * Creates the necessary objects for the service to run.
	 */
	private static void Initialize()
	{
		List<IRestCallHandler> commandHandlers = Arrays.asList(new BookShipCommandHandler(), new BookingCancellation());
		commandHandlerProcess = new CommandHandlerProcess(commandHandlers);
	}

	/**
	 * Implements REST API to listen for commands directed at our service.
	 * @param command the request for the service.
	 * @return Universal http code depending on result of request.
	 */
	@GetMapping("/shippingb")
	public String receiveCommand(@RequestParam(value = "command", defaultValue = "") String command)
	{
		try
		{
			var handler = commandHandlerProcess.GetCommandHandler(command);
			return handler.handle(command);
		}
		catch(Exception e)
		{
			logger.error("Command not found");
			return String.format("error 400, bad request");
		}
	}
}

