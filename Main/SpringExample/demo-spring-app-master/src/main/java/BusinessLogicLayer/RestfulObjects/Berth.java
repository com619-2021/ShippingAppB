package BusinessLogicLayer.RestfulObjects;

public class Berth
{
    private int berthId;

    public int getBerthId()
    {
        return berthId;
    }

    public void setBerthId(int bethId){ this.berthId = berthId;}

    private double longitude = -1.395619;

    private double latitude = 50.889490;

    public Berth(int berthId)
    {
        this.berthId = berthId;
    }
}
