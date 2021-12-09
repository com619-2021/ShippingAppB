package com.example.demo.controller;

import BusinessLogicLayer.RestfulObjects.OrderShipmentDto;
import BusinessLogicLayer.RestfulObjects.Ship;
import org.apache.commons.lang3.NotImplementedException;

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
    public OrderShipment(OrderShipmentDto orderShipmentDto)
    {
        this.orderShipmentDto = orderShipmentDto;
    }

    private Ship OrderTeuCargoShip()
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

    private Ship OrderFerry()
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
