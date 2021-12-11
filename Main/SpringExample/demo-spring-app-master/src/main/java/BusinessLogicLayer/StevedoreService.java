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
     * object used for restful comms.
     */
    private IServiceCaller serviceCaller;

    /**
     * Initializes a new instance of the StevedoreService class.

     */
    public StevedoreService(IServiceCaller serviceCaller)
    {
        this.serviceCaller = serviceCaller;
    }

    /**
     * Orders the stevedore services using a ReST POST request.
     * @return the string result from the post request.
     * @throws IOException IO exception thrown if the URL cannot find the endpoint.
     * @param url the url to call the service with.
     * @param dayOfArrival the day the ship is expected to port.
     * @param servicesOrdered the stevedore services that have been ordered.
     * @param berth the berth the ship is porting to.
     */
    @Override
    public Receipt orderStevedore(URL url, LocalDate dayOfArrival, StevedoreServicesOrdered servicesOrdered, Berth berth) throws IOException
    {
        var dto = new StevedoreDto(dayOfArrival.toString(), servicesOrdered, berth);
        var json = JsonParser.StevedoreDtoToJson(dto);
        var response = this.serviceCaller.postRequest(url, json);
        return JsonParser.parseJsonToReceipt(response);
    }
}
