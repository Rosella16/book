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
    public List<Author> getAllAuthor(){
        return authorService.getAllAuthor();
    }
    @DeleteMapping("/{authorId}")
    public ResponseEntity deleteAuthorById(@PathVariable UUID authorId) {
        authorService.deleteAuthorById(authorId);
       return ResponseEntity.ok("delete succesfully");
    }
    @GetMapping("/{authorId}")
    public Author getAuthorById(@PathVariable UUID authorId) {
        return authorService.getAuthorById(authorId);
    }
    @PutMapping("/{authorId}")
    public Author updateAuthorById(@PathVariable UUID authorId, @RequestBody AuthorRequest authorRequest) {
        return authorService.updateAuthorById(authorId, authorRequest);
    }

}
