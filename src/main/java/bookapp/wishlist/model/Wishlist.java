package bookapp.wishlist.model;

import bookapp.models.Books;
import bookapp.user.models.User;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "wishlist_tbl")
public class Wishlist {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne
    @JoinColumn(name = "book_id")
    private Books books;
}
