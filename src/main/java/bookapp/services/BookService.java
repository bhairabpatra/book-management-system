package bookapp.services;

import bookapp.models.Books;

import java.util.List;
import java.util.UUID;


public abstract class BookService {

    public abstract Books create(Books books);

    public abstract  List<Books> getBooks();

    public abstract  Books getBook(UUID id);

    public abstract List<Books> findByAuthor(String publisher);
}
