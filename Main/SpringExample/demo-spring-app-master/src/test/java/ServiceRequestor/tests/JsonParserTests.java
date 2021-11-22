package ServiceRequestor.tests;

import BusinessLogicLayer.JsonParser;
import BusinessLogicLayer.RestfulObjects.Ship;
import BusinessLogicLayer.UrlConfig;
import org.junit.jupiter.api.Test;
import org.springframework.util.Assert;

import java.io.IOException;
import java.time.LocalDate;

public class JsonParserTests
{
    @Test
    public void RestfulShipParsing()
    {
        var date = LocalDate.parse("2021-05-12");
        var ship = new Ship(34.5, 678.3, 67, date);
        var actual = JsonParser.parseShipToJson(ship);
        var expected = "{\"shipLength\":678.3,\"shipWidth\":67.0,\"dayOfBooking\":\"2021-05-12\",\"shipDraft\":34.5}";

        Assert.isTrue(actual.equals(expected), "actual: " + actual);
    }

    @Test
    public void LoadConfigTest() throws IOException
    {
        //// TODO test this works on unix
        var actual = JsonParser.loadUrlConfig();
        var expected = new UrlConfig();
        expected.setRequestPortUrl("test");

        Assert.isTrue(expected.getRequestPortUrl().equals(actual.getRequestPortUrl()), "actual: port availability url: " + actual.getRequestPortUrl());
    }
}
