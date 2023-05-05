package ro.unibuc.hello.dto;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ro.unibuc.hello.data.ProductEntity;

public class ProductTest {

    ProductEntity productEntity = new ProductEntity(1, "Product", 1, "Description", "Category", 10, "SKU1");
    ProductDTO myProduct = ProductDTO.transformFromEntity(productEntity);

    @Test
    void test_id(){
        Assertions.assertSame(1L, myProduct.getId());
    }
    @Test
    void test_name(){
        Assertions.assertEquals("Product", myProduct.getName());
    }
   @Test
    void test_quantity(){
        Assertions.assertEquals(1, myProduct.getQuantity());
    }

    @Test
    void test_description(){
        Assertions.assertEquals("Description", myProduct.getDescription());
    }

    @Test
    void test_category(){
        Assertions.assertEquals("Category", myProduct.getCategory());
    }

    @Test
    void test_price(){
        Assertions.assertEquals(10, myProduct.getPrice());
    }


}
