package ro.unibuc.hello.service;


import org.junit.Assert;
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
    public class ProductEntityTest {

        @org.junit.Test
        @Test
        public void testProductEntity() {
            // Creare obiect ProductEntity
            long id = 1L;
            String name = "Product";
            int quantity = 10;
            String description = "Product description";
            String category = "Category";
            int price = 100;
            String sku = "SKU123";
            ProductEntity productEntity = new ProductEntity(id, name, quantity, description, category, price, sku);

            // Verificare valorile atributelor
            Assert.assertEquals(id, productEntity.getId());
            Assert.assertEquals(name, productEntity.getName());
            Assert.assertEquals(quantity, productEntity.getQuantity());
            Assert.assertEquals(description, productEntity.getDescription());
            Assert.assertEquals(category, productEntity.getCategory());
            Assert.assertEquals(price, productEntity.getPrice());
            Assert.assertEquals(sku, productEntity.getSKU());
        }
    }
}