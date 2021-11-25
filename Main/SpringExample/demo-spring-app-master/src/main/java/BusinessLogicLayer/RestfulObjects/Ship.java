package BusinessLogicLayer.RestfulObjects;

import java.util.UUID;

public class Ship
{

    /**
     * The length of the ship
     */
    private final double shipLength;

    /**
     * The width of the ship
     */
    private final double shipWidth;

    /**
     * the vertical distance between the waterline and the bottom of the hull
     */
    private final double shipDraft;

    /**
     * The unique identifier for the ship
     */
    private final UUID uuid;

    /**
     * The class of ship
     */
    private final ShipType shipType;

    /**
     * Gets the ships length
     * @return the ships' length meters
     */
    public double getShipLength()
    {
        return shipLength;
    }

    /**
     * Gets the ships width
     * @return the ships' width meters
     */
    public double getShipWidth()
    {
        return shipWidth;
    }

    /**
     * Gets the ships draft
     * @return the ships' draft meters
     */
    public double getShipDraft()
    {
        return shipDraft;
    }

    /**
     * Initializes a new instance of the Ship class.
     * @param shipDraft the vertical distance from water line to bottom of ship meters
     * @param shipLength the length of the ship meters
     * @param shipWidth the width of the ship meters
     * @param uuid the unique identifier.
     */
    public Ship(double shipDraft, double shipLength, double shipWidth, UUID uuid, ShipType shipType)
    {
        this.shipDraft = shipDraft;
        this.shipLength = shipLength;
        this.shipWidth = shipWidth;
        this.uuid = uuid;
        this.shipType = shipType;
    }
}

