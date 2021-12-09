package BusinessLogicLayer;

import BusinessLogicLayer.RestfulObjects.Receipt;

import java.io.IOException;

public interface IHarbourService
{
    boolean getPilotAvailabilities() throws IOException;

    Receipt postPilotOrder() throws IOException;
}
