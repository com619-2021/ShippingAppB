package BusinessLogicLayer;

import java.io.IOException;
import java.time.LocalDate;

public interface IPortService
{
    /**
     * Gets the availability of the port.
     * @return the string representation of the availability of the port.
     * @throws IllegalArgumentException when the params cannot be converted to strings
     * @throws IOException occurs if the connection is not
     */
    String getBerths() throws IllegalArgumentException, IOException;

    /**
     * orders the berth
     * @param berthId the id of the berth to use
     * @param dateOfArrival the date the ship is due.
     * @return the string representation of the receipt.
     * @throws IOException id the connection doesn't work.
     */
    String getPortServices(String berthId, LocalDate dateOfArrival) throws IOException;
}
