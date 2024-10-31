package com.example.bookuser.service;

import com.example.bookuser.model.entity.Author;
import com.example.bookuser.model.request.AuthorRequest;
import com.example.bookuser.model.response.AuthorResponse;
import com.example.bookuser.util.ApiResponse;

import java.util.List;
import java.util.UUID;

public interface AuthorService {
    AuthorResponse createAuthor(AuthorRequest authorRequest);
    List<Author> getAllAuthor();
    Author getAuthorById(UUID id);
    void deleteAuthorById(UUID id);
    Author updateAuthorById(UUID id , AuthorRequest authorRequest);

}
