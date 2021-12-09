package BusinessLogicLayer;

import BusinessLogicLayer.RestfulObjects.BookBerthDTO;
import BusinessLogicLayer.RestfulObjects.Receipt;
import BusinessLogicLayer.RestfulObjects.Ship;
import BusinessLogicLayer.RestfulObjects.ShipType;
import UnitTests.IServiceCaller;
import com.google.gson.Gson;
import com.google.gson.JsonObject;

import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.UUID;

/**
 * the class that initiates the port service requests.
 */
public class PortService implements IPortService
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
     * The unique identifier for the ship
     */
    private final UUID uuid;

    /**
     * The class of ship.
     */
    private final ShipType shipType;

    /**
     * the object that is used for REST comms.
     */
    private IServiceCaller serviceCaller;

    /**
     * Initializes a new instance of the PortService class.
     * @param shipDraft the vertical distance between the waterline and the bottom of the hull
     * @param shipLength the length of the ship
     * @param shipWidth the width of the ship
     * @param dayOfBooking the day the shipment is due
     */
    public PortService(double shipDraft,
                       double shipLength,
                       double shipWidth,
                       LocalDate dayOfBooking,
                       UUID uuid,
                       ShipType shipType,
                       IServiceCaller serviceCaller)
    {
        this.shipDraft = shipDraft;
        this.shipLength = shipLength;
        this.shipWidth = shipWidth;
        this.dayOfBooking = dayOfBooking;
        this.uuid = uuid;
        this.shipType = shipType;
        this.serviceCaller = serviceCaller;
    }

    /**
     * Gets the availability of the port.
     * @return the string representation of the availability of the port.
     * @throws IllegalArgumentException when the params cannot be converted to strings
     * @throws IOException occurs if the connection is not
     */
    public ArrayList<String> getBerthAvailability() throws IllegalArgumentException, IOException
    {
        var ship = new Ship(this.shipDraft, this.shipLength, this.shipWidth, this.uuid, this.shipType);
        var dto = new BookBerthDTO(this.dayOfBooking, ship);
        var params = JsonParser.parsePortDtoToJson(dto);

        var availability = this.serviceCaller.getRequest(params);
        var gson = new Gson();
        return gson.fromJson(availability, ArrayList.class);
    }

    /**
     * orders the berth
     * @param berthId the id of the berth to use
     * @return the string representation of the receipt.
     * @throws IOException id the connection doesn't work.
     */
    public Receipt orderPort(String berthId) throws IOException
    {
        //// TODO fix the JSON object with a DTO
        JsonObject object = new JsonObject();
        object.addProperty("BerthId", berthId);
        object.addProperty("dayOfShipArrival", this.dayOfBooking.toString());

        var receipt = this.serviceCaller.postRequest(object.toString());
        return JsonParser.parseJsonToReceipt(receipt);
    }
}
