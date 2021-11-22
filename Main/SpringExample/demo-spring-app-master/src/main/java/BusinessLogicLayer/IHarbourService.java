package BusinessLogicLayer;

import java.io.IOException;
import java.time.LocalDate;

public interface IHarbourService
{
    public boolean getPilotAvailabilities() throws IOException;

    public String postPilotOrder(int pilotId) throws IOException;
}
