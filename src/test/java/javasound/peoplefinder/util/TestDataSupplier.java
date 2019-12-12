package javasound.peoplefinder.util;

import java.io.*;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;

public class TestDataSupplier {

    public String aPersonJson() {
        try {
            return getTextFromFile("json/person.json");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public String somePeopleJson() {
        try {
            return getTextFromFile("json/personList.json");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private String getTextFromFile(String fileName) throws IOException {
        InputStream inputStream = getClass()
                .getClassLoader().getResourceAsStream(fileName);

        StringBuilder textBuilder = new StringBuilder();
        try (Reader reader = new BufferedReader(new InputStreamReader
                (inputStream, Charset.forName(StandardCharsets.UTF_8.name())))) {
            int c = 0;
            while ((c = reader.read()) != -1) {
                textBuilder.append((char) c);
            }
        }

        return textBuilder.toString();
    }
}
