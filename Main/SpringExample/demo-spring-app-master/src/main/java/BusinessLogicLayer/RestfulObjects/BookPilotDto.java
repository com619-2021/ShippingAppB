package BusinessLogicLayer.RestfulObjects;

import java.time.LocalDate;

public class BookPilotDto
{
    private String dayOfArrival;

    private Ship ship;

    private Berth berth;

    public String getDayOfArrival()
    {
        return dayOfArrival;
    }

    public Ship getShip()
    {
        return ship;
    }

    public Berth getBerth()
    {
        return berth;
    }

    public void setDayOfArrival(String dayOfArrival)
    {
        this.dayOfArrival = dayOfArrival;
    }

    public void setShip(Ship ship)
    {
        this.ship = ship;
    }

    public void setBerth(Berth berth)
    {
        this.berth = berth;
    }

    public BookPilotDto(LocalDate dayOfArrival, Ship ship, Berth berth)
    {
        this.dayOfArrival = dayOfArrival.toString();
        this.berth = berth;
        this.ship = ship;
    }
}
