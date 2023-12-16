package bookapp.bookauthor.controllers;

import bookapp.bookauthor.entity.Author;
import bookapp.bookauthor.service.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("v1/api/author")
@CrossOrigin("*")
public class AuthorController {

    @Autowired
    private AuthorService authorService;

    @PostMapping("create")
    public ResponseEntity<Author> createAuthor(@RequestBody Author author){
        Author newAuthor = authorService.createAUthor(author);
        return new ResponseEntity<>(newAuthor, HttpStatus.CREATED);
    }

    @GetMapping("/getAuthors")
    public ResponseEntity<List<Author>> getAuthors(){
        List<Author> allAuthors = authorService.getAuthors();
        return new ResponseEntity<>(allAuthors, HttpStatus.OK);
    }

    @GetMapping("/getAuthor/{id}")

    public ResponseEntity<Author> getReview(@PathVariable Long id){
        Author author = authorService.getAuthor(id);
        return new ResponseEntity<>(author, HttpStatus.OK);
    }
    @GetMapping("/getRatting/{id}")

    public ResponseEntity<Integer> getRatting(@PathVariable Long id){
        int rating = authorService.getRatting(id);
        return new ResponseEntity<Integer>(rating, HttpStatus.OK);
    }
}
