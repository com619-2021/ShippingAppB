package ServiceRequestor;

import java.io.IOException;
import java.net.URL;

public interface IServiceCaller
{
    /**
     * This sends a get request to the provided url
     * @param url the url to request.
     * @param parameters the parameters for the rest request.
     * @return the result of the get request.
     * @throws IOException
     */
    public String getRequest(URL url, String parameters) throws IOException;

    /**
     * sends a post request to the provided url
     * @param url the url of the post request
     * @param parameters the parameters used for the post request
     * @return the object returned by the post request
     * @throws IOException
     */
    public String postRequest(URL url, String parameters) throws IOException;
}
