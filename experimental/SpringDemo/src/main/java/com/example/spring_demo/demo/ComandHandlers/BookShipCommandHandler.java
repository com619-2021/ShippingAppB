package com.example.spring_demo.demo.ComandHandlers;

import com.example.spring_demo.demo.IRestCallHandler;

import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class BookShipCommandHandler implements IRestCallHandler
{
    private String commandRegex = "^bookship:size:(\\d+),cargo:([a-z]+)$";

    @Override
    public Boolean canHandle(String command)
    {
        Pattern pattern = Pattern.compile(commandRegex);
        Matcher matcher = pattern.matcher(command.toLowerCase(Locale.ROOT));
        return matcher.matches();
    }

    @Override
    public String handle(String command)
    {
        return String.format("200");
    }
}
