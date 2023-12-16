package bookapp.bookauthor.repositories;

import bookapp.bookauthor.entity.Author;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthorRepo extends JpaRepository<Author , Long> {
}
