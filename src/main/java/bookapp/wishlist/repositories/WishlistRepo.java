package bookapp.wishlist.repositories;

import bookapp.wishlist.model.Wishlist;
import jdk.jfr.Registered;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WishlistRepo extends JpaRepository<Wishlist, Long> {
}
