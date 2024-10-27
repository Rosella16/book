package com.example.bookuser.controller;

import com.example.bookuser.model.entity.Author;
import com.example.bookuser.model.request.AuthorRequest;
import com.example.bookuser.service.AuthorService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/authors")
@AllArgsConstructor
public class AuthorController {
    private final AuthorService authorService;
    @PostMapping("add-new-author")
    public Author createAuthor(AuthorRequest authorRequest) {
        return authorService.createAuthor(authorRequest);
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
