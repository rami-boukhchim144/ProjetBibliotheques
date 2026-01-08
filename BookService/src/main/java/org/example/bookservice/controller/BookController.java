package org.example.bookservice.controller;


import org.example.bookservice.entity.Book;
import org.example.bookservice.kafka.BookProducer;
import org.example.bookservice.event.BookEvent;
import org.example.bookservice.repository.BookRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/books")
public class BookController {
    private final BookRepository repository;
    private final BookProducer producer;

    public BookController(BookRepository repository, BookProducer producer) {
        this.repository = repository;
        this.producer = producer;
    }
    @GetMapping
    public List<Book> getAllBooks() {
        return repository.findAll();
    }

    @PostMapping
    public Book createBook(@RequestBody Book book) {
        Book saved = repository.save(book);
        // envoyer un événement CREATED
        producer.sendBookEvent(new BookEvent("CREATED", saved.getId(), saved.getTitle()));
        return saved;
    }

    @PutMapping("/{id}")
    public Book updateBook(@PathVariable Long id, @RequestBody Book book) {
        Book existing = repository.findById(id).orElseThrow();
        existing.setTitle(book.getTitle());
        existing.setAuthor(book.getAuthor());
        existing.setAvailable(book.isAvailable());
        Book saved = repository.save(existing);
        producer.sendBookEvent(new BookEvent("UPDATED", saved.getId(), saved.getTitle()));
        return saved;
    }

    @DeleteMapping("/{id}")
    public void deleteBook(@PathVariable Long id) {
        repository.deleteById(id);
        producer.sendBookEvent(new BookEvent("DELETED", id, null));
    }

}
