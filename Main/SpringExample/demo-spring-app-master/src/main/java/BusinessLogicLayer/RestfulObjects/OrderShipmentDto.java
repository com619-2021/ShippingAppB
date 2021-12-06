package BusinessLogicLayer.RestfulObjects;

public class OrderShipmentDto
{
    /**
     * the type of ship needed.
     */
    private final ShipType shipType;

    /**
     * the stevedore services requested by customer.
     */
    private final StevedoreServicesOrdered stevedoreServices;

    /**
     * Whether the cargo shipment is in TEU or 2TEU containers
     */
    private final boolean usingTeuContainers;

    /**
     * The number of containers going on board.
     */
    private final double numberOfContainers;

    /**
     * The number of passengers on board.
     */
    private final double numberOfPassengers;

    /**
     * Initializes a new instance of the OrderShipmentDto class.
     * @param shipType the type of ship needed.
     * @param stevedoreServices the stevedore services requested by customer.
     * @param usingTeuContainers whether the customer is using TEU or 2 TEU containers.
     * @param numberOfContainers number of containers customer wants shipping.
     * @param numberOfPassengers number of passengers customer wants transporting.
     */
    public OrderShipmentDto(ShipType shipType,
                            StevedoreServicesOrdered stevedoreServices,
                            boolean usingTeuContainers,
                            double numberOfContainers,
                            double numberOfPassengers)
    {
        this.shipType = shipType;
        this.stevedoreServices = stevedoreServices;
        this.usingTeuContainers = usingTeuContainers;
        this.numberOfContainers = numberOfContainers;
        this.numberOfPassengers = numberOfPassengers;
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
     * Gets the stevedore services requested by customer.
     * @return the stevedore services requested by customer.
     */
    public StevedoreServicesOrdered getStevedoreServices()
    {
        return stevedoreServices;
    }

    public boolean isUsingTeuContainers()
    {
        return usingTeuContainers;
    }

    public double getNumberOfContainers()
    {
        return numberOfContainers;
    }

    public double getNumberOfPassengers()
    {
        return numberOfPassengers;
    }
}
