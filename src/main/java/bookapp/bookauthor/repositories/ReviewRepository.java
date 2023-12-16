package bookapp.bookauthor.repositories;

import bookapp.bookauthor.entity.Review;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReviewRepository extends JpaRepository<Review, Long> {
    // Add custom queries if needed
}