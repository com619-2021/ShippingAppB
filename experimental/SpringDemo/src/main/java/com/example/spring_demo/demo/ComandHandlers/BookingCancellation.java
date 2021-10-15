package com.example.spring_demo.demo.ComandHandlers;

import com.example.spring_demo.demo.IRestCallHandler;

import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class BookingCancellation implements IRestCallHandler
{
    // TODO when the booking reference is confirmed, the regex could be improved.
    /**
     * The regular expression used to check the command is handleable.
     */
    private final String commandRegex = "^cancel:$";

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
        // TODO implement.
        return null;
    }
}
