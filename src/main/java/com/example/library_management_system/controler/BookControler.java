package com.example.library_management_system.controler;


import com.example.library_management_system.dto.BookDTO;
import com.example.library_management_system.dto.paginate.PaginatedGetAllBooksDTO;
import com.example.library_management_system.service.BookService;
import com.example.library_management_system.util.StandedResponce;
import org.apache.catalina.LifecycleState;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;

@RestController
@RequestMapping(path = "api/v1/book")
@CrossOrigin
public class BookControler {

    @Autowired
    private BookService bookService;

    // ADD book
    @PostMapping(path = "/add-book")
    @ResponseStatus(HttpStatus.CREATED)
    public StandedResponce addBook(@RequestBody BookDTO bookDTO) {
        String message = bookService.SaveBook(bookDTO);
        return new StandedResponce(201, "Adding compleat", message);
    }


//    Update book

    @PutMapping(path = "book-update")
    public ResponseEntity<StandedResponce> updateBook(@RequestBody BookDTO bookDTO) {
        String message = bookService.updateBook(bookDTO);
        return new ResponseEntity<StandedResponce>(new StandedResponce(200, "Updating compleat", message), HttpStatus.OK);
    }


    // get all  books with pagination
    @GetMapping(path = "get-all-book", params = {"page", "size"})
    public ResponseEntity<StandedResponce> getAllBook(@RequestParam(value = "page") int page, @RequestParam int size) {
        PaginatedGetAllBooksDTO paginatedGetAllBooksDTO = bookService.getAllBokksPaginated(page, size);
        return new ResponseEntity<StandedResponce>(new StandedResponce(200, "geting sucsess", paginatedGetAllBooksDTO), HttpStatus.OK);
    }

    // delete book

    @DeleteMapping(path = "delete-book" , params = "isbn")
    public ResponseEntity<StandedResponce> deleteBook(@RequestParam  String isbn) {
        String message  = bookService.DeleteBook(isbn);
       return new ResponseEntity<StandedResponce>(new StandedResponce(200, "Deleting compleat", message), HttpStatus.OK);

    }

    //Serch By ISBN

    @GetMapping(path = "serch-book-isbn/{isbn}")
    public ResponseEntity<StandedResponce> searchBookByIsbn(@PathVariable String isbn) {

        BookDTO bookDTO = bookService.SerchBookByISBN(isbn);

        return new ResponseEntity<StandedResponce>(new StandedResponce(200, "Serch Result", bookDTO), HttpStatus.OK);
    }
}
