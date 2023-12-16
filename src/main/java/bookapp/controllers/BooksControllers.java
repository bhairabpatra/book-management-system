package bookapp.controllers;

import bookapp.exceptions.UserResponse;
import bookapp.models.Books;
import bookapp.services.BookService;
import jakarta.el.ELManager;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("v1/api/book")
@CrossOrigin("*")
public class BooksControllers {
    @Autowired
    private BookService bookService;

    @PostMapping("/create")
    public ResponseEntity<UserResponse> createBook(@RequestBody Books book) {
        Books newBook = bookService.create(book);
        if (newBook != null) {
            return ResponseEntity.ok().body(new UserResponse<>("Book created successfully !!", HttpStatus.CREATED.value(), newBook));
        } else {
            return ResponseEntity.ok().body(new UserResponse<>("Failed to create book !!", HttpStatus.INTERNAL_SERVER_ERROR.value(), null));
        }
    }

    @GetMapping("/get-books")
    public ResponseEntity<?> getBooks() {
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add("info", "test");
        List<Books> books = bookService.getBooks();
        int numberOfBooks = books.size();
        if (books.isEmpty()) {
            return ResponseEntity.ok().body(new UserResponse<>("No books found :- " + numberOfBooks, HttpStatus.OK.value(), null));
        }
        return ResponseEntity.ok().body(new UserResponse<>("No of record found :- " + numberOfBooks, HttpStatus.OK.value(), books));
    }

    @GetMapping("{id}")
    public ResponseEntity<Books> getBook(@PathVariable UUID id){
        Books books = bookService.getBook(id);
        return new ResponseEntity<>(books,HttpStatus.OK);
    }
    @GetMapping("/author/{author}")
    public ResponseEntity<List<Books>> getPublisher(@PathVariable String author){
        List<Books> books = bookService.findByAuthor(author);
        return new ResponseEntity<>(books,HttpStatus.OK);
    }
}
