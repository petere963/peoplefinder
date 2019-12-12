package javasound.peoplefinder.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import javasound.peoplefinder.entity.Person;
import javasound.peoplefinder.exception.JsonMappingException;
import javasound.peoplefinder.util.TestDataSupplier;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static javasound.peoplefinder.service.JsonMapper.ERROR_WHEN_DECODING_LIST;
import static org.assertj.core.api.Java6Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

class JsonMapperTest {

    private final TestDataSupplier testDataSupplier = new TestDataSupplier();
    private final ObjectMapper objectMapper = new ObjectMapper();

    private JsonMapper jsonMapper;

    @BeforeEach
    public void setUp() {
        jsonMapper = new JsonMapper();
    }

    @DisplayName("Decode list of people from supplied json")
    @Test
    public void shouldMapListFromJson() {

        List<Person> people = jsonMapper.getPeople(testDataSupplier.somePeopleJson());

        assertThat(people.isEmpty()).isFalse();
        assertThat(people.get(0).getId() > 0).isTrue();
    }

    @DisplayName("Throw an error when attempting to map invalid json")
    @Test
    public void shouldThrowErrorOnInvalidJson() {

        Throwable thrown = assertThrows(JsonMappingException.class,
                () -> jsonMapper.getPeople("someInvalidJson"));

        assertThat(thrown.getMessage()).isEqualTo(ERROR_WHEN_DECODING_LIST);

    }
}