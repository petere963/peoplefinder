package javasound.peoplefinder.entity;

import com.fasterxml.jackson.databind.ObjectMapper;
import javasound.peoplefinder.util.TestDataSupplier;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.List;

import static org.assertj.core.api.Java6Assertions.assertThat;

class PersonTest {

    public static final int ID = 123;
    public static final String FIRST_NAME = "firstName";
    public static final String LAST_NAME = "lastName";
    public static final String EMAIL = "email";
    public static final String IP_ADDRESS = "ipAddress";
    public static final double LATITUDE = 1.234;
    public static final double LONGITUDE = 5.678;
    private ObjectMapper objectMapper = new ObjectMapper();
    private final TestDataSupplier testDataSupplier = new TestDataSupplier();

    @Test
    public void shouldBuildFromJson() throws IOException {
        String json = testDataSupplier.aPersonJson();
        Person person = objectMapper.readValue(json, Person.class);

        assertThat(person).isNotNull();
    }

    @Test
    public void shouldBuildListFromJson() throws IOException {

        String json = testDataSupplier.somePeopleJson();
        List<LinkedHashMap> people = objectMapper.readValue(json, List.class);
        assertThat(people.isEmpty()).isFalse();
    }

    @Test
    public void shouldSetandGet() {
        Person person = new Person(ID, FIRST_NAME, LAST_NAME, EMAIL, IP_ADDRESS, LATITUDE, LONGITUDE);

        assertThat(person.getId()).isEqualTo(ID);
        assertThat(person.getFirstName()).isEqualTo(FIRST_NAME);
        assertThat(person.getLastName()).isEqualTo(LAST_NAME);
        assertThat(person.getEmail()).isEqualTo(EMAIL);
        assertThat(person.getIp()).isEqualTo(IP_ADDRESS);
        assertThat(person.getLatitude()).isEqualTo(LATITUDE);
        assertThat(person.getLongitude()).isEqualTo(LONGITUDE);
    }



}