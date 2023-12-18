package bookapp.wishlist.service;

import bookapp.models.Books;
import bookapp.user.models.User;
import bookapp.wishlist.model.Wishlist;

import java.util.UUID;

public interface WishListService {

    public Wishlist addToWishlist(User user, Books books);

}
