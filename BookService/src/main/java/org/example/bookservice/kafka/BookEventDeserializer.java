package org.example.bookservice.kafka;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.kafka.common.serialization.Deserializer;
import org.example.bookservice.event.BookEvent;

import java.util.Map;

public class BookEventDeserializer implements Deserializer<BookEvent> {

    private final ObjectMapper objectMapper = new ObjectMapper();

    public BookEventDeserializer() {
    }

    @Override
    public void configure(Map<String, ?> configs, boolean isKey) {
    }

    @Override
    public BookEvent deserialize(String topic, byte[] data) {
        try {
            if (data == null) return null;
            return objectMapper.readValue(data, BookEvent.class);
        } catch (Exception e) {
            throw new RuntimeException("Erreur de désérialisation BookEvent", e);
        }
    }

    @Override
    public void close() {
    }
}
