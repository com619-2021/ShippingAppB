package com.example.demo.controller;

import BusinessLogicLayer.*;
import BusinessLogicLayer.RestfulObjects.Berth;
import BusinessLogicLayer.RestfulObjects.OrderShipmentDto;
import BusinessLogicLayer.RestfulObjects.Ship;
import BusinessLogicLayer.RestfulObjects.ShipType;
import UnitTests.ServiceCaller;
import com.google.gson.Gson;

import java.net.URL;
import java.time.LocalDate;
import java.util.UUID;

public class OrderShipment
{
    /**
     * The needs of the customer.
     */
    private final OrderShipmentDto orderShipmentDto;

    /**
     * Initializes a new instance of the OrderShipmentDto.
     * @param orderShipmentDto The customer's requirements.
     */
    public OrderShipment(
            OrderShipmentDto orderShipmentDto,
            IPortService portServiceCaller,
            IHarbourService harbourServiceCaller)
    {
        this.orderShipmentDto = orderShipmentDto;
    }

    private String PlaceOrder() throws Exception
    {
        var ship = this.chooseShip();
        var url = JsonParser.loadUrlConfig("/home/data");
        var portServiceCaller = new ServiceCaller(new URL(url.getRequestPortUrl()));
        var portService = new PortService(
                ship.getDraft(),
                ship.getLength(),
                ship.getWidth(),
                LocalDate.parse(this.orderShipmentDto.getDayOfArrival()),
                ship.getUuid(),
                this.orderShipmentDto.getShipType(),
                portServiceCaller);

        var berths = portService.getBerthAvailability();

        if (berths.isEmpty())
        {
            throw new Exception("There are no available berths");
        }

        var berth = new Berth(berths.get(0));
        var harbourAvailabilityServiceCaller = new ServiceCaller(new URL(url.getPilotAvailabilityUrl()));
        var harbourService = new HarbourService(
                ship,
                berth,
                LocalDate.parse(this.orderShipmentDto.getDayOfArrival()),
                harbourAvailabilityServiceCaller);

        var pilotAvailable = harbourService.getPilotAvailabilities();

        if(!pilotAvailable)
        {
            throw new Exception("There are no available pilots");
        }

        var stevedoreServiceCaller = new ServiceCaller(new URL(url.getOrderStevedoreUrl()));

        var stevedoreService = new StevedoreService(
                LocalDate.parse(this.orderShipmentDto.getDayOfArrival()),
                this.orderShipmentDto.getStevedoreServices(),
                berth,
                stevedoreServiceCaller);

        var stevedoreReceipt = stevedoreService.orderStevedore();
        var berthReceipt = portService.orderPort(berth.getBerthId());
        var pilotReceipt = harbourService.postPilotOrder();
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
