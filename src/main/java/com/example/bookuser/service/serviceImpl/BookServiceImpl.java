package com.example.bookuser.service.serviceImpl;

import com.example.bookuser.model.entity.Author;
import com.example.bookuser.model.entity.Book;
import com.example.bookuser.model.request.AuthorRequest;
import com.example.bookuser.model.request.BookRequest;
import com.example.bookuser.repository.AuthorRepository;
import com.example.bookuser.repository.BookRepository;
import com.example.bookuser.service.BookService;
import lombok.AllArgsConstructor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.UUID;

@Service
@AllArgsConstructor
public class BookServiceImpl implements BookService {
    private final BookRepository bookRepository;
    private final AuthorRepository authorRepository;

    @Override
    public Book createBook(BookRequest bookRequest) {
        Book newbook = new Book();
        newbook.setBookTitle(bookRequest.getBookTitle());
        newbook.setPublishYear(bookRequest.getPublishYear());
        Author author = authorRepository.findById(bookRequest.getAuthorId()).orElseThrow();
        newbook.setAuthor(author);
        return bookRepository.save(newbook);
    }

    @Override
    public List<Book> getAllBook() {
        return bookRepository.findAll();
    }

    @Override
    public Book getBookById(UUID bookId) {
        Book book =  bookRepository.findById(bookId).orElseThrow();
         return book;
    }

    @Override
    public void deleteBookById(UUID bookId) {
         bookRepository.deleteById(bookId);
    }

    @Override
    public Book updateBookById(UUID bookId, BookRequest bookRequest) {
        Book existingBook = bookRepository.findById(bookId).orElseThrow();
        existingBook.setBookTitle(bookRequest.getBookTitle());
        existingBook.setPublishYear(bookRequest.getPublishYear());
        Author author = authorRepository.findById(bookRequest.getAuthorId()).orElseThrow();
        existingBook.setAuthor(author);
        return bookRepository.save(existingBook);
    }
}
