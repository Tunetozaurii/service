package ro.unibuc.hello.dto;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ro.unibuc.hello.data.UserEntity;

public class UserTest {

    UserEntity userEntity = new UserEntity("Vlad", "Bogdan", "vladbogdan@example.com", "password");
    UserDTO myUser = UserDTO.transformFromEntity(userEntity);


    @Test
    void test_firstName(){
        Assertions.assertEquals("Vlad", myUser.getFirstName());
    }

    @Test
    void test_lastName(){
        Assertions.assertEquals("Bogdan", myUser.getLastName());
    }

    @Test
    void test_email(){
        Assertions.assertEquals("vladbogdan@example.com", myUser.getEmail());
    }

    @Test
    void test_password(){
        Assertions.assertEquals("password", myUser.getPassword());
    }
}
