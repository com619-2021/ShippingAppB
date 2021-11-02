package com.example.spring_demo.demo.ComandHandlers;

import com.example.spring_demo.demo.ComandHandlers.Helpers.BookingShipHelper;
import com.example.spring_demo.demo.IRestCallHandler;

import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class BookShipCommandHandler implements IRestCallHandler
{
    /**
     * The regular expression for checking the command is handleable.
     */
    private String commandRegex = "^bookship:number_of_passengers:(\\d+),cargo:([a-z]+),weight_in_kg:(\\d+).(\\d\\d)$";

    /**
     * Checks if the command can be handled by this handler.
     * @param command the command to check.
     * @return boolean value representing if the command handler handles that command.
     */
    @Override
    public Boolean canHandle(String command)
    {
        Pattern pattern = Pattern.compile(commandRegex);
        Matcher matcher = pattern.matcher(command.toLowerCase(Locale.ROOT));
        return matcher.matches();
    }

    /**
     * Starts the handling process.
     * @param command the command to handle
     * @return http code depending on result.
     */
    @Override
    public String handle(String command)
    {
        var bookingData = BookingShipHelper.ExtractData(command);

        final String successMessage = "200";
        return String.format(successMessage);
    }
}
