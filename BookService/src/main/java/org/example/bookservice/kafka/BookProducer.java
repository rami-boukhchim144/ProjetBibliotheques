package org.example.bookservice.kafka;

import org.example.bookservice.event.BookEvent;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class BookProducer {

    private final KafkaTemplate<String, BookEvent> kafkaTemplate;
    private static final String TOPIC = "book-topic";

    public BookProducer(KafkaTemplate<String, BookEvent> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void sendBookEvent(BookEvent bookEvent) {
        kafkaTemplate.send(TOPIC, bookEvent);
        System.out.println("Event envoyé: " + bookEvent);
    }
}
