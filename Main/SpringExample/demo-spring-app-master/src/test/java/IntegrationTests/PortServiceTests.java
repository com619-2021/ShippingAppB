package IntegrationTests;

import BusinessLogicLayer.JsonParser;
import BusinessLogicLayer.PortService;
import BusinessLogicLayer.RestfulObjects.Receipt;
import BusinessLogicLayer.RestfulObjects.ShipType;
import com.google.gson.Gson;
import org.junit.jupiter.api.Test;
import org.springframework.util.Assert;

import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.UUID;

public class PortServiceTests
{
    @Test
    public void GettingPortAvailabilityTest() throws IOException
    {
        var url = JsonParser.loadUrlConfig();
        var dayOfBooking = LocalDate.parse("2021-05-08");
        var uuid = UUID.randomUUID();
        var portService = new PortService(789.2, 456.2, 321, dayOfBooking, url, uuid, ShipType.FERRY);
        var result = portService.getBerths();

        var gson = new Gson();
        var actual = gson.fromJson(result, ArrayList.class);

        Assert.isTrue(actual.getClass() == ArrayList.class, "the result was: " + actual.getClass());
    }

    @Test
    public void OrderingAPortTest() throws IOException
    {
        var url = JsonParser.loadUrlConfig();
        var dayOfBooking = LocalDate.parse("2021-05-08");
        var uuid = UUID.randomUUID();
        var portService = new PortService(789.2, 456.2, 321, dayOfBooking, url, uuid, ShipType.FERRY);
        var result = portService.getPortServices(UUID.randomUUID().toString(), dayOfBooking);

        var actual = JsonParser.parseJsonToReceipt(result);
        Assert.isTrue(actual.getClass() == Receipt.class, "the actual class was: " + actual.getClass());
    }
}
