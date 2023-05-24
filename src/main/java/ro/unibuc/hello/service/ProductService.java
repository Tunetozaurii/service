package ro.unibuc.hello.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ro.unibuc.hello.data.ProductEntity;
import ro.unibuc.hello.data.ProductRepository;
import ro.unibuc.hello.dto.ProductDTO;
import ro.unibuc.hello.dto.ReviewDTO;
import ro.unibuc.hello.exception.EntityNotFoundException;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Optional;

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

    public ProductDTO findProductBySKU(String SKU){

        ProductEntity productEntity = productRepository.findBySKU(SKU);
        if(productEntity == null){
            throw new EntityNotFoundException("Cant find product");
        }

        return ProductDTO.transformFromEntity(productEntity);

    }


    public boolean uploadProduct(ProductDTO productDTO){
        try{
            productRepository.save(new ProductEntity(new Random().nextLong() & Integer.MAX_VALUE, productDTO.getName(), productDTO.getQuantity(), productDTO.getDescription(), productDTO.getCategory(), productDTO.getPrice(), productDTO.getSKU()));
        }catch(Exception e){
            System.out.println(e);
            return false;
        }
        return true;
    }
    public ProductEntity findProductBySku(String SKU) {
        return productRepository.findBySKU(SKU);
    }

    public boolean addProductReview(String sku, ReviewDTO reviewDTO) {
        ProductEntity productEntity = productRepository.findBySKU(sku);
            // Assuming the product has a list of reviews
            List<ReviewDTO> reviews = productEntity.getReviews();
            if (reviews == null) {
                reviews = new ArrayList<>();
            }
            reviews.add(reviewDTO);
            productEntity.setReviews(reviews);
            productRepository.save(productEntity);
            return true;

    }


    public List<ProductDTO> findAllProducts(){
        List<ProductEntity> productEntities =  productRepository.findAll();
        if(productEntities == null){
            throw new EntityNotFoundException("Cant find products");
        }
        List<ProductDTO> products = new ArrayList<>();
        for (ProductEntity productEntity : productEntities) {
            products.add(new ProductDTO(productEntity.getId(), productEntity.getName(), productEntity.getQuantity(), productEntity.getDescription(), productEntity.getCategory(), productEntity.getPrice(), productEntity.getSKU()));
        }


        return products;
    }

    public void updateProductQuantity(String SKU, int quantity) {
        ProductEntity productEntity= productRepository.findBySKU(SKU);
        productEntity.setQuantity(productEntity.getQuantity()-quantity);
        productRepository.save(productEntity);

    }
    public boolean doesProductExist(Long productId)
    {
        String productIdString = String.valueOf(productId);
        ProductEntity productEntity = productRepository.findBySKU(productIdString);
        return productEntity != null;
    }

}
