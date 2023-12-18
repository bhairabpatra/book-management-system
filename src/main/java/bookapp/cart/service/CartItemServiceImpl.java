package bookapp.cart.service;

import bookapp.cart.model.CartItem;
import bookapp.cart.model.OrderItem;
import bookapp.cart.repositories.CartRepositories;
import bookapp.cart.repositories.OrderItemRepositories;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CartItemServiceImpl implements CartService {

    public int numberOfItems;
    @Autowired
    private CartRepositories cartRepositories;
    private OrderItemRepositories orderItemRepositories;

    @Override
    public CartItem addToCart(CartItem cartItem) {
        return cartRepositories.save(cartItem);
    }

    @Override
    public List<CartItem> showCartItems(String email) {
        List<CartItem> items = cartRepositories.findByEmail(email);
        numberOfItems = items.size();
        System.out.println(numberOfItems);
        return items;
    }

    @Override
    public Integer numberOfCartItems() {
        return numberOfItems;
    }

    @Override
    public Boolean deleteCartItem(Long bookId) {
        cartRepositories.deleteById(bookId);
        return true;
    }

    @Override
    public CartItem isCartItemExist(Long cartId) {
        Optional<CartItem> cartItem = cartRepositories.findById(cartId);
        if(cartItem.isPresent()){
            return  cartItem.get();
        }else {
            return  null;
        }
    }

    @Override
    public OrderItem placeOrder(List<OrderItem> orderItems) {
        // Calculate total amount
//        double totalAmount = orderItems.stream()
//                .mapToDouble(item -> item.getProduct().getPrice() * item.getQuantity())
//                .sum();
        OrderItem orderItem = new OrderItem();
        orderItem.setCartItem(orderItem.getCartItem());
        return orderItemRepositories.save(orderItem);
    }
}
