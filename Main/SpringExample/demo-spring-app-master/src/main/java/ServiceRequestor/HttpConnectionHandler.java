package ServiceRequestor;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;

public class HttpConnectionHandler
{
    private final URL url;
    
    private HttpURLConnection connection;

    public HttpConnectionHandler(URL url)
    {
        this.url = url;
    }

    public HttpURLConnection httpConnectGet(URL url, String contentType) throws IOException
    {
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setDoOutput(true);
        conn.setRequestMethod("GET");
        conn.setRequestProperty("Content-Type", contentType);
        return conn;
    }

    public HttpURLConnection httpConnectPost(String contentType) throws IOException
    {
        this.connection = (HttpURLConnection) url.openConnection();
        this.connection.setDoOutput(true);
        this.connection.setRequestMethod("GET");
        this.connection.setRequestProperty("Content-Type", contentType);
        return this.connection;
    }

    public void disconnectHttp()
    {
        connection.disconnect();
    }

    public void writeToOutputStream(String input) throws IOException
    {
        var os = this.connection.getOutputStream();
        os.write(input.getBytes(StandardCharsets.UTF_8));
        os.flush();
    }

    public String readBuffer() throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(this.connection.getInputStream()));
        var output = "";
        while (br.readLine() != null)
        {
            output += br.readLine();
            //// TODO log output
            //// TODO handle the output.
        }

        return output;
    }
}
