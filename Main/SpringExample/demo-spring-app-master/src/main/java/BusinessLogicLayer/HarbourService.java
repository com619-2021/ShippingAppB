package BusinessLogicLayer;

import BusinessLogicLayer.RestfulObjects.*;
import RestfulComms.IServiceCaller;

import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;

public class HarbourService implements IHarbourService
{
    /**
     * The ship the pilot needs to pilot.
     */
    private Ship ship;

    /**
     * The day the ship is expected to port.
     */
    private LocalDate dayOfArrival;

    /**
     * The details of berth to port into.
     */
    private Berth berth;

    /**
     * the service caller for the REST comms
     */
    private final IServiceCaller serviceCaller;

    /**
     * Initializes a new instance of the HarbourService
     * @param serviceCaller the object used to comms using ReST.
     */
    public HarbourService(IServiceCaller serviceCaller)
    {
        this.serviceCaller = serviceCaller;
    }

    /**
     * Sends get request for pilot availability.
     * @return if there are pilots available.
     * @throws IOException If the ReST comms do not work IO Exception thrown.
     * @param url the url to call the service with.
     * @param ship the ship that is due to arrive.
     * @param berth the berth to port in.
     * @param dateOfArrival the day the ship is expected.
     */
    @Override
    public boolean getPilotAvailabilities(URL url, Ship ship, Berth berth, LocalDate dateOfArrival) throws IOException
    {
        this.ship = ship;
        this.berth = berth;
        this.dayOfArrival = dateOfArrival;
        var shipDto = new CheckPilotAvailableShip(this.ship.getDraft(), this.ship.getType());
        var dto = new CheckPilotAvailable(this.dayOfArrival.toString(), shipDto);
        var params = JsonParser.parsePilotAvailabilityDtoToJson(dto);
        var result = this.serviceCaller.getRequest(url, params);
        var response = JsonParser.parseJsonToPilotAvailability(result);
        return response.isPossible();
    }

    /**
     * posts an order request for a pilot
     * @return the receipt from the harbour service in string representation
     * @throws IOException thrown if connection cannot be established
     * @param url the url to call the service with.
     */
    @Override
    public Receipt postPilotOrder(URL url) throws IOException
    {
        var dto = new BookPilotDto(dayOfArrival, this.ship, this.berth);
        var params = JsonParser.parseBookPilotDtoToJson(dto);
        var receipt = this.serviceCaller.postRequest(url, params);
        return JsonParser.parseJsonToReceipt(receipt);
    }
}
