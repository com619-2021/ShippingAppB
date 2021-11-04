package BusinessLogicLayer;

import ServiceRequestor.PortServiceCallerHelper;
import org.apache.commons.lang3.NotImplementedException;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class PortService
{
    /**
     * The length of the ship
     */
    private final double shipLength;
    /**
     * The width of the ship
     */
    private final double shipWidth;
    /**
     * The day the shipment is due
     */
    private final LocalDate dayOfBooking;
    /**
     * the vertical distance between the waterline and the bottom of the hull
     */
    private double shipDraft;

    /**
     * Initializes a new instance of the PortService class.
     * @param shipDraft the vertical distance between the waterline and the bottom of the hull
     * @param shipLength the length of the ship
     * @param shipWidth the width of the ship
     * @param dayOfBooking the day the shipment is due
     */
    public PortService(double shipDraft, double shipLength, double shipWidth, LocalDate dayOfBooking)
    {
        this.shipDraft = shipDraft;
        this.shipLength = shipLength;
        this.shipWidth = shipWidth;
        this.dayOfBooking = dayOfBooking;
    }

    public String GetPortAvailability()
    {
        var shipDraftStr = String.valueOf(this.shipDraft);
        var shipLengthStr = String.valueOf(this.shipLength);
        var shipWidthStr = String.valueOf(shipWidth);
        var dateTimeFormatter = DateTimeFormatter.ofPattern("dd-mm-yyy");
        var dateStr = dateTimeFormatter.format(this.dayOfBooking);

        var params = PortServiceCallerHelper.buildPortAvailabilityParams(shipDraftStr, shipLengthStr, shipWidthStr,
                dateStr);

        throw new NotImplementedException();
    }
}
