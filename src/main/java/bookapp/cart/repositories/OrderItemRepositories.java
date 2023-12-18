package bookapp.cart.repositories;

import bookapp.cart.model.OrderItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderItemRepositories extends JpaRepository<OrderItem, Long> {
}
