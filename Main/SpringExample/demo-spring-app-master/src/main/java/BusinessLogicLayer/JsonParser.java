package BusinessLogicLayer;

import BusinessLogicLayer.RestfulObjects.Berth;
import BusinessLogicLayer.RestfulObjects.PilotAvailability;
import BusinessLogicLayer.RestfulObjects.Ship;
import com.google.gson.Gson;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class JsonParser
{
    /**
     * Converts restful ship object to json string.
     * @param ship The ship to convert to JSON.
     * @return The json string representation of the object
     */
    public static String parseShipToJson(Ship ship)
    {
        var gson = new Gson();
        var json = gson.toJson(ship);
        return json;
    }

    public static UrlConfig loadUrlConfig() throws IOException
    {
        var rootPath = System.getProperty("user.dir");
        File operatorFile = new File(rootPath + "/URL_config.json");
        var scanner = new Scanner(operatorFile);
        String output = "";
        while(scanner.hasNextLine())
        {
            output += scanner.nextLine();
        }
        Gson gson = new Gson();
        var config = gson.fromJson(output, UrlConfig.class);
        return config;
    }

    public static String parseBerthToJson(Berth berth)
    {
        var gson = new Gson();
        var json = gson.toJson(berth);
        return json;
    }

    public static ArrayList<Integer> parseJsonToPilotAvailability(String json)
    {
        var gson = new Gson();
        var obj = gson.fromJson(json, ArrayList.class);
        return obj;
    }
}