package BusinessLogicLayer;

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
     * The url used to order a pilot.
     */
    private String orderPilotUrl;

    /**
     * gets the url to order a pilot.
     * @return the url to order a pilot.
     */
    public String getOrderPilotUrl() { return orderPilotUrl; }

    /**
     * The url used to get the availability of the pilots.
     */
    private String pilotAvailabilityUrl;

    /**
     * Gets the url used to get the availability of the pilots.
     * @return the URL as a string
     */
    public String getPilotAvailabilityUrl()
    {
        return this.pilotAvailabilityUrl;
    }

    /**
     * The url for ordering the stevedore services.
     */
    private String orderStevedoreUrl;

    /**
     * Gets the url for ordering the stevedore services.
     * @return the url for ordering stevedore services
     */
    public String getOrderStevedoreUrl() { return this.orderStevedoreUrl; }

    /**
     * Initializes a new instance of the UrlConfig class.
     * @param requestPortUrl the URL used to request port availability.
     * @param orderPortUrl the URL used to order the Berth.
     * @param orderPilotUrl the url used to order the pilot.
     * @param pilotAvailabilityUrl the url used to get pilot availability.
     * @param orderStevedoreUrl the url used to order the stevedore services.
     */
    public UrlConfig(String requestPortUrl,
                               String orderPortUrl,
                               String orderPilotUrl,
                               String pilotAvailabilityUrl,
                               String orderStevedoreUrl)
    {
        this.requestPortUrl = requestPortUrl;
        this.orderPilotUrl = orderPilotUrl;
        this.orderPortUrl = orderPortUrl;
        this.pilotAvailabilityUrl = pilotAvailabilityUrl;
        this.orderStevedoreUrl = orderStevedoreUrl;
    }
}
