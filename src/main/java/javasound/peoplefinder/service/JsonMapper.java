package javasound.peoplefinder.service;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectReader;
import javasound.peoplefinder.entity.Person;
import javasound.peoplefinder.exception.JsonMappingException;

import java.io.IOException;
import java.util.List;

public class JsonMapper {

    public static final String ERROR_WHEN_DECODING_LIST = "Error when decoding list";

    public List<Person> getPeople(String json) {

        ObjectMapper objectMapper = new ObjectMapper();
        ObjectReader objectReader = objectMapper.reader().forType(new TypeReference<List<Person>>(){});

        try {
            return objectReader.readValue(json);
        } catch (IOException e) {
            throw new JsonMappingException(ERROR_WHEN_DECODING_LIST, e);
        }
    }
}
