package bookapp.models;

import bookapp.bookauthor.entity.Review;
import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Entity
@Data
@Table(name = "books")
public class Books {
    @Id
//    @GeneratedValue(generator = "UUID")
//    private UUID bookId;
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String author;
    private String publisher;
    private Double price;
    private  String description;
    private Availability availability;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "book_fid")
    private List<Review> review;

    @CreationTimestamp
    private LocalDateTime createdAt;
    @UpdateTimestamp
    private LocalDateTime updatedAt;
}
