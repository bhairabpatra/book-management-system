package bookapp.cart.controllers;

import bookapp.cart.model.CartItem;
import bookapp.cart.model.OrderItem;
import bookapp.cart.service.CartService;
import bookapp.models.Books;
import bookapp.services.BookService;
import bookapp.user.models.User;
import bookapp.user.services.UserService;
import io.swagger.v3.oas.annotations.info.License;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@CrossOrigin("*")
@RequestMapping("v1/api/cart")
public class CartController {
    private final UserService userService;
    private final BookService bookService;
    private final CartService cartService;

    public CartController(UserService userService, BookService bookService, CartService cartService) {
        this.userService = userService;
        this.bookService = bookService;
        this.cartService = cartService;
    }

    @PostMapping("addToCart/{email}/{bookId}")
    public CartItem addToCart(@PathVariable String email, @PathVariable Long bookId) {
        User user = userService.getUserByEmail(email);
        Books books = bookService.getBookByID(bookId);
        CartItem cartItem = new CartItem();
        cartItem.setEmail(user.getEmail());
        cartItem.setBooks(books);
        return cartService.addToCart(cartItem);
    }

    @GetMapping("showCart/{email}")
    public List<CartItem> showToCart(@PathVariable String email) {
        User user = userService.getUserByEmail(email);
        if (user != null) {
            return cartService.showCartItems(user.getEmail());
        } else {
            return null;
        }
    }

    @GetMapping("numberOfCartItems")
    public Integer numberOfCartItems() {
        return cartService.numberOfCartItems();
    }

    @DeleteMapping("deleteItem/{bookId}")
    public ResponseEntity<String> deleteFromCart(@PathVariable Long bookId) {
        CartItem cartItem = cartService.isCartItemExist(bookId);
        if (cartItem != null) {
            if (cartService.deleteCartItem(bookId)) {
                return new ResponseEntity<>("Item Deleted successfully", HttpStatus.OK);
            } else {
                return new ResponseEntity<>("Item Deleted failed", HttpStatus.INTERNAL_SERVER_ERROR);
            }
        } else {
            return new ResponseEntity<>("Cart Item not found", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("placeOrders")
    public List<OrderItem> placeOrders(List<OrderItem> orderItems){
            OrderItem orderItem = cartService.placeOrder(orderItems);
            return orderItems;
    }

}
