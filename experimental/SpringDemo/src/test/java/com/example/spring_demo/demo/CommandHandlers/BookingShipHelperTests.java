package com.example.spring_demo.demo.CommandHandlers;

import com.example.spring_demo.demo.ComandHandlers.Helpers.BookingShipHelper;
import com.example.spring_demo.demo.DatabaseOperations.BookingInformationDAO;
import org.junit.Assert;
import org.junit.jupiter.api.Test;

import static org.hamcrest.Matchers.samePropertyValuesAs;

public class BookingShipHelperTests
{
    @Test
    public void ValuesGetExtractedFromCommand()
    {
        final String command = "bookship:number_of_passengers:12,cargo:phones,weight_in_kg:120.00";
        var expected = new BookingInformationDAO(12, "phones", 120.00);

        var actual = BookingShipHelper.ExtractData(command);

        Assert.assertThat(actual, samePropertyValuesAs(expected));
    }
}
