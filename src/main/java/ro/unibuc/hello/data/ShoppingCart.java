
package ro.unibuc.hello.data;

import org.springframework.stereotype.Component;
import ro.unibuc.hello.data.ProductEntity;

import java.util.ArrayList;
import java.util.List;

@Component
public class ShoppingCart {
    private List<ProductEntity> cartItems;

    public ShoppingCart() {
        cartItems = new ArrayList<>();
    }

    public void addProduct(ProductEntity product) {
        cartItems.add(product);
    }

    public void removeProduct(ProductEntity product) {
        cartItems.remove(product);
    }

    public double getTotalPrice() {
        double totalPrice = 0;
        for (ProductEntity product : cartItems) {
            totalPrice += product.getPrice();
        }
        return totalPrice;
    }

    public List<ProductEntity> getCartItems() {
        return cartItems;
    }
}
