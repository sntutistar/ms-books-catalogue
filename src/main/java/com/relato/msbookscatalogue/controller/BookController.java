package com.relato.msbookscatalogue.controller;

import com.relato.msbookscatalogue.model.Book;
import com.relato.msbookscatalogue.repository.BookRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/books")
public class BookController {

    private final BookRepository repository;

    public BookController(BookRepository repository) {
        this.repository = repository;
    }

    @GetMapping
    public List<Book> getAll() {
        return repository.findAll()
                .stream()
                .filter(book -> !book.getDeleted())
                .toList();
    }

    @PostMapping
    public Book create(@RequestBody Book book) {
        return repository.save(book);
    }

    @GetMapping("/search")
    public List<Book> search(@RequestParam String query) {
        return repository
                .findByTitleContainingIgnoreCaseAndDeletedFalseOrAuthorContainingIgnoreCaseAndDeletedFalse(
                        query, query);
    }

    @GetMapping("/facet")
    public List<Book> facetByCategory(@RequestParam String category) {
        return repository.findByCategoryAndDeletedFalse(category);
    }
}
