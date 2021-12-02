package BusinessLogicLayer.RestfulObjects;

public class Receipt
{
    /**
     * The order ID
     */
    private String uuid;

    /**
     * The total price of the service
     */
    private double totalPrice;

    /**
     * gets the order id
     * @return the order id
     */
    public String getUuid()
    {
        return uuid;
    }

    /**
     * Gets the total price of the service
     * @return the total price.
     */
    public double getTotalPrice()
    {
        return totalPrice;
    }

    /**
     * Initializes a new instance of the Receipt class.
     * @param uuid the order ID
     * @param totalPrice the total price
     */
    public Receipt(String uuid, double totalPrice)
    {
        this.totalPrice = totalPrice;
        this.uuid = uuid;
    }
}
