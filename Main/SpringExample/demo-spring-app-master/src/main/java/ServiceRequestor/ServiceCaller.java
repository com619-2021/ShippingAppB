package ServiceRequestor;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class ServiceCaller
{
    /**
     * Initializes a new instances of the PortServiceCaller class.
     * @throws MalformedURLException
     */
    public ServiceCaller() throws MalformedURLException
    {

    }

    /**
     * This sends a get request to the provided url
     * @param url the url to request.
     * @param parameters the parameters for the rest request.
     * @return the result of the get request.
     * @throws IOException
     */
    public String get(URL url, String parameters) throws IOException
    {
        var httpConnectionHandler = new HttpConnectionHandler(url);
        var contentType = "application.json";
        var conn = httpConnectionHandler.httpConnectGet(url, contentType);
        var input = parameters;

        httpConnectionHandler.writeToOutputStream(input);

        if(conn.getResponseCode() != HttpURLConnection.HTTP_CREATED)
        {
            //// TODO log the error
            throw new RuntimeException("failed: HTTP error code: "+ conn.getResponseCode());
        }

        var output = httpConnectionHandler.readBuffer();

        httpConnectionHandler.disconnectHttp();
        return output;
    }

    /**
     * sends a post request to the provided url
     * @param url the url of the post request
     * @param parameters the parameters used for the post request
     * @return the object returned by the post request
     * @throws IOException
     */
    public String post(URL url, String parameters) throws IOException
    {
        var httpConnectionHandler = new HttpConnectionHandler(url);
        var contentType = "application.json";
        var conn = httpConnectionHandler.httpConnectPost(contentType);

        httpConnectionHandler.writeToOutputStream(parameters);
        if(conn.getResponseCode() != HttpURLConnection.HTTP_CREATED)
        {
            //// TODO log the error
            throw new RuntimeException("failed: HTTP error code: "+ conn.getResponseCode());
        }

        var output = httpConnectionHandler.readBuffer();

        httpConnectionHandler.disconnectHttp();
        return output;
    }
}
