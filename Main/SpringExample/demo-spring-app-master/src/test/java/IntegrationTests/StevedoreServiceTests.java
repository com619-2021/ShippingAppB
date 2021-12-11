package IntegrationTests;

import BusinessLogicLayer.RestfulObjects.Berth;
import BusinessLogicLayer.RestfulObjects.Receipt;
import BusinessLogicLayer.RestfulObjects.StevedoreServicesOrdered;
import BusinessLogicLayer.StevedoreService;
import RestfulComms.IServiceCaller;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.util.Assert;

import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.util.UUID;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

public class StevedoreServiceTests
{
    @Test
    public void OrderStevedoreTest() throws IOException
    {
        var dayOfArrival = LocalDate.parse("2021-08-05");
        var servicesOrdered = new StevedoreServicesOrdered(true, true, false, true);
        var uuid = UUID.randomUUID().toString();
        var berth = new Berth(uuid);
        var serviceCaller = Mockito.mock(IServiceCaller.class);
        when(serviceCaller.postRequest(any(), anyString())).thenReturn("{\"uuid\": \"1-1-1-1\", \"totalPrice\": 45.6}");
        var stevedoreService = new StevedoreService(dayOfArrival, servicesOrdered, berth, serviceCaller);
        var result = stevedoreService.orderStevedore(new URL("wibble"));

        Assert.isTrue(result.getClass() == Receipt.class, "The actual class was: " + result.getClass());
    }
}
