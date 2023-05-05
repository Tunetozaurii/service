package ro.unibuc.hello.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ro.unibuc.hello.data.ProductEntity;
import ro.unibuc.hello.data.ProductRepository;
import ro.unibuc.hello.dto.ProductDTO;
import ro.unibuc.hello.exception.EntityNotFoundException;

import java.util.ArrayList;
import java.util.List;

@Component
public class ProductService {
    @Autowired
    ProductRepository productRepository;

    public ProductService() {
    }

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public List<ProductDTO> findProductsByName(String name){
        List<ProductEntity> productEntities =  productRepository.findByNameContaining(name);
        System.out.println(productEntities);
        if(productEntities == null){
            throw new EntityNotFoundException("Cant find products");
        }
        List<ProductDTO> products = new ArrayList<>();
        for (ProductEntity productEntity : productEntities) {

            products.add(ProductDTO.transformFromEntity(productEntity));
        }

        return products;
    }

    public boolean uploadProduct(ProductDTO productDTO){
        try{
            productRepository.save(new ProductEntity(productDTO.getId(), productDTO.getName(), productDTO.getQuantity(), productDTO.getDescription(), productDTO.getCategory(), productDTO.getPrice()));
        }catch(Exception e){
            System.out.println(e);
            return false;
        }
        return true;
    }

    public List<ProductDTO> findAllProducts(){
        List<ProductEntity> productEntities =  productRepository.findAll();
        if(productEntities == null){
            throw new EntityNotFoundException("Cant find products");
        }
        List<ProductDTO> products = new ArrayList<>();
        for (ProductEntity productEntity : productEntities) {

            products.add(new ProductDTO(productEntity.getId(), productEntity.getName(), productEntity.getQuantity(), productEntity.getDescription(), productEntity.getCategory(), productEntity.getPrice()));
        }

        return products;
    }

    public void updateProductQuantity(String name, int quantity) {
    }
}
