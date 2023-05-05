package ro.unibuc.hello.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import ro.unibuc.hello.data.ProductEntity;
import ro.unibuc.hello.dto.ProductDTO;
import ro.unibuc.hello.dto.UserDTO;
import ro.unibuc.hello.service.ProductService;
import ro.unibuc.hello.data.ShoppingCart;
import ro.unibuc.hello.service.UserService;

import java.util.List;

@Controller
public class ShoppingCartController {

    @Autowired
    private UserService userService;

    @Autowired
    private ProductService productService;

    @Autowired
    private ShoppingCart shoppingCart;

    @PostMapping("/{email}/addToCart")
    @ResponseBody
    public String addToCart(@PathVariable String email, @RequestBody String productName) {
        UserDTO userDTO = userService.findUserByEmail(email);
        if (userDTO == null) {
            return "User not found";
        }
        System.out.println(productName);
        ProductDTO productDTO = productService.findProductsByName(productName).get(0);
        ProductEntity productEntity =  new ProductEntity(productDTO.getId(), productDTO.getName(), productDTO.getQuantity(), productDTO.getDescription(), productDTO.getCategory(), productDTO.getPrice());
        if (productEntity == null) {
            return "Product not found";
        }
        userDTO.addToCart(productEntity);
        userService.updateUser(userDTO);
        shoppingCart.addProduct(productEntity);
        return "Product added to cart";
    }

    @PostMapping("/{email}/removeFromCart")
    @ResponseBody
    public String removeFromCart(@PathVariable String email, @RequestBody ProductDTO productDTO) {
        UserDTO userDTO = userService.findUserByEmail(email);
        if (userDTO == null) {
            return "User not found";
        }
        ProductEntity productEntity = (ProductEntity) productService.findProductsByName(productDTO.getName());
        if (productEntity == null) {
            return "Product not found";
        }
        userDTO.removeFromCart(productEntity);
        userService.updateUser(userDTO);
        shoppingCart.removeProduct(productEntity);
        return "Product removed from cart";
    }

    @GetMapping("/{email}/cart")
    @ResponseBody
    public List<ProductEntity> getCartItems(@PathVariable String email) {
        UserDTO userDTO = userService.findUserByEmail(email);
        if (userDTO == null) {
            return null;
        }
        List<ProductEntity> cartItems = shoppingCart.getCartItems();
        return cartItems;
    }

//    @GetMapping("/{email}/cart/total")
//    @ResponseBody
//    public double getTotalPrice(@PathVariable String email) {
//        UserDTO userDTO = userService.findUserByEmail(email);
//        if (userDTO == null) {
//            return 0;
//        }
//        List<ProductEntity> cartItems = userDTO.getCartItems();
//        double totalPrice = 0;
//        for (ProductEntity product : cartItems) {
//            totalPrice += product.getPrice();
//        }
//        return totalPrice;
//    }

//    @PostMapping("/{email}/cart/checkout")
//    @ResponseBody
//    public String checkout(@PathVariable String email) {
//        UserDTO userDTO = userService.findUserByEmail(email);
//        if (userDTO == null) {
//            return "User not found";
//        }
//        List<ProductEntity> cartItems = userDTO.getCartItems();
//        for (ProductEntity product : cartItems) {
//            productService.updateProductQuantity(product.getName(), product.getQuantity());
//        }
//        userDTO.clearCart();
//        userService.updateUser(userDTO);
//        shoppingCart.checkout();
//        return "Checkout successful";
//    }
}
