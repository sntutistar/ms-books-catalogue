package com.relato.msbookscatalogue.repository;

import com.relato.msbookscatalogue.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.List;
import java.util.Optional;

public interface BookRepository
        extends JpaRepository<Book, Long>,
                JpaSpecificationExecutor<Book> {

    Optional<Book> findByIdAndDeletedFalse(Long id);

    List<Book> findByTitleContainingIgnoreCaseAndDeletedFalseOrAuthorContainingIgnoreCaseAndDeletedFalse(
            String title, String author);

    List<Book> findByCategoryAndDeletedFalse(String category);
}
