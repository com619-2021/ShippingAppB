package ServiceRequestor;

import com.sun.istack.logging.Logger;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

public class ServiceCaller implements IServiceCaller
{
    /**
     * the logger
     */
    private Logger logger = Logger.getLogger(ServiceCaller.class);

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
     * @throws IOException throws if connection cannot be created.
     */
    @Override
    public String getRequest(String parameters) throws IOException
    {
        var httpConnectionHandler = new HttpConnectionHandler(url);
        var contentType = "application.json";
        var connection = httpConnectionHandler.httpConnectGet(url, contentType);

        httpConnectionHandler.writeToOutputStream(parameters);
        this.checkResponseCode(connection);
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
        var connection = httpConnectionHandler.httpConnectPost(contentType);

        httpConnectionHandler.writeToOutputStream(parameters);
        this.checkResponseCode(connection);
        var output = httpConnectionHandler.readBuffer();

        httpConnectionHandler.disconnectHttp();
        return output;
    }

    /**
     * checks the response code.
     * @param connection the connection to the other services
     * @throws  IOException gets thrown if URL connection cannot be connected.
     */
    private void checkResponseCode(HttpURLConnection connection) throws IOException
    {
        if(connection.getResponseCode() != HttpURLConnection.HTTP_CREATED)
        {
            var error = new RuntimeException("failed: HTTP error code: "+ connection.getResponseCode());
            logger.logSevereException(error);
            throw error;
        }
    }
}
