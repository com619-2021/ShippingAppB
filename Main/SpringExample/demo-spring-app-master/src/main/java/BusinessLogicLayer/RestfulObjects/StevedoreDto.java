package BusinessLogicLayer.RestfulObjects;

import BusinessLogicLayer.StevedoreService;

public class StevedoreDto
{
    private String dayOfArrival;

    private StevedoreServicesOrdered servicesOrdered;

    private Berth berth;

    public String getDayOfArrival()
    {
        return dayOfArrival;
    }

    public StevedoreServicesOrdered getServicesOrdered()
    {
        return servicesOrdered;
    }

    public Berth getBerth()
    {
        return berth;
    }

    public StevedoreDto(String dayOfArrival, StevedoreServicesOrdered servicesOrdered, Berth berth)
    {
        this.dayOfArrival = dayOfArrival;
        this.servicesOrdered = servicesOrdered;
        this.berth = berth;
    }
}
