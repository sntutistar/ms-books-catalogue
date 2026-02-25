package com.relato.msbookscatalogue.controller;

import com.relato.msbookscatalogue.search.BookDocument;
import com.relato.msbookscatalogue.repository.BookSearchRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/books")
public class BookController {

    private final BookSearchRepository repository;

    public BookController(BookSearchRepository repository) {
        this.repository = repository;
    }

    @GetMapping
    public Iterable<BookDocument> getAll() {
        return repository.findAll();
    }

    @PostMapping
    public BookDocument create(@RequestBody BookDocument book) {
        return repository.save(book);
    }

    @GetMapping("/search")
    public List<BookDocument> search(@RequestParam String query) {
        return repository.findByTitleContainingOrAuthorContaining(query, query);
    }

    @GetMapping("/facet")
    public List<BookDocument> facetByCategory(@RequestParam String category) {
        return repository.findByCategory(category);
    }
}