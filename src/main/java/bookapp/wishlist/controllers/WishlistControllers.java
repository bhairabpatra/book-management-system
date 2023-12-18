package bookapp.wishlist.controllers;

import bookapp.models.Books;
import bookapp.services.BookService;
import bookapp.user.models.User;
import bookapp.user.services.UserService;
import bookapp.wishlist.model.Wishlist;
import bookapp.wishlist.repositories.WishlistRepo;
import bookapp.wishlist.service.WishListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("v1/api/wishlist")
@CrossOrigin("*")
public class WishlistControllers {

    @Autowired
    private WishListService wishListService;
    private UserService userService;
    private BookService bookService;

    @PostMapping("/addWishList/{email}/{bookId}")
    public ResponseEntity<Wishlist> addToWishList(@PathVariable String email, @PathVariable Long bookId){

        User existUser = userService.getUserByID(email);
        System.out.println("existUser" + existUser);
        Books existBooks = bookService.getBookByID(bookId);
        System.out.println("existBooks" + existBooks);
        Wishlist wishlist = wishListService.addToWishlist(existUser,existBooks);
        return new ResponseEntity<>(wishlist, HttpStatus.CREATED);
    }

}
