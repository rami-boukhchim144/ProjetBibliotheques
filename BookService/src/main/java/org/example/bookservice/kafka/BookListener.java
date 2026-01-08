package org.example.bookservice.kafka;

import org.example.bookservice.event.BookEvent;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class BookListener {

    @KafkaListener(topics = "book-topic", groupId = "book-service")
    public void onBookEvent(BookEvent event) {
        System.out.println("Book event reçu: " + event);
        // Ici tu peux ajouter la logique métier (cache, audit, etc.)
    }
}
