package IntegrationTests;

import BusinessLogicLayer.HarbourService;
import BusinessLogicLayer.JsonParser;
import BusinessLogicLayer.RestfulObjects.*;
import ServiceRequestor.IServiceCaller;
import ServiceRequestor.ServiceCaller;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.util.Assert;

import java.io.IOException;
import java.time.LocalDate;
import java.util.UUID;

import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

public class HarbourServiceTests
{
    /**
     * Integration test for getting the availability of the pilots
     * @throws IOException throws if the ReST connection doesn't connect. Or the JSON config is not found
     */
    @Test
    public void GetAvailabilityTest() throws IOException
    {
        var dayOfArrival = LocalDate.parse("2021-08-05");
        var ship = new Ship(756.26, 78945.2, 484563.36, UUID.randomUUID(), ShipType.CARGO);
        var uuid = UUID.randomUUID().toString();
        var berth = new Berth(uuid);

        var serviceCaller = Mockito.mock(IServiceCaller.class);
        when(serviceCaller.getRequest(anyString())).thenReturn("{\"possible\": true }");
        var harbourService = new HarbourService(ship, berth, dayOfArrival, serviceCaller);

        var result = harbourService.getPilotAvailabilities();

        Assert.isTrue(result, "the result was: " + result);
    }

    @Test
    public void OrderPilotTest() throws IOException
    {
        var dayOfArrival = LocalDate.parse("2021-08-05");
        var ship = new Ship(756.26, 78945.2, 484563.36, UUID.randomUUID(), ShipType.CARGO);
        var uuid = UUID.randomUUID().toString();
        var berth = new Berth(uuid);

        var serviceCaller = Mockito.mock(IServiceCaller.class);
        when(serviceCaller.postRequest(anyString())).thenReturn("{\"uuid\": \"1-1-1-1\", \"totalPrice\": 45.6}");
        var harbourService = new HarbourService(ship, berth, dayOfArrival, serviceCaller);

        var result = harbourService.postPilotOrder();

        var actual = JsonParser.parseJsonToReceipt(result);
        Assert.isTrue(actual.getClass() == Receipt.class, "the result had type of: " + Receipt.class);
    }
}
