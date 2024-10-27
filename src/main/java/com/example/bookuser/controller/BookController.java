package com.example.bookuser.controller;

import com.example.bookuser.model.entity.Book;
import com.example.bookuser.model.request.BookRequest;
import com.example.bookuser.service.BookService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("api/v1/books")
@AllArgsConstructor
public class BookController {
    private final BookService bookService;
    @PostMapping("create-new-book")
    public Book createBook(@RequestBody BookRequest bookRequest){
        return bookService.createBook(bookRequest);
    }
    @GetMapping("get-all-books")
    public List<Book> getAllBooks(){
        return bookService.getAllBook();
    }
    @GetMapping("{bookId}")
    public Book getBookById(@PathVariable UUID bookId){
        return bookService.getBookById(bookId);
    }
    @DeleteMapping("{bookId}")
    public void deleteBookById(@PathVariable UUID bookId) {
        bookService.deleteBookById(bookId);
    }
    @PutMapping("{bookId}")
    public Book updateBookById(@PathVariable UUID bookId, @RequestBody BookRequest bookRequest) {
        return bookService.updateBookById(bookId, bookRequest);
    }
}
