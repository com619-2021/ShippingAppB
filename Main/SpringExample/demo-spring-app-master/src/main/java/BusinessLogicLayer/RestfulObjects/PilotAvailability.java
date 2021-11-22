package BusinessLogicLayer.RestfulObjects;

import java.util.ArrayList;

public class PilotAvailability
{
    /**
     * The list containing the availability of the pilots.
     */
    private ArrayList<Integer> availablePilotId;


    /**
     * Gets the availability list for the pilot.
     * @return availability list for the pilot.
     */
    public ArrayList<Integer> getAvailablePilotId()
    {
        return availablePilotId;
    }

    /**
     * Sets the availability list for the pilot.
     * @param availablePilotId availability list for the pilot.
     */
    public void setAvailablePilotId(ArrayList<Integer> availablePilotId)
    {
        this.availablePilotId = availablePilotId;
    }

    public PilotAvailability(ArrayList<Integer> availablPilotId)
    {
        this.availablePilotId = availablPilotId;
    }
}
