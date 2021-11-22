package BusinessLogicLayer;

import BusinessLogicLayer.RestfulObjects.Ship;
import ServiceRequestor.ServiceCaller;
import io.swagger.v3.core.util.Json;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;

public class HarbourService implements IHarbourService
{
    /**
     * The object containing the url paths
     */
    private final UrlConfig urlConfig;

    /**
     * The ship the pilot needs to pilot.
     */
    private final Ship ship;

    /**
     * Initializes a new instance of the HarbourService
     * @param ship the ship that is due to arrive.
     */
    public HarbourService(UrlConfig urlConfig, Ship ship)
    {
        this.urlConfig = urlConfig;
        this.ship = ship;
    }

    /**
     *
     * @return
     * @throws IOException
     */
    @Override
    public boolean getPilotAvailabilities() throws IOException
    {
//        var url = new URL(String.valueOf(this.urlConfig.getPilotAvailabilityUrl()));
//        var serviceCaller = new ServiceCaller(url);
//        var params = JsonParser.parseShipToJson(ship);
//        var result = serviceCaller.getRequest(params);
//        return JsonParser.parseJsonToPilotAvailability(result);
        return true;
    }

    /**
     * posts an order request for a pilot
     * @return the receipt from the harbour service in string representation
     * @throws IOException thrown if connection cannot be established
     * @param pilotId the id of the pilot to book.
     */
    @Override
    public String postPilotOrder(int pilotId) throws IOException
    {
        var url = new URL(this.urlConfig.getOrderPilotUrl());
        var serviceCaller = new ServiceCaller(url);
        var receipt = serviceCaller.postRequest(String.valueOf(pilotId));

        return receipt;
    }
}
