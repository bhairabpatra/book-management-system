package bookapp.cart.repositories;

import bookapp.cart.model.CartItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CartRepositories extends JpaRepository<CartItem, Long> {
    List<CartItem> findByEmail(String email);

}
