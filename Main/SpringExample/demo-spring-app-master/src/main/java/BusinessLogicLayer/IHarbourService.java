package BusinessLogicLayer;

import BusinessLogicLayer.RestfulObjects.Berth;
import BusinessLogicLayer.RestfulObjects.Receipt;
import BusinessLogicLayer.RestfulObjects.Ship;

import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;

public interface IHarbourService
{
    boolean getPilotAvailabilities(URL url, Ship ship, Berth berth, LocalDate dateOfArrival) throws IOException;

    Receipt postPilotOrder(URL url, Ship ship, Berth berth, LocalDate dayOfArrival) throws IOException;
}
