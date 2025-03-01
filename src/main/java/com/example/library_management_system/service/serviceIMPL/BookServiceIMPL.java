package com.example.library_management_system.service.serviceIMPL;

import com.example.library_management_system.dto.BookDTO;
import com.example.library_management_system.entity.Book;
import com.example.library_management_system.repo.BookRepo;
import com.example.library_management_system.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



@Service
public class BookServiceIMPL implements BookService {

@Autowired
private BookRepo bookRepo;
    @Override
    public String SaveBook(BookDTO bookDTO) {

        Book book = new Book(
                bookDTO.getIsbn(),
                bookDTO.getTitle(),
                bookDTO.getAuthor(),
                bookDTO.getCategory(),
                bookDTO.getQty()


        );

        bookRepo.save(book);
        return book.getIsbn() + "Saved";
    }
}
