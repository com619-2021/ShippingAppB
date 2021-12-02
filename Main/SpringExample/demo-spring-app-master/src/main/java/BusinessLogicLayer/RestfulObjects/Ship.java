package BusinessLogicLayer.RestfulObjects;

import java.util.UUID;

public class Ship
{

    /**
     * The length of the ship
     */
    private final double length;

    /**
     * The width of the ship
     */
    private final double width;

    /**
     * the vertical distance between the waterline and the bottom of the hull
     */
    private final double draft;

    /**
     * The unique identifier for the ship
     */
    private final UUID uuid;

    /**
     * The class of ship
     */
    private final ShipType type;

    /**
     * Gets the ships length
     * @return the ships' length meters
     */
    public double getLength()
    {
        return length;
    }

    /**
     * Gets the ships width
     * @return the ships' width meters
     */
    public double getWidth()
    {
        return width;
    }

    /**
     * Gets the ships draft
     * @return the ships' draft meters
     */
    public double getDraft()
    {
        return draft;
    }

    public ShipType getType() { return this.type; }

    /**
     * Initializes a new instance of the Ship class.
     * @param shipDraft the vertical distance from water line to bottom of ship meters
     * @param shipLength the length of the ship meters
     * @param shipWidth the width of the ship meters
     * @param uuid the unique identifier.
     */
    public Ship(double shipDraft, double shipLength, double shipWidth, UUID uuid, ShipType shipType)
    {
        this.draft = shipDraft;
        this.length = shipLength;
        this.width = shipWidth;
        this.uuid = uuid;
        this.type = shipType;
    }
}

