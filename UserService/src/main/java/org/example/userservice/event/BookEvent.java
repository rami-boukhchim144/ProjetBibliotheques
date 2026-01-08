package org.example.userservice.event;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@JsonIgnoreProperties(ignoreUnknown = true)
@Data
@AllArgsConstructor
@NoArgsConstructor
public class BookEvent {

    private String type;   // CREATED, UPDATED, DELETED
    private Long bookId;
    private String title;

    public String getType() {
        return type;
    }

    public Long getBookId() {
        return bookId;
    }

    public String getTitle() {
        return title;
    }
}
