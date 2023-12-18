package bookapp.cart.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "order_tbl")
public class OrderItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    private CartItem cartItem;
    private int quantity;
}
