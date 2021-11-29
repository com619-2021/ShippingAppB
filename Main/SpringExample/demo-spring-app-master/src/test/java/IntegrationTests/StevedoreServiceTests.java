package IntegrationTests;

import BusinessLogicLayer.JsonParser;
import BusinessLogicLayer.RestfulObjects.Berth;
import BusinessLogicLayer.RestfulObjects.Receipt;
import BusinessLogicLayer.RestfulObjects.StevedoreServicesOrdered;
import BusinessLogicLayer.StevedoreService;
import org.junit.jupiter.api.Test;
import org.springframework.util.Assert;

import java.io.IOException;
import java.time.LocalDate;
import java.util.UUID;

public class StevedoreServiceTests
{
    @Test
    public void OrderStevedoreTest() throws IOException
    {
        var dayOfArrival = LocalDate.parse("2021-08-05");
        var servicesOrdered = new StevedoreServicesOrdered(true, true, false, true);
        var uuid = UUID.randomUUID().toString();
        var berth = new Berth(uuid);
        var url = JsonParser.loadUrlConfig();
        var stevedoreService = new StevedoreService(dayOfArrival, servicesOrdered, berth, url);
        var result = stevedoreService.orderStevedore();

        Assert.isTrue(result.getClass() == Receipt.class, "The actual class was: " + result.getClass());
    }
}
