package com.example.library_management_system.service;


import com.example.library_management_system.dto.BookDTO;

public interface BookService {
    String SaveBook(BookDTO bookDTO);

    String updateBook(BookDTO bookDTO);
}
