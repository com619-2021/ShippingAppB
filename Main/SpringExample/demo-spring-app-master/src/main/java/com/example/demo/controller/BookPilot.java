package com.example.demo.controller;

import BusinessLogicLayer.HarbourService;
import BusinessLogicLayer.JsonParser;
import BusinessLogicLayer.RestfulObjects.Berth;
import BusinessLogicLayer.RestfulObjects.Ship;
import BusinessLogicLayer.RestfulObjects.ShipType;
import ServiceRequestor.ServiceCaller;

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
            var serviceCaller = new ServiceCaller(new URL(urls.getOrderPilotUrl()));
            var harbourService = new HarbourService(ship, berth, LocalDate.now(), serviceCaller);
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
