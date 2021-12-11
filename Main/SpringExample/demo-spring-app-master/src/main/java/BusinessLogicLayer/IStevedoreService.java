package BusinessLogicLayer;

import BusinessLogicLayer.RestfulObjects.Receipt;

import java.io.IOException;
import java.net.URL;

public interface IStevedoreService
{
    Receipt orderStevedore(URL url) throws IOException;
}
