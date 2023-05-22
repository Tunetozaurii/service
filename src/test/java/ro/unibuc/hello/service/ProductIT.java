package ro.unibuc.hello.service;


import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;

import ro.unibuc.hello.controller.ShoppingCartController;
import ro.unibuc.hello.data.ProductEntity;
import ro.unibuc.hello.data.ProductRepository;
import ro.unibuc.hello.data.UserEntity;
import ro.unibuc.hello.data.UserRepository;


import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DataMongoTest
public class ProductIT {
    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private UserRepository userRepository;


    @Autowired
    private ShoppingCartController shoppingCartController;

    @Test
    void testCheckout() {
        ProductEntity product = new ProductEntity();
        product.setName("Test Product");
        product.setQuantity(2);
        product.setDescription("Test Description");
        product.setCategory("Test Category");
        product.setPrice(10);
        product.setSKU("TESTSKU");
        productRepository.save(product);

        UserEntity user = new UserEntity();
        user.setEmail("test@example.com");
        user.setFirstName("John");
        user.setLastName("Doe");
        user.setPassword("password");
        List<ProductEntity> cartItems = new ArrayList<>();
        cartItems.add(product);
        user.setShoppingCart(cartItems);
        userRepository.save(user);

        shoppingCartController.checkout("test@example.com");


        ProductEntity updatedProduct = productRepository.findBySKU("TESTSKU");
        assertEquals(1, updatedProduct.getQuantity());
    }
}