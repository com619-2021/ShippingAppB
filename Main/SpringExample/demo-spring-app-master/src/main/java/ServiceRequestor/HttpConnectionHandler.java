package ServiceRequestor;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;

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

    public static void writeToOutputStream(HttpURLConnection conn, String input) throws IOException
    {
        var os = conn.getOutputStream();
        os.write(input.getBytes(StandardCharsets.UTF_8));
        os.flush();
    }

    public static String readBuffer(HttpURLConnection conn) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream()));
        var output = "";
        while(br.readLine() != null)
        {
            output += br.readLine();
            //// TODO log output
            //// TODO handle the output.
        }

        return output;
    }
}
