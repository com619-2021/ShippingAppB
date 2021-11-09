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
    private final LocalDate dayOfBooking;

    /**
     * the vertical distance between the waterline and the bottom of the hull
     */
    private final double shipDraft;

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
        this.dayOfBooking = dayOfBooking;
    }
}
