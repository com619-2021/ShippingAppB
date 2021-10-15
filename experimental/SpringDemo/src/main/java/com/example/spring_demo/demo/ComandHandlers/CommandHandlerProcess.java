package com.example.spring_demo.demo.ComandHandlers;

import com.example.spring_demo.demo.IRestCallHandler;

import java.util.List;

public class CommandHandlerProcess
{
    private List<IRestCallHandler> commandHandlers;

    public CommandHandlerProcess(List<IRestCallHandler> commandHandlers)
    {
        this.commandHandlers = commandHandlers;
    }

    public IRestCallHandler GetCommandHandler(String command) throws Exception
    {
        for(var i =0; i < commandHandlers.size(); i++)
        {
            var handler = commandHandlers.get(i);
            if(handler.canHandle(command))
            {
                return handler;
            }
        }

        throw new Exception("the command cannot be handled");
    }
}
