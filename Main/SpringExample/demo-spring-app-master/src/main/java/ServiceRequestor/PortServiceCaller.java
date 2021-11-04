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
        var conn = HttpConnectionHandler.httpConnectGet(url, "application.json");
        var input = parameters;

        HttpConnectionHandler.writeToOutputStream(conn, input);

        if(conn.getResponseCode() != HttpURLConnection.HTTP_CREATED)
        {
            //// TODO log the error
            throw new RuntimeException("failed: HTTP error code: "+ conn.getResponseCode());
        }

        var output = HttpConnectionHandler.readBuffer(conn);

        HttpConnectionHandler.disconnectHttp(conn);
        return output;
    }


}
