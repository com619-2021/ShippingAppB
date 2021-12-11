package IntegrationTests;

import BusinessLogicLayer.*;
import BusinessLogicLayer.RestfulObjects.OrderShipmentDto;
import BusinessLogicLayer.RestfulObjects.Receipt;
import BusinessLogicLayer.RestfulObjects.ShipType;
import BusinessLogicLayer.RestfulObjects.StevedoreServicesOrdered;
import com.example.demo.controller.OrderShipment;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.util.Assert;

import java.io.IOException;
import java.util.ArrayList;
import java.util.UUID;

import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.when;

public class OrderShipmentTests
{
    private final IPortService portService = Mockito.mock(IPortService.class);

    private final IHarbourService harbourService = Mockito.mock(IHarbourService.class);

    private final IStevedoreService stevedoreService = Mockito.mock(IStevedoreService.class);

    private final UrlConfig urlConfig = Mockito.mock(UrlConfig.class);

    @Test
    public void throwsExceptionWhenNoPortsAvailable() throws Exception
    {
        var stevedoreServiceOrdered = new StevedoreServicesOrdered(true,false,false, false );
        var orderDetails = new OrderShipmentDto(ShipType.CARGO, stevedoreServiceOrdered, true,4556, 0, "2021-05-09");
        this.configureUrls();
        when(portService.getBerthAvailability(any(), any(), any())).thenReturn(new ArrayList<String>());
        var orderShipment = new OrderShipment(orderDetails, portService, harbourService, stevedoreService, urlConfig);

        String actual;

        try
        {
            actual = orderShipment.placeOrder();
        }
        catch(Exception e)
        {
            actual = e.getMessage();
        }
        var expected = "There are no available berths";

        Assert.isTrue(actual.equalsIgnoreCase(expected), "actual was: " + actual);
    }

    @Test
    public void throwsExceptionWhenNoPilotAvailable() throws IOException
    {
        var stevedoreServiceOrdered = new StevedoreServicesOrdered(true,false,false, false );
        var orderDetails = new OrderShipmentDto(ShipType.CARGO, stevedoreServiceOrdered, true,4556, 0, "2021-05-09");
        this.configureUrls();
        this.configureServicesNoPilots();
        var orderShipment = new OrderShipment(orderDetails, portService, harbourService, stevedoreService, urlConfig);
        String actual;
        try
        {
            actual = orderShipment.placeOrder();
        }
        catch(Exception e)
        {
            actual = e.getMessage();
        }
        var expected = "There are no available pilots";

        Assert.isTrue(actual.equalsIgnoreCase(expected), "actual was: " + actual);
    }

    @Test
    public void returnsSuccessfulReceipt() throws Exception
    {
        var stevedoreServiceOrdered = new StevedoreServicesOrdered(true,false,false, false );
        var orderDetails = new OrderShipmentDto(ShipType.CARGO, stevedoreServiceOrdered, true,4556, 0, "2021-05-09");
        this.configureUrls();
        this.configureServicesAllPass();
        var orderShipment = new OrderShipment(orderDetails, portService, harbourService, stevedoreService, urlConfig);
        var actual = orderShipment.placeOrder();

        var expected = "235369.98";

        Assert.isTrue(actual.equals(expected), "actual was: " + actual);
    }

    private void configureServicesAllPass() throws IOException
    {
        var uuid = UUID.randomUUID().toString();
        var berths = new ArrayList<String>();
        berths.add(uuid);
        when(portService.getBerthAvailability(any(), any(), any())).thenReturn(berths);
        var receipt = new Receipt(uuid, 78456.66);
        when(portService.orderPort(anyString(), any(), any())).thenReturn(receipt);

        when(harbourService.getPilotAvailabilities(any(), any(), any(), any())).thenReturn(true);
        when(harbourService.postPilotOrder(any(), any(), any(), any())).thenReturn(receipt);
        when(stevedoreService.orderStevedore(any(), any(), any(), any())).thenReturn(receipt);
    }

    private void configureServicesNoPilots() throws IOException
    {
        var uuid = UUID.randomUUID().toString();
        var berths = new ArrayList<String>();
        berths.add(uuid);
        when(portService.getBerthAvailability(any(), any(), any())).thenReturn(berths);
        var receipt = new Receipt(uuid, 78456.66);
        when(portService.orderPort(anyString(), any(), any())).thenReturn(receipt);

        when(harbourService.getPilotAvailabilities(any(), any(), any(), any())).thenReturn(false);
    }

    private void configureUrls()
    {
        when(urlConfig.getOrderPilotUrl()).thenReturn("http://wibble");
        when(urlConfig.getRequestPortUrl()).thenReturn("http://wibble");
        when(urlConfig.getOrderPortUrl()).thenReturn("http://wibble");
        when(urlConfig.getPilotAvailabilityUrl()).thenReturn("http://wibble");
        when(urlConfig.getOrderPilotUrl()).thenReturn("http://wibble");
        when(urlConfig.getOrderStevedoreUrl()).thenReturn("http://wibble");
    }
}
