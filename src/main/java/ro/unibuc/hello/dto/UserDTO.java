package ro.unibuc.hello.dto;

import ro.unibuc.hello.data.ProductEntity;

import java.util.ArrayList;
import java.util.List;

public class UserDTO {

    private long id;
    private String firstName;
    private String lastName;
    private String name;
    private String email;
    private String password;
    private List<ProductEntity> shoppingCart;

    public UserDTO(List<ProductEntity> shoppingCart) {
        this.shoppingCart = shoppingCart;
    }

    public UserDTO(long id, String firstName, String lastName, String email, String password, List<ProductEntity> shoppingCart) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
        this.name = firstName + " "+ lastName;
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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
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

    public List<ProductDTO> getCartItems() {
        List<ProductDTO> cartItems = new ArrayList<>();
        for (ProductEntity productEntity : shoppingCart) {

            cartItems.add(ProductDTO.transformFromEntity(productEntity));
        }

        return cartItems;
    }

    public void clearCart() {
    }
}
