package BusinessLogicLayer;

import com.fasterxml.jackson.annotation.JsonProperty;

public class UrlConfig
{
    /**
     * The url used to request port availability.
     */
    private String requestPortUrl;

    /**
     * gets the url to request port availability
     * @return the url to request port availability
     */
    public String getRequestPortUrl()
    {
        return this.requestPortUrl;
    }

    /**
     * sets the value of the url used when requesting port availability.
     * @param requestPortUrl the url
     */
    public void setRequestPortUrl(String requestPortUrl)
    {
        this.requestPortUrl = requestPortUrl;
    }

    /**
     * The url used to order a port.
     */
    private String orderPortUrl;

    /**
     * gets the url to order a port.
     * @return the url to order a port.
     */
    public String getOrderPortUrl()
    {
        return this.requestPortUrl;
    }

    /**
     * sets the value of the url used when ordering a port.
     * @param portAvailabilityUrl the url
     */
    public void setOrderPortUrl(String portAvailabilityUrl)
    {
        this.requestPortUrl = portAvailabilityUrl;
    }

    /**
     * The url used to order a pilot.
     */
    private String orderPilotUrl;

    /**
     * gets the url to order a pilot.
     * @return the url to order a pilot.
     */
    public String getOrderPilotUrl() { return orderPilotUrl; }

    /**
     * sets the value of the url used when ordering a pilot.
     * @param orderPilotUrl
     */
    public void setOrderPilotUrl(String orderPilotUrl) { this.orderPilotUrl = orderPilotUrl; }
}
