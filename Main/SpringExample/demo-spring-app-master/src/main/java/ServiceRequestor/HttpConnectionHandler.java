package ServiceRequestor;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

public class HttpConnectionHandler
{
    public static HttpURLConnection httpConnectGet(URL url, String contentType) throws IOException
    {
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setDoOutput(true);
        conn.setRequestMethod("GET");
        conn.setRequestProperty("Content-Type", contentType);
        return conn;
    }

    public static HttpURLConnection httpConnectPost(URL url, String contentType) throws IOException
    {
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setDoOutput(true);
        conn.setRequestMethod("GET");
        conn.setRequestProperty("Content-Type", contentType);
        return conn;
    }

    public static void disconnectHttp(HttpURLConnection connection)
    {
        connection.disconnect();
    }
}
