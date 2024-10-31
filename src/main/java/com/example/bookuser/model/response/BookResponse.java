package com.example.bookuser.model.response;

import com.example.bookuser.model.entity.Author;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor

public class BookResponse {
    private UUID bookId;
    private String bookTitle;
    private String publishYear;
    private Author author;
}
