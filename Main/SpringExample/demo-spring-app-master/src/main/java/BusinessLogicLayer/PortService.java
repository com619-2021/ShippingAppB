package BusinessLogicLayer;

import BusinessLogicLayer.RestfulObjects.BookBerthDTO;
import BusinessLogicLayer.RestfulObjects.Receipt;
import BusinessLogicLayer.RestfulObjects.Ship;
import RestfulComms.IServiceCaller;
import com.google.gson.Gson;
import com.google.gson.JsonObject;

import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.concurrent.ArrayBlockingQueue;

/**
 * the class that initiates the port service requests.
 */
public class PortService implements IPortService
{
     /**
     * the object that is used for REST comms.
     */
    private IServiceCaller serviceCaller;

    /**
     * Initializes a new instance of the PortService class.
     * @param serviceCaller restful communicator.
     */
    public PortService(IServiceCaller serviceCaller)
    {
        this.serviceCaller = serviceCaller;
    }

    /**
     * Gets the availability of the port.
     * @param ship the ship to book.
     * @param dayOfBooking the day the ship is intended to dock.
     * @param url the url for the request to go to.
     * @return the string representation of the availability of the port.
     * @throws IllegalArgumentException when the params cannot be converted to strings
     * @throws IOException occurs if the connection is not
     */
    public ArrayList<String> getBerthAvailability(Ship ship, LocalDate dayOfBooking, URL url) throws IllegalArgumentException, IOException
    {
        var dto = new BookBerthDTO(dayOfBooking, ship);
        var params = JsonParser.parsePortDtoToJson(dto);

        var availability = this.serviceCaller.getRequest(url, params);
        var gson = new Gson();
        return gson.fromJson(availability, ArrayList.class);
    }

    /**
     * orders the berth
     * @param berthId the id of the berth to use
     * @return the string representation of the receipt.
     * @throws IOException id the connection doesn't work.
     */
    public Receipt orderPort(String berthId, LocalDate dayOfBooking, URL url) throws IOException
    {
        //// TODO fix the JSON object with a DTO
        JsonObject object = new JsonObject();
        object.addProperty("BerthId", berthId);
        object.addProperty("dayOfShipArrival", dayOfBooking.toString());

        var receipt = this.serviceCaller.postRequest(url, object.toString());
        return JsonParser.parseJsonToReceipt(receipt);
    }
}
