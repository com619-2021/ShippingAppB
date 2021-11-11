package BusinessLogicLayer;

import ServiceRequestor.ServiceCaller;

import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;

public class HarbourService
{
    /**
     * The id of the berth the ship is docking to.
     */
    private final int berthId;

    /**
     * The day the ship is expected.
     */
    private final LocalDate dayShipDue;

    /**
     * The object containing the url paths
     */
    private final UrlConfig urlConfig;

    /**
     * Initializes a new instance of the HarbourService
     * @param berthId the id of the berth the ship will dock in
     * @param dayShipDue the day the ship is due to arrive.
     */
    public HarbourService(int berthId, LocalDate dayShipDue, UrlConfig urlConfig)
    {
        this.berthId = berthId;
        this.dayShipDue = dayShipDue;
        this.urlConfig = urlConfig;
    }

    /**
     * posts an order request for a pilot
     * @return the receipt from the harbour service in string representation
     * @throws IOException thrown if connection cannot be established
     */
    public String postPilotOrder() throws IOException
    {
        var url = new URL(this.urlConfig.getOrderPilotUrl());
        var serviceCaller = new ServiceCaller(url);
        var receipt = serviceCaller.postRequest(String.valueOf(this.berthId));

        return receipt;
    }
}
