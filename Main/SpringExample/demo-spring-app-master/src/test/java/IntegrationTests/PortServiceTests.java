package IntegrationTests;

import BusinessLogicLayer.PortService;
import BusinessLogicLayer.RestfulObjects.Receipt;
import BusinessLogicLayer.RestfulObjects.Ship;
import BusinessLogicLayer.RestfulObjects.ShipType;
import BusinessLogicLayer.UrlConfig;
import RestfulComms.IServiceCaller;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.util.Assert;

import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.UUID;

import static org.mockito.ArgumentMatchers.any;
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
        var url = Mockito.mock(UrlConfig.class);
        when(url.getRequestPortUrl()).thenReturn("wibble");
        var ship = new Ship(789.2,456.2,321, uuid, ShipType.FERRY);
        var portService = new PortService(serviceCaller);
        when(serviceCaller.getRequest(any(), anyString())).thenReturn("[0, 1, 2]");
        var actual = portService.getBerthAvailability(ship, dayOfBooking, new URL(url.getRequestPortUrl()));
        Assert.isTrue(actual.getClass() == ArrayList.class, "the result was: " + actual.getClass());
    }

    @Test
    public void OrderingAPortTest() throws IOException
    {
        var serviceCaller = Mockito.mock(IServiceCaller.class);
        when(serviceCaller.postRequest(any(), anyString())).thenReturn("{\"uuid\": \"1-1-1-1\", \"totalPrice\": 45.6}");
        var url = Mockito.mock(UrlConfig.class);
        when(url.getOrderPortUrl()).thenReturn("wibble");
        var portService = new PortService(serviceCaller);
        var actual = portService.orderPort(UUID.randomUUID().toString(), LocalDate.parse("2021-05-09"), new URL(url.getOrderPortUrl()));
        Assert.isTrue(actual.getClass() == Receipt.class, "the actual class was: "+actual.getClass());
    }
}
