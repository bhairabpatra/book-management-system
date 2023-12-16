package bookapp.services;

import bookapp.exceptions.NotFoundException;
import bookapp.models.Books;
import bookapp.repositories.BooksRepositories;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class BookServiceImpl extends BookService{

    @Autowired
    private BooksRepositories booksRepositories;
    @Override
    public Books create(Books books ) {
        return booksRepositories.save(books);
    }

    @Override
    public List<Books> getBooks()
    {
        return booksRepositories.findAll();
    }

    @Override
    public Books getBook(UUID id) {
        Optional<Books> books = booksRepositories.findById(id);
        if(!books.isPresent()){
            throw new NotFoundException("The requested resource was not found : " +id);
        }
        return books.get();
    }

    @Override
    public List<Books> findByAuthor(String author) {
        List<Books> books = booksRepositories.findByAuthor(author);
        if(books.isEmpty()){
            throw new NotFoundException("The requested resource was not found : " + author);
        }
        return books;
    }
}
