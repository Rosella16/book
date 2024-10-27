package com.example.bookuser.service.serviceImpl;

import com.example.bookuser.model.entity.Author;
import com.example.bookuser.model.request.AuthorRequest;
import com.example.bookuser.repository.AuthorRepository;
import com.example.bookuser.service.AuthorService;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

import static org.yaml.snakeyaml.tokens.Token.ID.Tag;

@Service
@AllArgsConstructor
public class AuthorServiceImpl implements AuthorService {
    private final AuthorRepository authorRepository;

    @Override
    public Author createAuthor(AuthorRequest authorRequest) {
        Author newAuthor = new Author();
        newAuthor.setAuthorName(authorRequest.getAuthorName());

        return authorRepository.save(newAuthor);
    }

    @Override
    public List<Author> getAllAuthor() {
        return authorRepository.findAll();
    }

    @Override
    public Author getAuthorById(UUID id) {
         Author author = authorRepository.findById(id).get();
         return author;

    }

    @Override
    public void deleteAuthorById(UUID id) {
        authorRepository.deleteById(id);
    }

    @Override
    public Author updateAuthorById(UUID id, AuthorRequest authorRequest) {
        Author existingAuthor = authorRepository.findById(id).get();
        existingAuthor.setAuthorName(authorRequest.getAuthorName());
         return authorRepository.save(existingAuthor);

    }
}
