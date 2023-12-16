package bookapp.bookauthor.service;

import bookapp.bookauthor.entity.Author;

import java.util.List;

public interface AuthorService {

    public Author createAUthor(Author author);

    public List<Author> getAuthors();
    public Author getAuthor(Long id);
    public int getRatting(Long id);
}
