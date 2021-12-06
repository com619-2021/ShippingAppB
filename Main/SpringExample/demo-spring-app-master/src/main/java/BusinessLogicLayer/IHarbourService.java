package BusinessLogicLayer;

import java.io.IOException;

public interface IHarbourService
{
    boolean getPilotAvailabilities() throws IOException;

    String postPilotOrder() throws IOException;
}
