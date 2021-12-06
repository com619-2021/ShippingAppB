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
        double shipLength = 500;
        double shipWidth = 350;
        double shipDraft = 150;
        if(this.orderShipmentDto.getNumberOfContainers() <= 15000)
        {
            shipLength = 790;
            shipWidth = 521;
            shipDraft = 263.33;
        }

        return new Ship(shipDraft, shipLength, shipWidth, uuid, this.orderShipmentDto.getShipType());
    }
}
