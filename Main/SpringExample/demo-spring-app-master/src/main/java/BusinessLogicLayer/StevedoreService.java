package BusinessLogicLayer;

import BusinessLogicLayer.RestfulObjects.Berth;
import BusinessLogicLayer.RestfulObjects.Receipt;
import BusinessLogicLayer.RestfulObjects.StevedoreDto;
import BusinessLogicLayer.RestfulObjects.StevedoreServicesOrdered;
import RestfulComms.IServiceCaller;

import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;

public class StevedoreService implements IStevedoreService
{
    /**
     * The day the ship is due to arrive
     */
    private LocalDate dayOfArrival;

    /**
     * The services that have been ordered
     */
    private StevedoreServicesOrdered servicesOrdered;

    /**
     * The berth the ship is porting at.
     */
    private Berth berth;

    /**
     * object used for restful comms.
     */
    private IServiceCaller serviceCaller;

    /**
     * Initializes a new instance of the StevedoreService class.
     * @param dayOfArrival the day the ship is expected to port.
     * @param servicesOrdered the stevedore services that have been ordered.
     * @param berth the berth the ship is porting to.
     */
    public StevedoreService(
            LocalDate dayOfArrival,
            StevedoreServicesOrdered servicesOrdered,
            Berth berth,
            IServiceCaller serviceCaller)
    {
        this.dayOfArrival = dayOfArrival;
        this.servicesOrdered = servicesOrdered;
        this.berth = berth;
        this.serviceCaller = serviceCaller;
    }

    /**
     * Orders the stevedore services using a ReST POST request.
     * @return the string result from the post request.
     * @throws IOException IO exception thrown if the URL cannot find the endpoint.
     * @param url the url to call the service with.
     */
    @Override
    public Receipt orderStevedore(URL url) throws IOException
    {
        var dto = new StevedoreDto(this.dayOfArrival.toString(), this.servicesOrdered, this.berth);
        var json = JsonParser.StevedoreDtoToJson(dto);
        var response = this.serviceCaller.postRequest(url, json);
        return JsonParser.parseJsonToReceipt(response);
    }
}
