package ServiceRequestor.tests;

import BusinessLogicLayer.JsonParser;
import BusinessLogicLayer.RestfulObjects.*;
import BusinessLogicLayer.UrlConfig;
import io.swagger.v3.core.util.Json;
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
        var ship = new Ship(34.5, 678.3, 67, uuid, ShipType.Cargo);
        var dto = new BookBerthDTO(date, ship);
        var actual = JsonParser.parsePortDtoToJson(dto);
        var expected = "{\"dayOfBooking\":\"2021-05-12\",\"ship\":{\"shipLength\":678.3,\"shipWidth\":67.0,\"shipDraft\":34.5,\"uuid\":\"38400000-8cf0-11bd-b23e-10b96e4ef00d\",\"shipType\":\"Cargo\"}}";

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

    @Test
    public void BookingPilotDtoParsingTest()
    {
        var date = LocalDate.parse("2021-05-12");
        var uuid = UUID.fromString("38400000-8cf0-11bd-b23e-10b96e4ef00d");
        var ship = new Ship(34.5, 678.3, 67, uuid, ShipType.Cargo);
        var berth = new Berth(1);
        var dto = new BookPilotDto(date, ship, berth);
        var json = JsonParser.parseBookPilotDtoToJson(dto);

        var expected = "{\"dayOfArrival\":\"2021-05-12\",\"ship\":{\"shipLength\":678.3,\"shipWidth\":67.0,\"shipDraft\":34.5,\"uuid\":\"38400000-8cf0-11bd-b23e-10b96e4ef00d\",\"shipType\":\"Cargo\"},\"berth\":{\"berthId\":1,\"longitude\":-1.395619,\"latitude\":50.88949}}";

        Assert.isTrue(json.equals(expected), "actual was: " + json);
    }

    @Test
    public void HarbourAvailabilityShipJsonPArsingTest()
    {
        var ship = new CheckPilotAvailableShip(354.78, ShipType.Cargo);
        var obj = new CheckPilotAvailable("2021-05-08", ship);
        var json = JsonParser.parsePilotAvailabilityDtoToJson(obj);

        var expected = "{\"arrivalDate\":\"2021-05-08\",\"ship\":{\"draft\":354.78,\"type\":\"Cargo\"}}";
        Assert.isTrue(json.equals(expected), "actual was:" + json);
    }

    @Test
    public void JsonCanParseToBool()
    {
        var json = "{\"possible\": true}";
        var result = JsonParser.parseJsonToPilotAvailability(json);

        Assert.isTrue(result.isPossible(), "actual was:" + result);
    }
}
