package BusinessLogicLayer.RestfulObjects;

/**
 * Slimmed down version of the ship DTO as harbour service needs only a few fields for checking the availability.
 */
public class CheckPilotAvailableShip
{
    private double draft;

    private ShipType type;

    public double getDraft()
    {
        return draft;
    }

    public ShipType getType()
    {
        return type;
    }

    public CheckPilotAvailableShip(double draft, ShipType type)
    {
        this.draft = draft;
        this.type = type;
    }
}
