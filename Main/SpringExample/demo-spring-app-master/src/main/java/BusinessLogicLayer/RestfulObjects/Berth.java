package BusinessLogicLayer.RestfulObjects;

public class Berth
{
    private final int berthId;

    /**
     * The day the shipment is due
     */
    private final String dayOfBooking;

    public int getBerthId()
    {
        return berthId;
    }

    public Berth(int berthId, String dayOfBooking)
    {
        this.berthId = berthId;
        this.dayOfBooking = dayOfBooking;
    }
}
