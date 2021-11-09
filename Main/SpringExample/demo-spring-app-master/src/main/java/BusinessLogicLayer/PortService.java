package BusinessLogicLayer;

import BusinessLogicLayer.RestfulObjects.Ship;
import ServiceRequestor.ServiceCaller;
import io.swagger.v3.core.util.Json;

import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;

/**
 * the class that initiates the port service requests.
 */
public class PortService
{
    /**
     * The length of the ship
     */
    private final double shipLength;

    /**
     * The width of the ship
     */
    private final double shipWidth;

    /**
     * The day the shipment is due
     */
    private final LocalDate dayOfBooking;

    /**
     * the vertical distance between the waterline and the bottom of the hull
     */
    private final double shipDraft;

    /**
     * The URl to communicate over
     * TODO get this from a config file
     */
    private URL url;

    /**
     * Initializes a new instance of the PortService class.
     * @param shipDraft the vertical distance between the waterline and the bottom of the hull
     * @param shipLength the length of the ship
     * @param shipWidth the width of the ship
     * @param dayOfBooking the day the shipment is due
     */
    public PortService(double shipDraft, double shipLength, double shipWidth, LocalDate dayOfBooking)
    {
        this.shipDraft = shipDraft;
        this.shipLength = shipLength;
        this.shipWidth = shipWidth;
        this.dayOfBooking = dayOfBooking;
    }

    /**
     * Gets the availability of the port.
     * @return the string representation of the availability of the port.
     * @throws IllegalArgumentException when the params cannot be converted to strings
     * @throws IOException occurs if the connection is not
     */
    public String GetPortAvailability() throws IllegalArgumentException, IOException
    {
        var ship = new Ship(this.shipDraft, this.shipLength, this.shipWidth, this.dayOfBooking);
        var params = JsonParser.ParseShipToJson(ship);

        //// TODO get this from config
        this.url = new URL("test");
        var serviceCaller = new ServiceCaller(url);

        var availability = serviceCaller.getRequest(params);

        return availability;
    }
}
