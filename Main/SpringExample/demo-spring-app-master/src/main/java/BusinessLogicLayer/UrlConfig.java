package BusinessLogicLayer;

public class UrlConfig
{
    private String portAvailabilityUrl;

    public String getPortAvailabilityUrl()
    {
        return this.portAvailabilityUrl;
    }

    public void setPortAvailabilityUrl(String portAvailabilityUrl)
    {
        this.portAvailabilityUrl = portAvailabilityUrl;
    }

    public UrlConfig()
    {

    }

    public UrlConfig(String portAvailabilityUrl)
    {
        this.portAvailabilityUrl = portAvailabilityUrl;
    }
}
