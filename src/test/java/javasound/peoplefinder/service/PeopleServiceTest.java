package javasound.peoplefinder.service;

import javasound.peoplefinder.app.ApplicationConfiguration;
import javasound.peoplefinder.entity.Locations;
import javasound.peoplefinder.entity.Person;
import javasound.peoplefinder.util.TestDataSupplier;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.List;

import static org.assertj.core.api.Java6Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class PeopleServiceTest {

    private PeopleService peopleService;
    private ApplicationConfiguration config = mock(ApplicationConfiguration.class);
    private DistanceCalculator calculator = mock(DistanceCalculator.class);
    private Gateway gateway = mock(Gateway.class);
    private TestDataSupplier testDataSupplier;

    @BeforeEach
    public void setUp() {
        peopleService = new PeopleService(config, calculator, gateway);
        testDataSupplier = new TestDataSupplier();
        when(config.getSearchRadius()).thenReturn(10);
    }

    @Test
    public void shouldGetPeople() {
        when(gateway.getJson(Mockito.anyString())).thenReturn(testDataSupplier.somePeopleJson());
        when(calculator.distanceMiles(any(), any(), any(), any())).thenReturn(1);
        List<Person> people = peopleService.find(Locations.LONDON);

        assertThat(people.isEmpty()).isFalse();
    }

    @Test
    public void shouldExcludePeople() {
        when(gateway.getJson(Mockito.anyString())).thenReturn(testDataSupplier.somePeopleJson());
        when(calculator.distanceMiles(any(), any(), any(), any())).thenReturn(100);
        List<Person> people = peopleService.find(Locations.LONDON);

        assertThat(people.isEmpty()).isTrue();
    }
}