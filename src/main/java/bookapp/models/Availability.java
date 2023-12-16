package bookapp.models;


import jakarta.persistence.Embeddable;
import lombok.Data;


@Embeddable
public class Availability {
    private boolean inStock;
    private  int quantity;

    public Availability(boolean inStock, int quantity) {
        this.inStock = inStock;
        this.quantity = quantity;
    }

    public Availability() {
    }

    public boolean isInStock() {
        return inStock;
    }

    public void setInStock(boolean inStock) {
        this.inStock = inStock;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
