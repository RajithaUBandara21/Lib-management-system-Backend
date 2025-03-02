package com.example.library_management_system.service;


import com.example.library_management_system.dto.BookDTO;
import com.example.library_management_system.dto.paginate.PaginatedGetAllBooksDTO;

public interface BookService {
    String SaveBook(BookDTO bookDTO);

    String updateBook(BookDTO bookDTO);

    PaginatedGetAllBooksDTO getAllBokksPaginated(int page, int size);
}
