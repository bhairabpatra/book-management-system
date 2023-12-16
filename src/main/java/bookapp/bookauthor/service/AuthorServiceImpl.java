package bookapp.bookauthor.service;

import bookapp.bookauthor.repositories.AuthorRepo;
import bookapp.bookauthor.entity.Author;
import bookapp.bookauthor.repositories.ReviewRepository;
import bookapp.models.Books;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AuthorServiceImpl implements AuthorService {

    @Autowired
    private AuthorRepo authorRepo;
    private ReviewRepository reviewRepository;
    private int sum;

    @Override
    public Author createAUthor(Author author) {
        return authorRepo.save(author);
    }

    @Override
    public List<Author> getAuthors() {
        return authorRepo.findAll();
    }

    @Override
    public Author getAuthor(Long id) {
        Optional<Author> existAuthor = authorRepo.findById(id);
        if (existAuthor.isPresent()) {
            return existAuthor.get();
        }
        return null;
    }

    @Override
    public int getRatting(Long id) {
        Optional<Author> existAuthor = authorRepo.findById(id);
        sum = 0;
        if (existAuthor.isPresent()) {
            int numberOfReview = existAuthor.get().getReview().size();
            existAuthor.get().getReview().forEach(x -> {
                sum = sum + x.getRating();
            });
            return sum / numberOfReview;
        }
        return 0;
    }
}
