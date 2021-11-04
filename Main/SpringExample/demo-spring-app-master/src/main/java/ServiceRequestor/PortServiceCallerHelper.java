package ServiceRequestor;

public class PortServiceCallerHelper
{
    /**
     * builds the parameters for requesting port availability.
     * @param shipDraft vertical distance between water level and hull
     * @param shipLength how long the ship is
     * @param shipWidth how wide the ship is
     * @param bookingDate the booking Date the port needs to be booked for.
     * @return
     */
    public static String buildPortAvailabilityParams(String shipDraft, String shipLength, String shipWidth, String bookingDate)
    {
        var stringBuilder = new StringBuilder();
        stringBuilder.append(shipDraft);
        stringBuilder.append(":");
        stringBuilder.append(shipLength);
        stringBuilder.append(":");
        stringBuilder.append(shipWidth);
        stringBuilder.append(":");
        stringBuilder.append(bookingDate);

        return stringBuilder.toString();
    }
}
