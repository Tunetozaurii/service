package ro.unibuc.hello.data;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface ProductRepository extends MongoRepository<ProductEntity, String> {
    List<ProductEntity> findByNameContaining(String name);
    List<ProductEntity> findAll();
    ProductEntity findBySKU(String SKU);
    void deleteBySKU(String SKU);
}
