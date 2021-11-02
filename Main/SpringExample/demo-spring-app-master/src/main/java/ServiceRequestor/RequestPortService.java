package ServiceRequestor;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class RequestPortService
{
    private URL portUrl = new URL("the url");

    private HttpURLConnection httpURLConnection;

    public void Connect() throws IOException
    {
        this.httpURLConnection = (HttpURLConnection)portUrl.openConnection();
    }

    public String RequestPortService() throws MalformedURLException
    {

    }
}
