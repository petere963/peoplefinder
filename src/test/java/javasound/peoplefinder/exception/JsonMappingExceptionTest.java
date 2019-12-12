package javasound.peoplefinder.exception;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Java6Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class JsonMappingExceptionTest {

    public static final String SOME_MESSAGE = "Some message";
    public static final String RUNTIME_MESSAGE = "runtimeMessage";

    @Test
    public void shouldConstruct() {

        JsonMappingException exception = new JsonMappingException(SOME_MESSAGE, new RuntimeException(RUNTIME_MESSAGE));

        assertThat(exception.getMessage()).isEqualTo(SOME_MESSAGE);
        assertThat(exception.getCause().getMessage()).isEqualTo(RUNTIME_MESSAGE);
    }
}