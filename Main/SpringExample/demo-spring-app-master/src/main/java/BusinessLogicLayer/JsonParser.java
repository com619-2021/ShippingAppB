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

    /**
     * Parses a BookPilotDto into a json string
     * @param dto the object to parse
     * @return the json string representing the object.
     */
    public static String parseBookPilotDtoToJson(BookPilotDto dto)
    {
        var gson = new Gson();
        var json = gson.toJson(dto);
        return json;
    }

    /**
     * Converts the response from the harbour service to an object
     * @param json the json to parse
     * @return the object representing the response.
     */
    public static HarbourAvailabilityResponse parseJsonToPilotAvailability(String json)
    {
        var gson = new Gson();
        return gson.fromJson(json, HarbourAvailabilityResponse.class);
    }


    /**
     * Converts a PilotAvailabilityDto to a json string.
     * @param checkPilotAvailable the object to parse.
     * @return the json string representing the object.
     */
    public static String parsePilotAvailabilityDtoToJson(CheckPilotAvailable checkPilotAvailable)
    {
        var gson = new Gson();
        return gson.toJson(checkPilotAvailable);
    }

    /**
     * Parses a json string to the Receipt class.
     * @param json the json to parse.
     * @return the object representation of the json string.
     */
    public static Receipt parseJsonToReceipt(String json)
    {
        var gson = new Gson();
        return gson.fromJson(json, Receipt.class);
    }

    /**
     * Converts a StevedoreDto to a json string
     * @param dto the object to parse
     * @return the string representation of the object.
     */
    public static String StevedoreDtoToJson(StevedoreDto dto)
    {
        var gson = new Gson();
        return gson.toJson(dto);
    }
}