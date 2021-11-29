package BusinessLogicLayer.RestfulObjects;

/**
 * A class to use to parse to json for checking whether a pilot is available.
 */
public class CheckPilotAvailable
{
    private String arrivalDate;

    private CheckPilotAvailableShip ship;

    public CheckPilotAvailable(String arrivalDate, CheckPilotAvailableShip ship)
    {
        this.arrivalDate = arrivalDate;
        this.ship = ship;
    }
}
