package RestfulComms.tests;

import BusinessLogicLayer.JsonParser;
import BusinessLogicLayer.RestfulObjects.*;
import BusinessLogicLayer.UrlConfig;
import org.junit.jupiter.api.Test;
import org.springframework.util.Assert;

import java.io.IOException;
import java.time.LocalDate;
import java.util.UUID;

public class JsonParserTests
{
    @Test
    public void RestfulShipParsingTest()
    {
        var date = LocalDate.parse("2021-05-12");
        var uuid = UUID.fromString("38400000-8cf0-11bd-b23e-10b96e4ef00d");
        var ship = new Ship(34.5, 678.3, 67, uuid, ShipType.CARGO);
        var dto = new BookBerthDTO(date, ship);
        var actual = JsonParser.parsePortDtoToJson(dto);
        var expected = "{\"dayOfBooking\":\"2021-05-12\",\"ship\":{\"length\":678.3,\"width\":67.0,\"draft\":34.5,\"uuid\":\"38400000-8cf0-11bd-b23e-10b96e4ef00d\",\"type\":\"CARGO\"}}";

        Assert.isTrue(actual.equals(expected), "actual: " + actual);
    }

    @Test
    public void LoadConfigTest() throws IOException
    {
        var rootPath = System.getProperty("user.dir");
        var actual = JsonParser.loadUrlConfig(rootPath + "/config");
        var expected = new UrlConfig("test",
                "wibble",
                "floob",
                "wibblefloob",
                "floobwibble");

        Assert.isTrue(expected.getRequestPortUrl().equals(actual.getRequestPortUrl()),
                "actual: port availability url: " + actual.getRequestPortUrl());
        Assert.isTrue(expected.getOrderPortUrl().equals(actual.getOrderPortUrl()),
                "actual is:" + actual.getRequestPortUrl());
        Assert.isTrue(expected.getRequestPortUrl().equals(actual.getRequestPortUrl()),
                "actual: port availability url: " + actual.getRequestPortUrl());
        Assert.isTrue(expected.getPilotAvailabilityUrl().equals(actual.getPilotAvailabilityUrl()),
                "actual: port availability url: " + actual.getPilotAvailabilityUrl());
        Assert.isTrue(expected.getOrderStevedoreUrl().equals(actual.getOrderStevedoreUrl()),
                "actual: port availability url: " + actual.getOrderStevedoreUrl());
    }

    @Test
    public void BookingPilotDtoParsingTest()
    {
        var date = LocalDate.parse("2021-05-12");
        var uuid = UUID.fromString("38400000-8cf0-11bd-b23e-10b96e4ef00d");
        var ship = new Ship(34.5, 678.3, 67, uuid, ShipType.CARGO);
        var berth = new Berth("1");
        var dto = new BookPilotDto(date, ship, berth);
        var json = JsonParser.parseBookPilotDtoToJson(dto);

        var expected = "{\"dayOfArrival\":\"2021-05-12\",\"ship\":{\"length\":678.3,\"width\":67.0,\"draft\":34.5,\"uuid\":\"38400000-8cf0-11bd-b23e-10b96e4ef00d\",\"type\":\"CARGO\"},\"berth\":{\"berthId\":\"1\",\"longitude\":-1.395619,\"latitude\":50.88949}}";

        Assert.isTrue(json.equals(expected), "actual was: " + json);
    }

    @Test
    public void HarbourAvailabilityShipJsonPArsingTest()
    {
        var ship = new CheckPilotAvailableShip(354.78, ShipType.CARGO);
        var obj = new CheckPilotAvailable("2021-05-08", ship);
        var json = JsonParser.parsePilotAvailabilityDtoToJson(obj);

        var expected = "{\"arrivalDate\":\"2021-05-08\",\"ship\":{\"draft\":354.78,\"type\":\"CARGO\"}}";
        Assert.isTrue(json.equals(expected), "actual was:" + json);
    }

    @Test
    public void JsonCanParseToBool()
    {
        var json = "{\"possible\": true}";
        var result = JsonParser.parseJsonToPilotAvailability(json);

        Assert.isTrue(result.isPossible(), "actual was:" + result);
    }

    @Test
    public void ExpectedReceiptOutOfJson()
    {
        var json = "{\"uuid\": \"789-789-789-789\", \"totalPrice\": 780.89}";
        var expected = new Receipt("789-789-789-789", 780.89);
        var actual = JsonParser.parseJsonToReceipt(json);

        Assert.isTrue(actual.getTotalPrice() == expected.getTotalPrice(), "actual price was: "
                + actual.getTotalPrice());
        Assert.isTrue(actual.getUuid().equals(expected.getUuid()), "actual was: " + actual.getUuid());
    }

    @Test
    public void ExpectedObjectFromJsonShipmentOrder()
    {
        var json = "{ \"shipType\": \"PASSENGER\", \"usingTeuContainers\": true, \"numberOfContainers\": 50, \"numberOfPassengers\": 0, \"steveDoreServices\": {\"cargoOn\": true, \"cargoOff\": false, \"waterRequested\": true, \"wasteRemovalRequested\": true}}";
        var obj = JsonParser.GetShipmentDetails(json);

        Assert.isTrue(obj.getClass() == OrderShipmentDto.class, "The types were not the same: " + obj.getClass());
    }
}
