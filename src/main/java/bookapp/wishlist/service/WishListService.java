package bookapp.wishlist.service;

import bookapp.models.Books;
import bookapp.user.models.User;
import bookapp.wishlist.model.Wishlist;
import jakarta.persistence.Lob;

import java.util.List;
import java.util.UUID;

public interface WishListService {

    public Wishlist addToWishlist(User user, Books books);

     public  List<Wishlist> getWishLists(Long userId);
}
