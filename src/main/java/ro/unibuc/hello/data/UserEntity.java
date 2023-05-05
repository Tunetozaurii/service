
package ro.unibuc.hello.data;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Random;
import java.util.List;
import java.util.ArrayList;
@Document
public class UserEntity {
    @Id
    private long id = new Random().nextInt() & Integer.MAX_VALUE;;
    private String firstName;
    private String lastName;
    @Indexed(unique = true)
    private String email;
    private String name;
    private String password;
    private List<ProductEntity> shoppingCart;


    public UserEntity() {
        shoppingCart = new ArrayList<>();
    }

    public UserEntity(String firstName, String lastName, String email,String password, List<ProductEntity> shoppingCart) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.name = firstName + " " + lastName;
        this.password = password;
        this.shoppingCart = shoppingCart;
    }



    public long getId() {
            return id;
        }

        public void setId(long id) {
            this.id = id;
        }

        public String getFirstName() {
            return firstName;
        }

        public void setFirstName(String firstName) {
            this.firstName = firstName;
        }

        public String getLastName() {
            return lastName;
        }

        public void setLastName(String lastName) {
            this.lastName = lastName;
        }

        public String getEmail() {
            return email;
        }

        public void setEmail(String email) {
            this.email = email;
        }
    public void setPassword(String password) {
        this.password = password;
    }

    public String getPassword() {
        return password;
    }

    public String getName() {
        return name;
    }
    public List<ProductEntity> getShoppingCart() {
        return shoppingCart;
    }


    public void setShoppingCart(List<ProductEntity> shoppingCart) {
        this.shoppingCart = shoppingCart;
    }

    public void addToCart(ProductEntity product) {
        shoppingCart.add(product);
    }

    public void removeFromCart(ProductEntity product) {
        shoppingCart.remove(product);
    }
}


