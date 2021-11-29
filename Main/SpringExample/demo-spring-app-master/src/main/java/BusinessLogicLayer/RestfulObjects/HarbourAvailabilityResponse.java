package BusinessLogicLayer.RestfulObjects;

public class HarbourAvailabilityResponse
{
    private boolean possible;

    public boolean isPossible()
    {
        return this.possible;
    }

    public HarbourAvailabilityResponse(boolean possible)
    {
        this.possible = possible;
    }
}
