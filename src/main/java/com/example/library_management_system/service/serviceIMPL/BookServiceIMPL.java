package com.example.library_management_system.service.serviceIMPL;

import com.example.library_management_system.dto.BookDTO;
import com.example.library_management_system.dto.paginate.PaginatedGetAllBooksDTO;
import com.example.library_management_system.entity.Book;
import com.example.library_management_system.exeption.NotFoundExeption;
import com.example.library_management_system.repo.BookRepo;
import com.example.library_management_system.service.BookService;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;


@Service
public class BookServiceIMPL implements BookService {

    @Autowired
    private BookRepo bookRepo;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public String SaveBook(BookDTO bookDTO) {
        Book book = modelMapper.map(bookDTO, Book.class);
        bookRepo.save(book);
        return book.getTitle() + " Book added successfully";
    }

    @Override
    public String updateBook(BookDTO bookDTO) {
        if (bookRepo.existsByIsbnEquals(bookDTO.getIsbn())) {
            Book book = bookRepo.getBooksByIsbnEquals(bookDTO.getIsbn());
            book.setAuthor(bookDTO.getAuthor());
            book.setQty(bookDTO.getQty());
            book.setIsbn(bookDTO.getIsbn());
            book.setCategory(bookDTO.getCategory());
            book.setTitle(bookDTO.getTitle());
            bookRepo.save(book);
            return bookDTO.getTitle() + " Book Updated";
        } else  throw new NotFoundExeption("Book not found");


    }


    @Override
    public PaginatedGetAllBooksDTO getAllBokksPaginated(int page, int size) {
        Page<Book> books = bookRepo.findAll(PageRequest.of(page, size));
        if (books.getSize() > 0) {
            List<BookDTO> bookDTOs = books.getContent().stream()
                    .map(book -> modelMapper.map(book, BookDTO.class))
                    .collect(Collectors.toList());
            PaginatedGetAllBooksDTO paginatedGetAllBooksDTO = new PaginatedGetAllBooksDTO(
                    bookDTOs, bookRepo.count()
            );
            return paginatedGetAllBooksDTO;
        } else {
            throw new NotFoundExeption("Books Not Found for get AllBooks");
        }
    }

    @Transactional
    @Override
    public String DeleteBook(String isbn) {
        if(bookRepo.existsByIsbnEquals(isbn)) {
            bookRepo.deleteBookByIsbnEquals(isbn);
        }else throw new NotFoundExeption("Book not found");
        return "Item deleted successfully";
    }
}
