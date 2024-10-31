package com.example.bookuser.controller;

import com.example.bookuser.model.entity.Author;
import com.example.bookuser.model.request.AuthorRequest;
import com.example.bookuser.model.response.AuthorResponse;
import com.example.bookuser.service.AuthorService;
import com.example.bookuser.util.ApiResponse;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

import static java.util.stream.Stream.builder;

@RestController
@RequestMapping("/api/v1/authors")
@AllArgsConstructor
public class AuthorController {
    private final AuthorService authorService;
    @PostMapping("add-new-author")
    public ApiResponse<AuthorResponse> createAuthor(@RequestBody AuthorRequest authorRequest) {
         AuthorResponse authorResponse = authorService.createAuthor(authorRequest);
         ApiResponse<AuthorResponse> response = ApiResponse.<AuthorResponse>builder()
                 .message("Author created successfully")
                 .status(HttpStatus.CREATED)
                 .payload(authorResponse)
                 .date(LocalDateTime.now())
                 .build();
        return response;

    }
    @GetMapping("get-all-authors")
    public ResponseEntity<ApiResponse<List<Author>>> getAllAuthor(){
        List<Author> author = authorService.getAllAuthor();
        ApiResponse<List<Author>> response = ApiResponse.<List<Author>>builder()
                .message("sucessfully get all authors")
                .status(HttpStatus.OK)
                .payload(author)
                .date(LocalDateTime.now())
                .build();
        return ResponseEntity.ok(response);
    }
    @DeleteMapping("/{authorId}")
    public ResponseEntity<ApiResponse<Void>> deleteAuthorById(@PathVariable UUID authorId) {
        authorService.deleteAuthorById(authorId);
        ApiResponse<Void> response = ApiResponse.<Void>builder()
                .message("Successfully deleted author by id")
                .status(HttpStatus.OK)
                .date(LocalDateTime.now())
                .build();
       return ResponseEntity.ok(response);
    }
    @GetMapping("/{authorId}")
    public ResponseEntity<ApiResponse<Author>> getAuthorById(@PathVariable UUID authorId) {
        Author author = authorService.getAuthorById(authorId);
        ApiResponse<Author> response = ApiResponse.<Author>builder()
                .message("Successfully get author by id")
                .status(HttpStatus.OK)
                .payload(author)
                .date(LocalDateTime.now())
                .build();
        return ResponseEntity.ok(response);
    }
    @PutMapping("/{authorId}")
    public ResponseEntity<ApiResponse<Author>> updateAuthorById(@PathVariable UUID authorId, @RequestBody AuthorRequest authorRequest) {
        Author author = authorService.updateAuthorById(authorId, authorRequest);
        ApiResponse<Author> response = ApiResponse.<Author>builder()
                .message("Successfully update author by id")
                .status(HttpStatus.OK)
                .payload(author)
                .date(LocalDateTime.now())
                .build();
        return ResponseEntity.ok(response);
    }


}
