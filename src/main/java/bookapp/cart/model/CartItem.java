package bookapp.cart.model;

import bookapp.models.Books;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "cart_tbl")
public class CartItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String email;
    @ManyToOne
    @JoinColumn(name = "book_id")
    private Books books;
}
