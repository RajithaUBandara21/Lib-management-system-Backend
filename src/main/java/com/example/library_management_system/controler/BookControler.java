package com.example.library_management_system.controler;


import com.example.library_management_system.dto.BookDTO;
import com.example.library_management_system.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "api/v1/book")
@CrossOrigin
public class BookControler {

    @Autowired
    private BookService bookService;

    @PostMapping(path = "/add-book")
    public String addBook(@RequestBody BookDTO bookDTO) {

        return bookService.SaveBook(bookDTO);
    }


}
