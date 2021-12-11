package BusinessLogicLayer;

import BusinessLogicLayer.RestfulObjects.Berth;
import BusinessLogicLayer.RestfulObjects.Receipt;
import BusinessLogicLayer.RestfulObjects.StevedoreServicesOrdered;

import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;

public interface IStevedoreService
{
    Receipt orderStevedore(URL url, LocalDate dayOfArrival, StevedoreServicesOrdered servicesOrdered, Berth berth) throws IOException;
}
