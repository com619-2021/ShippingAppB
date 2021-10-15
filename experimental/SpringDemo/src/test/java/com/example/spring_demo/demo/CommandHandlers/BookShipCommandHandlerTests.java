package com.example.spring_demo.demo.CommandHandlers;

import com.example.spring_demo.demo.ComandHandlers.BookShipCommandHandler;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.springframework.util.Assert;

public class BookShipCommandHandlerTests
{
    @ParameterizedTest
    @ValueSource(strings = {"bookship:size:56,cargo:test", "bookship:size:567,cargo:TEST"})
    public void canHandleExpectedTest(String input)
    {
        var handler = new BookShipCommandHandler();
        var actual = handler.canHandle(input);
        Assert.isTrue(actual, "expected was true actual was: "+ actual);
    }

    @ParameterizedTest
    @ValueSource(strings = {"bookship :size:56,cargo:test", "bookship:size:/,cargo:test", "book_ship:size:567,cargo:test"})
    public void cannotHandleExpectedTest(String input)
    {
        var handler = new BookShipCommandHandler();
        var actual = handler.canHandle(input);
        Assert.isTrue(!actual, "command received: " + input +" expected was false actual was: " + actual);
    }
}
