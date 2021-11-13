package BusinessLogicLayer;

import java.io.IOException;

public interface IPortService
{
    /**
     * Gets the availability of the port.
     * @return the string representation of the availability of the port.
     * @throws IllegalArgumentException when the params cannot be converted to strings
     * @throws IOException occurs if the connection is not
     */
    String GetPortAvailability() throws IllegalArgumentException, IOException;

    /**
     * orders the berth
     * @param berthId the id of the berth to use
     * @return the string representation of the receipt.
     * @throws IOException id the connection doesn't work.
     */
    String PostPortOrder(int berthId) throws IOException;
}
