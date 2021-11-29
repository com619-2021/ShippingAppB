package BusinessLogicLayer;

import BusinessLogicLayer.RestfulObjects.*;
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

    /**
     * Loads the config for the URLs
     * @return object containing required URLs
     * @throws IOException if there is no config file.
     */
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

    public static String parseBookPilotDtoToJson(BookPilotDto dto)
    {
        var gson = new Gson();
        var json = gson.toJson(dto);
        return json;
    }

    public static HarbourAvailabilityResponse parseJsonToPilotAvailability(String json)
    {
        var gson = new Gson();
        return gson.fromJson(json, HarbourAvailabilityResponse.class);
    }


    public static String parsePilotAvailabilityDtoToJson(CheckPilotAvailable checkPilotAvailable)
    {
        var gson = new Gson();
        return gson.toJson(checkPilotAvailable);
    }

    public static Receipt parseJsonToReceipt(String json)
    {
        var gson = new Gson();
        return gson.fromJson(json, Receipt.class);
    }
}