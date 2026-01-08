package org.example.bookservice.event;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BookEvent {

    private String type;   // CREATED, UPDATED, DELETED
    private Long bookId;
    private String title;
}
