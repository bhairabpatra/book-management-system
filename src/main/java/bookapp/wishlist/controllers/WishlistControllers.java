package bookapp.wishlist.controllers;

import bookapp.models.Books;
import bookapp.services.BookService;
import bookapp.user.models.User;
import bookapp.user.services.UserService;
import bookapp.wishlist.model.Wishlist;
import bookapp.wishlist.service.WishListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("v1/api/wishlist")
@CrossOrigin("*")
public class WishlistControllers {

    private final WishListService wishListService;
    private final UserService userService;
    private final BookService bookService;

    @Autowired
    public WishlistControllers(WishListService wishListService, UserService userService, BookService bookService) {
        this.wishListService = wishListService;
        this.userService = userService;
        this.bookService = bookService;
    }

    @PostMapping("/add-wishlist/{email}/{bookId}")
    public ResponseEntity<Wishlist> addToWishList(@PathVariable String email, @PathVariable Long bookId) {
        Wishlist wishlist = wishListService.addToWishlist(getUserByEmail(email), getBookByID(bookId));
        return new ResponseEntity<>(wishlist, HttpStatus.CREATED);
    }


    @GetMapping("/get-wish-list/{id}")
    public ResponseEntity<List<Wishlist>> getWishlist(@PathVariable Long id) {
        User user = userService.getUserById(id);
        if (user != null) {
            List<Wishlist> wishLists = wishListService.getWishLists(id);
            return new ResponseEntity<>(wishLists, HttpStatus.OK);
        } else {
            return null;
        }
    }


    private User getUserByEmail(String email) {
        return userService.getUserByEmail(email);
    }

    private Books getBookByID(Long bookId) {
        return bookService.getBookByID(bookId);
    }
}
