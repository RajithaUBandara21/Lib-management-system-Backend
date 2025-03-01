package com.example.library_management_system.service.serviceIMPL;

import com.example.library_management_system.dto.BookDTO;
import com.example.library_management_system.entity.Book;
import com.example.library_management_system.repo.BookRepo;
import com.example.library_management_system.service.BookService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



@Service
public class BookServiceIMPL implements BookService {

@Autowired
private BookRepo bookRepo;

@Autowired
private ModelMapper modelMapper;
    @Override
    public String SaveBook(BookDTO bookDTO) {

//        Book book = new Book(
//                bookDTO.getIsbn(),
//                bookDTO.getTitle(),
//                bookDTO.getAuthor(),
//                bookDTO.getCategory(),
//                bookDTO.getQty()
//        );

        Book book = modelMapper.map(bookDTO, Book.class);

        bookRepo.save(book);
        return book.getIsbn() + "Saved";
    }

    @Override
    public String updateBook(BookDTO bookDTO) {

        if (bookRepo.existsByIsbnEquals(bookDTO.getIsbn())){
            Book book = bookRepo.getBooksByIsbnEquals(bookDTO.getIsbn());

            book.setAuthor(bookDTO.getAuthor());
            book.setQty(bookDTO.getQty());
            book.setIsbn(bookDTO.getIsbn());
            book.setCategory(bookDTO.getCategory());
            book.setTitle(bookDTO.getTitle());
            bookRepo.save(book);
        }else throw new RuntimeException("Book Not Found");


        return bookDTO.getIsbn() + "Updated";
    }
}
