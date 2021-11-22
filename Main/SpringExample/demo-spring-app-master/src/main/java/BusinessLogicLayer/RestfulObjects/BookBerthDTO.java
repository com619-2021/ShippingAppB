package BusinessLogicLayer.RestfulObjects;

import java.time.LocalDate;

public class BookBerthDTO
{
    /**
     * The day the shipment is due
     */
    private String dayOfBooking;

    /**
     * The details of the ship to book
     */
    private Ship ship;

    /**
     * Gets the day of the booking
     * @return the day of the booking
     */
    public String getDayOfBooking()
    {
        return dayOfBooking;
    }

    /**
     * Sets the day of booking
     * @param dayOfBooking the day of booking yyyy-MM-dd
     */
    public void setDayOfBooking(LocalDate dayOfBooking)
    {
        this.dayOfBooking = dayOfBooking.toString();
    }

    /**
     * Sets the ship
     * @param ship the ship
     */
    public void setShip(Ship ship)
    {
        this.ship = ship;
    }

    /**
     * Gets the ship
     * @return the ship
     */
    public Ship getShip()
    {
        return ship;
    }

    /**
     * Initializes a new instance of the BookBerthDTO
     * @param dayOfBooking the day of the booking.
     * @param ship the ship to book
     */
    public BookBerthDTO(LocalDate dayOfBooking, Ship ship)
    {
        this.dayOfBooking = dayOfBooking.toString();
        this.ship = ship;
    }
}
