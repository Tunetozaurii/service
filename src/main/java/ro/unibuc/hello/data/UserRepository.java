package ro.unibuc.hello.data;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends MongoRepository<UserEntity, String> {
    UserEntity findById(long Id);
    List<UserEntity> findAll();
    List<UserEntity> findByNameContaining(String name);
    void deleteById(long id);
    void deleteByEmail(String email);

    UserEntity findByEmail(String email);
}
