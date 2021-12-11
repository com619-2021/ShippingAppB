package BusinessLogicLayer;

import BusinessLogicLayer.RestfulObjects.Receipt;

import java.io.IOException;
import java.net.URL;

public interface IHarbourService
{
    boolean getPilotAvailabilities(URL url) throws IOException;

    Receipt postPilotOrder(URL url) throws IOException;
}
