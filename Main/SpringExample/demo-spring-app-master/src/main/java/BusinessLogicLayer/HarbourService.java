package BusinessLogicLayer;

import BusinessLogicLayer.RestfulObjects.*;
import ServiceRequestor.IServiceCaller;

import java.io.IOException;
import java.time.LocalDate;

public class HarbourService implements IHarbourService
{
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
     * the service caller for the REST comms
     */
    private final IServiceCaller serviceCaller;

    /**
     * Initializes a new instance of the HarbourService
     * @param ship the ship that is due to arrive.
     * @param berth the berth to port in.
     * @param dayOfShipArrival the day the ship is expected.
     * @param serviceCaller the object used to comms using ReST.
     */
    public HarbourService(Ship ship, Berth berth, LocalDate dayOfShipArrival, IServiceCaller serviceCaller)
    {
        this.ship = ship;
        this.dayOfArrival = dayOfShipArrival;
        this.berth = berth;
        this.serviceCaller = serviceCaller;
    }

    /**
     * Sends get request for pilot availability.
     * @return if there are pilots available.
     * @throws IOException If the ReST comms do not work IO Exception thrown.
     */
    @Override
    public boolean getPilotAvailabilities() throws IOException
    {
        var shipDto = new CheckPilotAvailableShip(this.ship.getDraft(), this.ship.getType());
        var dto = new CheckPilotAvailable(this.dayOfArrival.toString(), shipDto);
        var params = JsonParser.parsePilotAvailabilityDtoToJson(dto);
        var result = this.serviceCaller.getRequest(params);
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
        var dto = new BookPilotDto(dayOfArrival, this.ship, this.berth);
        var params = JsonParser.parseBookPilotDtoToJson(dto);
        var receipt = this.serviceCaller.postRequest(params);
        return receipt;
    }
}
