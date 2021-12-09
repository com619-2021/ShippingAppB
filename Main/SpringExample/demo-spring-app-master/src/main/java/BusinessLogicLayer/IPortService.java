package BusinessLogicLayer;

import BusinessLogicLayer.RestfulObjects.Receipt;

import java.io.IOException;
import java.util.ArrayList;

public interface IPortService
{
    /**
     * Gets the availability of the port.
     * @return the string representation of the availability of the port.
     * @throws IllegalArgumentException when the params cannot be converted to strings
     * @throws IOException occurs if the connection is not
     */
    ArrayList<String> getBerthAvailability() throws IllegalArgumentException, IOException;

    /**
     * orders the berth
     * @param berthId the id of the berth to use
     * @return the string representation of the receipt.
     * @throws IOException id the connection doesn't work.
     */
    Receipt orderPort(String berthId) throws IOException;
}
