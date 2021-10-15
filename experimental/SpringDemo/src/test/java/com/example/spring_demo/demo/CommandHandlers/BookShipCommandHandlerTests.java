package com.example.spring_demo.demo.CommandHandlers;

import com.example.spring_demo.demo.ComandHandlers.BookShipCommandHandler;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.springframework.util.Assert;

public class BookShipCommandHandlerTests
{
    @ParameterizedTest
    @ValueSource(strings = {
            "bookship:number_of_passengers:5,cargo:phones,weight_in_kg:6777777.00",
            "bookship:number_of_passengers:567,cargo:TEST,weight_in_kg:56.00",
            "bookship:number_of_passengers:567,cargo:TEST,weight_in_kg:56.20"
            })
    public void canHandleExpectedTest(String input)
    {
        var handler = new BookShipCommandHandler();
        var actual = handler.canHandle(input);
        Assert.isTrue(actual, "command: " + input + "expected was true actual was: "+ actual);
    }

    @ParameterizedTest
    @ValueSource(strings = {
            "bookship :number_of_passengers:56,cargo:test,weight_in_kg:50",
            "bookship:number_of_passengers:/,cargo:test", "book_ship:number_of_passengers:567,cargo:test,weight_in_kg:50",
            "bookship:number_of_passengers:567,cargo:TEST,weight_in_kg:5f",
            "bookship:number_of_passengers:567,cargo:TEST,weight_in_kg:.",
            "bookship:number_of_passengers:567,cargo:TEST,weight_in_kg:45.001",
            "bookship:number_of_passengers:567,cargo:TEST,weight_in_kg:45.1"
    })
    public void cannotHandleExpectedTest(String input)
    {
        var handler = new BookShipCommandHandler();
        var actual = handler.canHandle(input);
        Assert.isTrue(!actual, "command received: " + input +" expected was false actual was: " + actual);
    }
}
