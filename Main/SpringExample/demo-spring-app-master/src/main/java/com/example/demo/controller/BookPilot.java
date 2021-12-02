package com.example.demo.controller;

import BusinessLogicLayer.HarbourService;
import BusinessLogicLayer.JsonParser;
import BusinessLogicLayer.RestfulObjects.Berth;
import BusinessLogicLayer.RestfulObjects.Ship;
import BusinessLogicLayer.RestfulObjects.ShipType;

import java.time.LocalDate;
import java.util.UUID;

public class BookPilot
{
    public String bookPilot()
    {
        try
        {
            var urls = JsonParser.loadUrlConfig();
            var ship = new Ship(254.7, 235.67, 346, UUID.randomUUID(), ShipType.FERRY);
            var berth = new Berth(UUID.randomUUID().toString());
            var harbourService = new HarbourService(urls, ship, berth, LocalDate.now());
            var result = harbourService.getPilotAvailabilities();
            if (!result)
            {
                return "Error";
            }

            var order = harbourService.postPilotOrder();
            return order;
        }
        catch (Exception e)
        {
            //// TODO log this
            return "Error: " + e.getMessage();
        }
    }
}
