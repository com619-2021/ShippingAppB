package BusinessLogicLayer;

import BusinessLogicLayer.RestfulObjects.Ship;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

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
}
