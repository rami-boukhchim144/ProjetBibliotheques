package org.example.userservice.kafka;

import org.example.userservice.event.BookEvent;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class BookEventListener {

    @KafkaListener(
            topics = "book-topic",
            groupId = "user-service",
            containerFactory = "kafkaListenerContainerFactory"
    )
    public void listen(BookEvent event) {

        // Affichage complet de l'événement
        System.out.println("📩 UserService a reçu un BookEvent :");
        System.out.println(" - Type de l'événement : " + event.getType());
        System.out.println(" - ID du livre : " + event.getBookId());
        System.out.println(" - Titre du livre : " + event.getTitle());
    }
}
