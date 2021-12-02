package BusinessLogicLayer;

import BusinessLogicLayer.RestfulObjects.*;
import ServiceRequestor.ServiceCaller;

import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;

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
     * The day the ship is expected to port.
     */
    private final LocalDate dayOfArrival;

    /**
     * The details of berth to port into.
     */
    private final Berth berth;

    /**
     * Initializes a new instance of the HarbourService
     * @param ship the ship that is due to arrive.
     * @param urlConfig the url config for ReSTful comms
     * @param berth the berth to port in.
     * @param dayOfShipArrival the day the ship is expected.
     */
    public HarbourService(UrlConfig urlConfig, Ship ship, Berth berth, LocalDate dayOfShipArrival)
    {
        this.urlConfig = urlConfig;
        this.ship = ship;
        this.dayOfArrival = dayOfShipArrival;
        this.berth = berth;
    }

    /**
     * Sends get request for pilot availability
     * @return
     * @throws IOException
     */
    @Override
    public boolean getPilotAvailabilities() throws IOException
    {
        var url = new URL(String.valueOf(this.urlConfig.getPilotAvailabilityUrl()));
        var serviceCaller = new ServiceCaller(url);
        var shipDto = new CheckPilotAvailableShip(this.ship.getShipDraft(), this.ship.getShipType());
        var dto = new CheckPilotAvailable(this.dayOfArrival.toString(), shipDto);
        var params = JsonParser.parsePilotAvailabilityDtoToJson(dto);
        var result = serviceCaller.getRequest(params);
        var response = JsonParser.parseJsonToPilotAvailability(result);
        return response.isPossible();
    }

    /**
     * posts an order request for a pilot
     * @return the receipt from the harbour service in string representation
     * @throws IOException thrown if connection cannot be established
     */
    @Override
    public String postPilotOrder() throws IOException
    {
        var url = new URL(this.urlConfig.getOrderPilotUrl());
        var serviceCaller = new ServiceCaller(url);
        var dto = new BookPilotDto(dayOfArrival, this.ship, this.berth);
        var params = JsonParser.parseBookPilotDtoToJson(dto);
        var receipt = serviceCaller.postRequest(params);

        return receipt;
    }
}
