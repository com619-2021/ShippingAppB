package BusinessLogicLayer;

import BusinessLogicLayer.RestfulObjects.Berth;
import BusinessLogicLayer.RestfulObjects.BookBerthDTO;
import BusinessLogicLayer.RestfulObjects.BookPilotDto;
import BusinessLogicLayer.RestfulObjects.Ship;
import com.google.gson.Gson;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class JsonParser
{
    /**
     * Converts restful ship object to json string.
     * @param berthDTO The berth dto to convert to JSON.
     * @return The json string representation of the object
     */
    public static String parsePortDtoToJson(BookBerthDTO berthDTO)
    {
        var gson = new Gson();
        var json = gson.toJson(berthDTO);
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

    public static String parsePilotOrderToJson(BookPilotDto dto)
    {
        var gson = new Gson();
        var json = gson.toJson(dto);
        return json;
    }

    public static boolean parseJsonToPilotAvailability(String json)
    {
        var gson = new Gson();
        return gson.fromJson(json, boolean.class);
    }
}