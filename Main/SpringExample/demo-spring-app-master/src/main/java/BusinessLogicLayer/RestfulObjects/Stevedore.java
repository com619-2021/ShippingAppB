package BusinessLogicLayer.RestfulObjects;

public class Stevedore
{
    /**
     * whether cargo needs to be loaded
     */
    private boolean cargoOn;

    /**
     * whether cargo needs to be removed
     */
    private boolean cargoOff;

    /**
     * whether water should be loaded
     */
    private boolean waterRequested;

    /**
     * Whether waste removal is requested
     */
    private boolean wasteRemovalRequested;

    public void setCargoOn(boolean cargoOn)
    {
        this.cargoOn = cargoOn;
    }

    /**
     * Gets whether cargo needs loading to ship
     * @return whether cargo needs loading to ship
     */
    public boolean isCargoOn()
    {
        return cargoOn;
    }

    /**
     * Sets whether cargo needs loading to ship
     * @return whether cargo needs loading to ship
     */
    public void setCargoOn()
    {
        this.cargoOn = cargoOn;
    }

    /**
     * Sets if cargo needs be unloaded from ship
     * @param cargoOff if cargo needs be unloaded from ship
     */
    public void setCargoOff(boolean cargoOff)
    {
        this.cargoOff = cargoOff;
    }

    /**
     * Gets if cargo needs unloading from ship.
     * @return if cargo needs unloading from ship.
     */
    public boolean isCargoOff()
    {
        return cargoOff;
    }

    /**
     * sets if water needs loading to ship.
     * @param waterRequested if water needs to be loaded.
     */
    public void setWaterRequested(boolean waterRequested)
    {
        this.waterRequested = waterRequested;
    }

    /**
     * Gets whether water needs to be loaded.
     * @return id water needs to be loaded on ship.
     */
    public boolean isWaterRequested()
    {
        return waterRequested;
    }

    /**
     * Sets whether waste removal should be carried out on ship.
     * @param wasteRemovalRequested whether waste removal should be carried out on ship.
     */
    public void setWasteRemovalRequested(boolean wasteRemovalRequested)
    {
        this.wasteRemovalRequested = wasteRemovalRequested;
    }

    /**
     * Gets if waste removal is requested for the ship.
     * @return if waste removal is requested for the ship.
     */
    public boolean isWasteRemovalRequested()
    {
        return wasteRemovalRequested;
    }

    /**
     * Initializes a new instance of the Stevedore class.
     * @param cargoOn whether cargo needs to be loaded
     * @param cargoOff whether cargo needs to be unloaded
     * @param waterRequested whether water needs loading
     * @param wasteRemovalRequested whether waste needs removing
     */
    public Stevedore(boolean cargoOn, boolean cargoOff, boolean waterRequested, boolean wasteRemovalRequested)
    {
        this.cargoOn = cargoOn;
        this.cargoOff = cargoOff;
        this.waterRequested = waterRequested;
        this.wasteRemovalRequested = wasteRemovalRequested;
    }
}
