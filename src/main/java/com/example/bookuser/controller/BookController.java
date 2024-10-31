package com.example.bookuser.controller;
import com.example.bookuser.model.entity.Book;
import com.example.bookuser.model.request.BookRequest;
import com.example.bookuser.service.BookService;
import com.example.bookuser.util.ApiResponse;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("api/v1/books")
@AllArgsConstructor
public class BookController {
    private final BookService bookService;
    @PostMapping("create-new-book")
    public ResponseEntity<ApiResponse<Book>> createBook(@RequestBody BookRequest bookRequest){
        Book book = bookService.createBook(bookRequest);
        ApiResponse<Book> response = ApiResponse.<Book>builder()
                .message("create book successfully")
                .status(HttpStatus.CREATED)
                .payload(book)
                .date(LocalDateTime.now())
                .build();
        return ResponseEntity.ok(response);
    }
    @GetMapping("get-all-books")
    public ResponseEntity<ApiResponse<List<Book>>> getAllBooks(){
        List<Book> book = bookService.getAllBook();
        ApiResponse<List<Book>> response = ApiResponse.<List<Book>>builder()
                .message("successfully get all books")
                .status(HttpStatus.OK)
                .payload(book)
                .date(LocalDateTime.now())
                .build();
        return ResponseEntity.ok(response);
    }
    @GetMapping("{bookId}")
    public ResponseEntity<ApiResponse<Book>> getBookById(@PathVariable UUID bookId){
        Book book = bookService.getBookById(bookId);
        ApiResponse<Book> response = ApiResponse.<Book>builder()
                .message("successfully get book by id")
                .status(HttpStatus.OK)
                .payload(book)
                .date(LocalDateTime.now())
                .build();
        return ResponseEntity.ok(response);
    }
    @DeleteMapping("{bookId}")
    public ResponseEntity<ApiResponse<Void>> deleteBookById(@PathVariable UUID bookId) {
        bookService.deleteBookById(bookId);
        ApiResponse<Void> response = ApiResponse.<Void>builder()
                .message("Successfully deleted book")
                .status(HttpStatus.OK)
                .date(LocalDateTime.now())
                .build();
        return ResponseEntity.ok(response);
    }
    @PutMapping("{bookId}")
    public ResponseEntity<ApiResponse<Book>> updateBookById(@PathVariable UUID bookId, @RequestBody BookRequest bookRequest) {
        Book book = bookService.updateBookById(bookId, bookRequest);
        ApiResponse<Book> response = ApiResponse.<Book>builder()
                .message("Successfully updated book by Id")
                .status(HttpStatus.OK)
                .payload(book)
                .date(LocalDateTime.now())
                .build();
        return ResponseEntity.ok(response);
    }
    @GetMapping("get-by-book-title")
    public ResponseEntity<ApiResponse<List<Book>>> getBookByBookTitle(@RequestParam(value="bookTitle") String bookTitle){
        List<Book> book = bookService.getBookByBookTitle(bookTitle);
        ApiResponse<List<Book>> response = ApiResponse.<List<Book>>builder()
                .message("get book by title successfully")
                .status(HttpStatus.OK)
                .payload(book)
                .date(LocalDateTime.now())
                .build();
         return ResponseEntity.ok(response);
    }

}
