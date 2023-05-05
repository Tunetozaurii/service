package ro.unibuc.hello.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import ro.unibuc.hello.data.UserEntity;
import ro.unibuc.hello.data.UserRepository;
import ro.unibuc.hello.dto.UserDTO;
import ro.unibuc.hello.exception.EntityNotFoundException;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

public class UserServiceTest {

    @Mock
    UserRepository mockUserRepository;

    @InjectMocks
    UserService userService;

    @BeforeEach
    void init(){
        MockitoAnnotations.initMocks(this);
        when(mockUserRepository.findById(1L)).thenReturn(new UserEntity("John", "Doe", "johndoe@example.com", "password"));
        when(mockUserRepository.findByNameContaining("John")).thenReturn(new ArrayList<>(List.of(new UserEntity("John", "Doe", "johndoe@example.com", "password"))));
    }

    @Test
    public void test_findUserById_returnsUser(){
        // Arrange
        long id = 1L;

        // Act
        UserDTO user = userService.findUserById(id);

        // Assert
        Assertions.assertEquals("John", user.getFirstName());
        Assertions.assertEquals("Doe", user.getLastName());
        Assertions.assertEquals("johndoe@example.com", user.getEmail());
        Assertions.assertEquals("password", user.getPassword());
    }

    @Test
    public void test_findUserById_throwsEntityNotFoundException(){
        // Arrange
        long id = 2L;

        // Act & Assert
        Assertions.assertThrows(EntityNotFoundException.class, () -> userService.findUserById(id));
    }

    @Test
    public void test_createUser_createsUser(){
        // Arrange
        UserDTO userDTO = new UserDTO(1, "John", "Doe", "johndoe@example.com", "password");

        // Act
        boolean result = userService.createUser(userDTO);

        // Assert
        Assertions.assertTrue(result);
        Mockito.verify(mockUserRepository).save(any(UserEntity.class));
    }

    @Test
    public void test_updateUser_updatesUser(){
        // Arrange
        UserDTO userDTO = new UserDTO(1, "Jane", "Doe", "janedoe@example.com", "newpassword");

        // Act
        boolean result = userService.updateUser(userDTO);

        // Assert
        Assertions.assertTrue(result);
        Mockito.verify(mockUserRepository).findById(1L);
        Mockito.verify(mockUserRepository).save(any(UserEntity.class));
    }

    @Test
    public void test_updateUser_throwsEntityNotFoundException(){
        // Arrange
        UserDTO userDTO = new UserDTO(2, "Jane", "Doe", "janedoe@example.com", "newpassword");

        // Act & Assert
        Assertions.assertThrows(EntityNotFoundException.class, () -> userService.updateUser(userDTO));
    }

    @Test
    public void test_deleteUser_deletesUser(){
        // Arrange
        long id = 1L;

        // Act
        boolean result = userService.deleteUser(id);

        // Assert
        Assertions.assertTrue(result);
        Mockito.verify(mockUserRepository).deleteById(1L);
    }


    @Test
    public void test_findUsersByName_returnsListOfUsers(){
        // Arrange
        String name = "John";

        // Act
        List<UserDTO> users = userService.findUsersByName(name);

        // Assert
        Assertions.assertEquals(1, users.size());
        Assertions.assertEquals("John", users.get(0).getFirstName());
        Assertions.assertEquals("Doe", users.get(0).getLastName());
        Assertions.assertEquals("johndoe@example.com", users.get(0).getEmail());
        Assertions.assertEquals("password", users.get(0).getPassword());
    }



    @Test
    public void test_addUser_addsUser(){
        // Arrange
        UserDTO userDTO = new UserDTO(1,"John", "Doe", "johndoe@example.com", "password");

        // Act
        boolean result = userService.addUser(userDTO);

        // Assert
        Assertions.assertTrue(result);
        Mockito.verify(mockUserRepository).save(any(UserEntity.class));
    }

}
