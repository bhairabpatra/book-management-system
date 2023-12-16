package bookapp.bookauthor.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.lang.annotation.Target;

@Entity
@Table(name = "review_tbl")
@Data
public class Review {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private int rating;
    private String comment;
}
