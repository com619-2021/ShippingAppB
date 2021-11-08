package ServiceRequestor;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

public class ServiceCaller implements IServiceCaller
{
    /**
     * the url to communicate to
     */
    private final URL url;

    /**
     * Initializes a new instance of the ServiceCaller class.
     * @param url the url to communicate over.
     */
    public ServiceCaller(URL url)
    {
        this.url = url;
    }
    /**
     * This sends a get request to the provided url
     * @param parameters the parameters for the rest request.
     * @return the result of the get request.
     * @throws IOException
     */
    @Override
    public String getRequest(String parameters) throws IOException
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
     * @param parameters the parameters used for the post request
     * @return the object returned by the post request
     * @throws IOException url may not be correct
     */
    @Override
    public String postRequest(String parameters) throws IOException
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
