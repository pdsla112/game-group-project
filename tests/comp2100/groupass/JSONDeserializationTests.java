package comp2100.groupass;

import comp2100.groupass.data.LocationData;
import comp2100.groupass.data.LocationJSON;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.Timeout;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

public class JSONDeserializationTests {

    @Rule
    public Timeout globalTimeout = Timeout.millis(1000);

    @Test
    public void testSimpleSpecificLocation() {
        ArrayList<String> inputList = new ArrayList<>();
        inputList.add("cottage");
        inputList.add("forest");
        inputList.add("hospital");
        inputList.add("forest");
        inputList.add("lab");

        for (String input : inputList) {
            LocationData actualLocationData = LocationJSON.getSpecificLocationData(input);
            String actualLocation = actualLocationData.getLocation();
            assertEquals("Incorrect location data deserialized from JSON DB...", input, actualLocation);
        }
    }

    @Test
    public void testSimpleEdgeCaseSpecificLocation() {
        ArrayList<String> inputList = new ArrayList<>();
        inputList.add("");
        inputList.add("cottages");
        inputList.add("ho spital");
        inputList.add("7");
        inputList.add("pdsla112");

        for (String input : inputList) {
            LocationData actualLocationData = LocationJSON.getSpecificLocationData(input);
            assertEquals("Incorrect location data deserialized from JSON DB...", null, actualLocationData);
        }
    }
}
