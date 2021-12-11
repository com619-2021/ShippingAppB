package com.example.demo.controller;

import BusinessLogicLayer.HarbourService;
import BusinessLogicLayer.JsonParser;
import BusinessLogicLayer.RestfulObjects.Berth;
import BusinessLogicLayer.RestfulObjects.Ship;
import BusinessLogicLayer.RestfulObjects.ShipType;
import RestfulComms.ServiceCaller;

import java.net.URL;
import java.time.LocalDate;
import java.util.UUID;

public class BookPilot
{
    public String bookPilot()
    {
        try
        {
            var urls = JsonParser.loadUrlConfig("/home/data");
            var ship = new Ship(254.7, 235.67, 346, UUID.randomUUID(), ShipType.FERRY);
            var berth = new Berth(UUID.randomUUID().toString());
            var serviceCaller = new ServiceCaller();
            var harbourService = new HarbourService(serviceCaller);
            var result = harbourService.getPilotAvailabilities(new URL(urls.getPilotAvailabilityUrl()), ship, berth, LocalDate.now());
            if (!result)
            {
                return "Error";
            }

            var order = harbourService.postPilotOrder(new URL(urls.getOrderPilotUrl()),ship ,berth , LocalDate.now());
            return ""+order.getTotalPrice();
        }
        catch (Exception e)
        {
            //// TODO log this
            return "Error: " + e.getMessage();
        }
    }
}
