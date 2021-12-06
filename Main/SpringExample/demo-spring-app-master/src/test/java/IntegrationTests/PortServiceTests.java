package IntegrationTests;

import BusinessLogicLayer.JsonParser;
import BusinessLogicLayer.PortService;
import BusinessLogicLayer.RestfulObjects.Receipt;
import BusinessLogicLayer.RestfulObjects.ShipType;
import ServiceRequestor.IServiceCaller;
import com.google.gson.Gson;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.util.Assert;

import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.UUID;

import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

public class PortServiceTests
{
    @Test
    public void GettingPortAvailabilityTest() throws IOException
    {
        var dayOfBooking = LocalDate.parse("2021-05-08");
        var uuid = UUID.randomUUID();
        var serviceCaller = Mockito.mock(IServiceCaller.class);
        var portService = new PortService(789.2, 456.2, 321, dayOfBooking, uuid, ShipType.FERRY, serviceCaller);
        when(serviceCaller.getRequest(anyString())).thenReturn("[0, 1, 2]");
        var result = portService.getBerths();

        var gson = new Gson();
        var actual = gson.fromJson(result, ArrayList.class);

        Assert.isTrue(actual.getClass() == ArrayList.class, "the result was: " + actual.getClass());
    }

    @Test
    public void OrderingAPortTest() throws IOException
    {
        var dayOfBooking = LocalDate.parse("2021-05-08");
        var uuid = UUID.randomUUID();
        var serviceCaller = Mockito.mock(IServiceCaller.class);
        when(serviceCaller.postRequest(anyString())).thenReturn("{\"uuid\": \"1-1-1-1\", \"totalPrice\": 45.6}");
        var portService = new PortService(789.2, 456.2, 321, dayOfBooking, uuid, ShipType.FERRY, serviceCaller);
        var result = portService.getPortServices(UUID.randomUUID().toString(), dayOfBooking);

        var actual = JsonParser.parseJsonToReceipt(result);
        Assert.isTrue(actual.getClass() == Receipt.class, "the actual class was: " + actual.getClass());
    }
}
