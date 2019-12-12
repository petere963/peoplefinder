package javasound.peoplefinder.service;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Java6Assertions.assertThat;

class DistanceCalculatorTest {

    @DisplayName("Calculate distance between two coordinates")
    @ParameterizedTest(name = "Award type: {0}")
    @CsvSource(value = {
            "51.4999289,-0.1333594,53.7981361,-1.5326622,169, Caxton to Quarry",
            "53.7981361,-1.5326622,53.8966983,-1.7194755,10, Quarry to Otley"
    })
    void calculateDistance(String fromLat, String fromLong, String toLat, String toLong, String result, String description) {

        int distance = new DistanceCalculator().distanceMiles(
                Double.valueOf(fromLat),
                Double.valueOf(fromLong),
                Double.valueOf(toLat),
                Double.valueOf(toLong));

        assertThat(distance).isEqualTo(Integer.valueOf(result));
    }
}