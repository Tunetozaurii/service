package ro.unibuc.hello.dto;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ro.unibuc.hello.data.ProductEntity;
import ro.unibuc.hello.data.ShoppingCart;

import java.util.List;

public class ShoppingCartTest {

    private ShoppingCart shoppingCart;
    private ProductEntity product1;
    private ProductEntity product2;

    @BeforeEach
    void setUp() {
        shoppingCart = new ShoppingCart();
        product1 = new ProductEntity(1, "Product 1", 2, "Description 1", "Category 1", 10, "SKU1", List.of());
        product2 = new ProductEntity(2, "Product 2", 3, "Description 2", "Category 2", 15, "SKU2", List.of());
    }

    @Test
    void testAddProduct() {
        shoppingCart.addProduct(product1);
        shoppingCart.addProduct(product2);

        Assertions.assertEquals(2, shoppingCart.getCartItems().size());
        Assertions.assertTrue(shoppingCart.getCartItems().contains(product1));
        Assertions.assertTrue(shoppingCart.getCartItems().contains(product2));
    }

    @Test
    void testRemoveProduct() {
        shoppingCart.addProduct(product1);
        shoppingCart.addProduct(product2);

        shoppingCart.removeProduct(product1);

        Assertions.assertEquals(1, shoppingCart.getCartItems().size());
        Assertions.assertFalse(shoppingCart.getCartItems().contains(product1));
        Assertions.assertTrue(shoppingCart.getCartItems().contains(product2));
    }

    @Test
    void testGetTotalPrice() {
        shoppingCart.addProduct(product1);
        shoppingCart.addProduct(product2);

        double expectedTotalPrice = product1.getPrice() + product2.getPrice();
        double actualTotalPrice = shoppingCart.getTotalPrice();

        Assertions.assertEquals(expectedTotalPrice, actualTotalPrice);
    }

}
