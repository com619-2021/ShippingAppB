package com.example.spring_demo.demo.ComandHandlers.Helpers;

import com.example.spring_demo.demo.DatabaseOperations.BookingInformationDAO;

public class BookingShipHelper
{
    /**
     * Extracts the booking info from command.
     * @param command the command to get the data from.
     * @return a data access object that represents the shipping info.
     */
    public static BookingInformationDAO ExtractData(String command)
    {
        //TODO add error handling.

        var cargoInfo = command.split(",");

        var numberOfPassengers = cargoInfo[0].split(":")[2];
        var convertedNumberOfPassengers = Integer.valueOf(numberOfPassengers);

        var cargo = cargoInfo[1].split(":")[1];

        var weight_in_kilograms = Double.valueOf(cargoInfo[2].split(":")[1]);

        var bookingInfo = new BookingInformationDAO(convertedNumberOfPassengers, cargo, weight_in_kilograms);
        return bookingInfo;
    }
}
