package bookapp.wishlist.service;

import bookapp.models.Books;
import bookapp.repositories.BooksRepositories;
import bookapp.user.models.User;
import bookapp.user.repositories.UserRepo;
import bookapp.wishlist.model.Wishlist;
import bookapp.wishlist.repositories.WishlistRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class WishListServiceImpl implements WishListService {

    @Autowired
    private WishlistRepo wishlistRepo;

    @Override
    public Wishlist addToWishlist(User user, Books books) {
        Wishlist wishlistItem = new Wishlist();
        wishlistItem.setUser(user);
        wishlistItem.setBooks(books);
        return wishlistRepo.save(wishlistItem);
    }


    @Override
    public List<Wishlist> getWishLists(Long userId) {
        List<Wishlist> wishLists = wishlistRepo.findByUserId(userId);
        if (!wishLists.isEmpty()) {
            return wishLists.stream().toList();
        }
        return null;
    }
}
