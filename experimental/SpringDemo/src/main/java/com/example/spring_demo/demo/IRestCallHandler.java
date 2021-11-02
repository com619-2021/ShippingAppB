package com.example.spring_demo.demo;

public interface IRestCallHandler
{
    /**
     * Checks if the command can be handled by this handler.
     * @param command the command to check.
     * @return boolean value representing if the command handler handles that command.
     */
    Boolean canHandle(String command);

    /**
     * Starts the handling process.
     * @param command the command to handle
     * @return http code depending on result.
     */
    String handle(String command);
}
