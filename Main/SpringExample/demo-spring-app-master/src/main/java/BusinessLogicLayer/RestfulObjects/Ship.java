package BusinessLogicLayer.RestfulObjects;

import java.time.LocalDate;

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
     * The day the shipment is due
     */
    private final String dayOfBooking;

    /**
     * the vertical distance between the waterline and the bottom of the hull
     */
    private final double shipDraft;

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
     * Gets the day the ship is due
     * @return the day the ship is due
     */
    public String getDayOfBooking()
    {
        return dayOfBooking;
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
     * @param dayOfBooking the day the ship is due.
     */
    public Ship(double shipDraft, double shipLength, double shipWidth, LocalDate dayOfBooking)
    {
        this.shipDraft = shipDraft;
        this.shipLength = shipLength;
        this.shipWidth = shipWidth;
        this.dayOfBooking = dayOfBooking.toString();
    }
}
