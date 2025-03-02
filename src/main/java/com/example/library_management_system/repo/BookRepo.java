package com.example.library_management_system.repo;

import com.example.library_management_system.entity.Book;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestMapping;


@Repository
@EnableJpaRepositories
public interface BookRepo extends JpaRepository<Book, Integer> {

    Book getBooksByIsbnEquals(String isbn);

    boolean existsByIsbnEquals(String isbn);

    Page<Book>findAll(Pageable pageable);

    long count();

    void deleteBookByIsbnEquals(String isbn);
}
