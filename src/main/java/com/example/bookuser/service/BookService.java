package com.example.bookuser.service;

import com.example.bookuser.model.entity.Book;
import com.example.bookuser.model.request.BookRequest;
import com.example.bookuser.model.response.BookResponse;

import java.util.List;
import java.util.UUID;

public interface BookService {
    Book createBook (BookRequest bookRequest);
    List<Book> getAllBook();
    Book getBookById(UUID bookId);
    void deleteBookById(UUID bookId);
    Book updateBookById(UUID bookId, BookRequest bookRequest);
    List<Book> getBookByBookTitle(String bookTitle);
}
