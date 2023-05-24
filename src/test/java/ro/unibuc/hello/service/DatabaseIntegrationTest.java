package ro.unibuc.hello.service;

import org.junit.After;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;
import org.springframework.boot.test.context.SpringBootTest;
import ro.unibuc.hello.data.ProductEntity;
import ro.unibuc.hello.data.ProductRepository;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
public class DatabaseIntegrationTest {

    @Autowired
    private ProductRepository productRepository;

    private ProductEntity testProduct;

    @BeforeEach
    public void setup() {
        productRepository.deleteBySKU("TESTSKU");
        testProduct = new ProductEntity(1, "Test Product", 10, "Test Description",
                "Test Category", 100, "TESTSKU", List.of());
        productRepository.save(testProduct);
    }


    @Test
    public void testFindByNameContaining() {
        List<ProductEntity> products = productRepository.findByNameContaining("Test");
        assertThat(products).hasSize(1);
        assertThat(products.get(0).getSKU()).isEqualTo(testProduct.getSKU());
    }

    @Test
    public void testFindBySKU() {
        ProductEntity product = productRepository.findBySKU("TESTSKU");
        assertThat(product.getSKU()).isEqualTo(testProduct.getSKU());
    }

    @After
    public void removeProduct(){
        productRepository.deleteBySKU(testProduct.getSKU());
    }
}