package UnitTests;

import java.io.IOException;

public interface IServiceCaller
{
    /**
     * This sends a get request to the provided url
     * @param parameters the parameters for the rest request.
     * @return the result of the get request.
     * @throws IOException
     */
    String getRequest(String parameters) throws IOException;

    /**
     * sends a post request to the provided url
     * @param url the url of the post request
     * @param parameters the parameters used for the post request
     * @return the object returned by the post request
     * @throws IOException
     */
    String postRequest(String parameters) throws IOException;
}
