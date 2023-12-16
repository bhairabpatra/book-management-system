package bookapp.repositories;

import bookapp.models.Books;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface BooksRepositories extends JpaRepository<Books , UUID> {
    List<Books> findByAuthor(String publisher);
}
