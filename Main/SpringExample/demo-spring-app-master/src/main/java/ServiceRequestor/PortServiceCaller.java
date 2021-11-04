package ServiceRequestor;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class PortServiceCaller
{
    /**
     * Initializes a new instances of the PortServiceCaller class.
     * @throws MalformedURLException
     */
    public PortServiceCaller() throws MalformedURLException
    {

    }

    /**
     * This sends the get request for port availability
     * @param url the url to request.
     * @param parameters the parameters for the rest request.
     * @return availability of the ports.
     * @throws IOException
     */
    public String getPortAvailability(URL url, String parameters) throws IOException
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
     * books the port
     * @param url the url of the post request
     * @param parameters the parameters used to book the port
     * @return
     * @throws IOException
     */
    public String postPortBooking(URL url, String parameters) throws IOException
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
