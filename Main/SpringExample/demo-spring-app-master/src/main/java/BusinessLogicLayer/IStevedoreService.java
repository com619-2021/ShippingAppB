package BusinessLogicLayer;

import BusinessLogicLayer.RestfulObjects.Receipt;

import java.io.IOException;

public interface IStevedoreService
{
    Receipt orderStevedore() throws IOException;
}
