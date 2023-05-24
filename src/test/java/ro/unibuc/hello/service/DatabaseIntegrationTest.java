package ro.unibuc.hello.service;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;
import ro.unibuc.hello.data.ProductEntity;
import ro.unibuc.hello.data.ProductRepository;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@DataMongoTest
public class DatabaseIntegrationTest {

    @Autowired
    private ProductRepository productRepository;

    private ProductEntity testProduct;

    @BeforeEach
    public void setup() {
        testProduct = new ProductEntity(1, "Test Product", 10, "Test Description",
                "Test Category", 100, "TESTSKU", List.of());
        productRepository.save(testProduct);
    }

    @AfterEach
    public void teardown() {
        productRepository.deleteAll();
    }

    @Test
    public void testFindByNameContaining() {
        List<ProductEntity> products = productRepository.findByNameContaining("Test");
        assertThat(products).hasSize(1).contains(testProduct);
    }

    @Test
    public void testFindBySKU() {
        ProductEntity product = productRepository.findBySKU("TESTSKU");
        assertThat(product).isEqualTo(testProduct);
    }
}