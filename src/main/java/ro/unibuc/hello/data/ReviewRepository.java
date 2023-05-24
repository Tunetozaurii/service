package ro.unibuc.hello.data;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReviewRepository extends MongoRepository<ReviewEntity, String> {
    List<ReviewEntity> findByNameContaining(String name);
    List<ReviewEntity> findAll();
}
