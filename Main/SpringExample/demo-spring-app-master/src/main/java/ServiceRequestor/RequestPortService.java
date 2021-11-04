package ServiceRequestor;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.charset.StandardCharsets;

public class RequestPortService
{
    private URL url = new URL("http://localhost/8080/");

    public RequestPortService() throws MalformedURLException
    {

    }

    public HttpURLConnection connect() throws IOException
    {
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setDoOutput(true);
        return conn;
    }

    public String getPortAvailability(String shipSize) throws IOException
    {
        var conn = this.connect();
        conn.setRequestMethod("GET");
        conn.setRequestProperty("Content-Type", "application.json");
        var input = shipSize;

        this.writeToOutputStream(conn, input);

        if(conn.getResponseCode() != HttpURLConnection.HTTP_CREATED)
        {
            throw new RuntimeException("failed: HTTP error code: "+ conn.getResponseCode());
        }

        BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream()));

        var output = "";
        while(br.readLine() != null)
        {
            output += br.readLine();
            //// TODO log output
            //// TODO handle the output.
        }

        conn.disconnect();
        return output;
    }

    private void writeToOutputStream(HttpURLConnection conn, String input) throws IOException
    {
        var os = conn.getOutputStream();
        os.write(input.getBytes(StandardCharsets.UTF_8));
        os.flush();
    }
}
