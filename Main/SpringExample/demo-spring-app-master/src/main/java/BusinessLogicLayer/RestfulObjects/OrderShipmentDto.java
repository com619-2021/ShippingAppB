package BusinessLogicLayer.RestfulObjects;

public class OrderShipmentDto
{
    /**
     * the type of ship needed.
     */
    private final ShipType shipType;

    /**
     * the total weight of the shipment.
     */
    private final double totalWeight;

    /**
     * the stevedore services requested by customer.
     */
    private final StevedoreServicesOrdered stevedoreServices;

    /**
     * Initializes a new instance of the OrderShipmentDto class.
     * @param shipType the type of ship needed.
     * @param totalWeight the total weight of the shipment.
     * @param stevedoreServices the stevedore services requested by customer.
     */
    public OrderShipmentDto(ShipType shipType, double totalWeight, StevedoreServicesOrdered stevedoreServices)
    {
        this.shipType = shipType;
        this.totalWeight = totalWeight;
        this.stevedoreServices = stevedoreServices;
    }

    /**
     * Gets the type of ship needed.
     * @return the ship type.
     */
    public ShipType getShipType()
    {
        return shipType;
    }

    /**
     * Gets the total weight of the shipment
     * @return the total weight of shipment.
     */
    public double getTotalWeight()
    {
        return totalWeight;
    }

    /**
     * Gets the stevedore services requested by customer.
     * @return the stevedore services requested by customer.
     */
    public StevedoreServicesOrdered getStevedoreServices()
    {
        return stevedoreServices;
    }
}
