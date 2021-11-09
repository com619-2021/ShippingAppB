package BusinessLogicLayer;

import BusinessLogicLayer.RestfulObjects.Ship;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;

public class JsonParser
{
    /**
     * Converts restful ship object to json string.
     * @param ship The ship to convert to JSON.
     * @return The json string representation of the objetct
     * @throws JsonProcessingException occurs if object cannot be converted.
     */
    public static String ParseShipToJson(Ship ship) throws JsonProcessingException
    {
        ObjectMapper objectMapper = new ObjectMapper();
        var json = objectMapper.writeValueAsString(ship);
        return json;
    }

    public static UrlConfig loadConfig() throws IOException
    {
        var rootPath = System.getProperty("user.dir");
        File operatorFile = new File(rootPath + "/URL_config.json");
        UrlConfig config = new ObjectMapper().readValue(operatorFile, UrlConfig.class);
        return config;
    }
}
