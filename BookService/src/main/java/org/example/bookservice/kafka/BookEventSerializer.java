package org.example.bookservice.kafka;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.kafka.common.serialization.Serializer;
import org.example.bookservice.event.BookEvent;

import java.util.Map;

public class BookEventSerializer implements Serializer<BookEvent> {

    private final ObjectMapper objectMapper = new ObjectMapper();

    public BookEventSerializer() {
    }

    @Override
    public byte[] serialize(String topic, BookEvent data) {
        try {
            if (data == null) return null;
            return objectMapper.writeValueAsBytes(data);
        } catch (Exception e) {
            throw new RuntimeException("Erreur de sérialisation BookEvent", e);
        }
    }

    @Override
    public void configure(Map<String, ?> configs, boolean isKey) {
    }

    @Override
    public void close() {
    }
}
