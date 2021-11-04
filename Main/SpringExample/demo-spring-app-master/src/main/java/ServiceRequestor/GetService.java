package ServiceRequestor;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.charset.StandardCharsets;

public class GetService
{
    private URL url;

    public GetService(URL url) throws MalformedURLException
    {
        this.url = url;
    }

    public String getPortAvailability(String shipSize, String shipDraft, String shipLength, String shipWidth, String date)
            throws IOException
    {
        var conn = HttpConnectionHandler.httpConnectGet(url, "application.json");
        var input = shipSize;

        this.writeToOutputStream(conn, input);

        if(conn.getResponseCode() != HttpURLConnection.HTTP_CREATED)
        {
            //// TODO log the error
            throw new RuntimeException("failed: HTTP error code: "+ conn.getResponseCode());
        }

        var output = this.readBuffer(conn);

        HttpConnectionHandler.disconnectHttp(conn);
        return output;
    }

    private void writeToOutputStream(HttpURLConnection conn, String input) throws IOException
    {
        var os = conn.getOutputStream();
        os.write(input.getBytes(StandardCharsets.UTF_8));
        os.flush();
    }

    private String readBuffer(HttpURLConnection conn) throws IOException
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
