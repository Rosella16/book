package com.example.bookuser.model.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Book {
    @Id
    @GeneratedValue(strategy= GenerationType.UUID)
    private UUID bookId;
    private String bookTitle;
    private String publishYear;
    @ManyToOne
    @JoinColumn(name="author_id", referencedColumnName = "authorId")
    private Author author;

}
