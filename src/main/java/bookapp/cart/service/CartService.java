package bookapp.cart.service;

import bookapp.cart.model.CartItem;
import bookapp.cart.model.OrderItem;
import org.springframework.stereotype.Service;

import java.util.List;


public interface CartService {


    public CartItem addToCart(CartItem cartItem);

    public List<CartItem> showCartItems(String email);

    public Integer numberOfCartItems();

    public Boolean deleteCartItem(Long bookId);

    public CartItem isCartItemExist(Long cartId);

    public OrderItem placeOrder(List<OrderItem> orderItems);

}
