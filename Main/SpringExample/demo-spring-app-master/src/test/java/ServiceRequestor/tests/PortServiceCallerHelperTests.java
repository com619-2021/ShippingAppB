package ServiceRequestor.tests;

import ServiceRequestor.PortServiceCallerHelper;
import org.junit.jupiter.api.Test;
import org.springframework.util.Assert;

public class PortServiceCallerHelperTests
{
    @Test
    public void builtStringIsExpected()
    {
        var shipDraft = "450";
        var shipWidth = "670";
        var shipLength = "4000";
        var date = "12-Oct-2021";

        final String expected = "450:4000:670:12-Oct-2021";
        var actual = PortServiceCallerHelper.buildPortAvailabilityParams(shipDraft, shipLength, shipWidth, date);

        Assert.isTrue(expected.equals(actual), "the actual was: " + actual);
    }
}