package com.example.demo.controller;

import BusinessLogicLayer.*;
import BusinessLogicLayer.RestfulObjects.Berth;
import BusinessLogicLayer.RestfulObjects.OrderShipmentDto;
import BusinessLogicLayer.RestfulObjects.Ship;
import BusinessLogicLayer.RestfulObjects.ShipType;

import java.net.URL;
import java.time.LocalDate;
import java.util.UUID;

public class OrderShipment
{
    /**
     * The needs of the customer.
     */
    private final OrderShipmentDto orderShipmentDto;

    private final UrlConfig urlConfig;

    private final IPortService portService;

    private final IHarbourService harbourService;

    private final IStevedoreService stevedoreService;

    /**
     * Initializes a new instance of the OrderShipmentDto.
     * @param orderShipmentDto The customer's requirements.
     * @param portService the object used to book port services
     * @param harbourService the object used to book harbour services.
     * @param stevedoreService the object used to book stevedore services.
     * @param urlConfig the object holding all URLs for bookings
     */
    public OrderShipment(
            OrderShipmentDto orderShipmentDto,
            IPortService portService,
            IHarbourService harbourService,
            IStevedoreService stevedoreService,
            UrlConfig urlConfig)
    {
        this.orderShipmentDto = orderShipmentDto;
        this.portService = portService;
        this.harbourService = harbourService;
        this.stevedoreService = stevedoreService;
        this.urlConfig = urlConfig;
    }

    public String placeOrder() throws Exception
    {
        var ship = this.chooseShip();
        var getBerthAvailabilityUrl = new URL(this.urlConfig.getRequestPortUrl());
        var dateOfArrival = LocalDate.parse(this.orderShipmentDto.getDayOfArrival());
        var berths = this.portService.getBerthAvailability(ship, dateOfArrival, getBerthAvailabilityUrl);

        if (berths.isEmpty())
        {
            throw new Exception("There are no available berths");
        }

        var berth = new Berth(berths.get(0));

        var pilotAvailable = this.harbourService.getPilotAvailabilities(new URL(urlConfig.getPilotAvailabilityUrl()),ship ,berth , dateOfArrival);

        if(!pilotAvailable)
        {
            throw new Exception("There are no available pilots");
        }

        var stevedoreReceipt = this.stevedoreService.orderStevedore(
                new URL(this.urlConfig.getOrderStevedoreUrl()),
                dateOfArrival,
                this.orderShipmentDto.getStevedoreServices(),
                berth);
        var url = new URL(this.urlConfig.getOrderPortUrl());
        var dayOfBooking = LocalDate.parse(this.orderShipmentDto.getDayOfArrival());
        var berthReceipt = this.portService.orderPort(berth.getBerthId(), dayOfBooking, url);
        var pilotReceipt = this.harbourService.postPilotOrder(new URL(urlConfig.getOrderPilotUrl()),ship ,berth , dateOfArrival);
        var total = stevedoreReceipt.getTotalPrice() + berthReceipt.getTotalPrice() + pilotReceipt.getTotalPrice();
        return "" + total;
    }

    private Ship chooseShip()
    {
        Ship ship = null;
        if (this.orderShipmentDto.getShipType() == ShipType.CARGO)
        {
            ship = this.orderTeuCargoShip();
        }
        else if (this.orderShipmentDto.getShipType() == ShipType.FERRY)
        {
            ship = this.orderFerry();
        }
        else if (this.orderShipmentDto.getShipType() == ShipType.PASSENGER)
        {
            this.orderPassenger();
        }
        return ship;
    }

    private Ship orderTeuCargoShip()
    {
        var uuid = UUID.randomUUID();
        ShipMeasurements shipMeasurements;
        if(this.orderShipmentDto.getNumberOfContainers() <= 15000)
        {
            shipMeasurements = new ShipMeasurements(263.33, 521, 790);
        }
        else if (this.orderShipmentDto.getNumberOfContainers() <= 20000)
        {
            shipMeasurements = new ShipMeasurements(467.58, 1500, 1000);
        }
        else
        {
            shipMeasurements = new ShipMeasurements(753.33, 1790, 1521);
        }

        return new Ship(shipMeasurements.shipDraft, shipMeasurements.shipLength, shipMeasurements.shipWidth, uuid,
                this.orderShipmentDto.getShipType());
    }

    private Ship orderFerry()
    {
        var uuid = UUID.randomUUID();
        ShipMeasurements shipMeasurements;
        if(this.orderShipmentDto.getNumberOfPassengers() <= 1500)
        {
            shipMeasurements = new ShipMeasurements(263.33, 521, 790);
        }
        else if (this.orderShipmentDto.getNumberOfPassengers() <= 2000)
        {
            shipMeasurements = new ShipMeasurements(467.58, 1500, 1000);
        }
        else
        {
            shipMeasurements = new ShipMeasurements(753.33, 1790, 1521);
        }

        return new Ship(shipMeasurements.shipDraft, shipMeasurements.shipLength, shipMeasurements.shipWidth, uuid,
                this.orderShipmentDto.getShipType());
    }

    private Ship orderPassenger()
    {
        var uuid = UUID.randomUUID();
        ShipMeasurements shipMeasurements;
        if(this.orderShipmentDto.getNumberOfPassengers() <= 150)
        {
            shipMeasurements = new ShipMeasurements(150, 320, 290);
        }
        else if (this.orderShipmentDto.getNumberOfPassengers() <= 250)
        {
            shipMeasurements = new ShipMeasurements(467.58, 1500, 1000);
        }
        else
        {
            shipMeasurements = new ShipMeasurements(753.33, 1790, 1521);
        }

        return new Ship(shipMeasurements.shipDraft, shipMeasurements.shipLength, shipMeasurements.shipWidth, uuid,
                this.orderShipmentDto.getShipType());
    }

    private class ShipMeasurements
    {
        public double shipDraft;

        public double shipLength;

        public double shipWidth;

        public ShipMeasurements(double draft, double length, double width)
        {
            this.shipDraft = draft;
            this.shipLength = length;
            this.shipWidth = width;
        }
    }
}
