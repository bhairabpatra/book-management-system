package bookapp.services;

import bookapp.models.Books;
import bookapp.user.models.User;

import java.util.List;
import java.util.UUID;


public abstract class BookService {

    public abstract Books create(Books books);

    public abstract  List<Books> getBooks();

    public abstract  Books getBook(Long id);

    public abstract List<Books> findByAuthor(String publisher);

    public abstract Books getBookByID(Long id);
}
