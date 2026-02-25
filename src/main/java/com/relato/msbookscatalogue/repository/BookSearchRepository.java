package com.relato.msbookscatalogue.repository;

import com.relato.msbookscatalogue.search.BookDocument;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

import java.util.List;

public interface BookSearchRepository
        extends ElasticsearchRepository<BookDocument, String> {

    List<BookDocument> findByTitleContainingOrAuthorContaining(String title, String author);

    List<BookDocument> findByCategory(String category);

    
}