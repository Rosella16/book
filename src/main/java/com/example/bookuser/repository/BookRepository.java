package com.example.bookuser.repository;

import com.example.bookuser.model.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface BookRepository extends JpaRepository<Book, UUID> {
    public List<Book> findByBookTitle(String bookTitle);

}
