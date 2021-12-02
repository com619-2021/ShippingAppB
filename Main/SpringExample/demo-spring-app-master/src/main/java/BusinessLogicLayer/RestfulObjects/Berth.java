package BusinessLogicLayer.RestfulObjects;

public class Berth
{
    private String berthId;

    public String getBerthId()
    {
        return berthId;
    }

    public void setBerthId(String bethId){ this.berthId = berthId;}

    private double longitude = -1.395619;

    private double latitude = 50.889490;

    /**
     * Initializes a new instance of the Berth class.
     * @param berthId the id of the berth
     */
    public Berth(String berthId)
    {
        this.berthId = berthId;
    }
}
