package ro.unibuc.hello.dto;

import ro.unibuc.hello.data.ProductEntity;

public class ProductDTO {
    private long id;
    private String name;
    private int quantity;
    private String description;
    private String category;
    private int price;

    public ProductDTO() {
    }

    public ProductDTO(long id, String name, int quantity, String description, String category, int price) {
        this.id = id;
        this.name = name;
        this.quantity = quantity;
        this.description = description;
        this.category = category;
        this.price = price;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getPrice() {
        return price;
    }
    public void setPrice(int price) {this.price = price;}

    public static ProductDTO transformFromEntity(ProductEntity productEntity){
        return new ProductDTO(productEntity.getId(), productEntity.getName(), productEntity.getQuantity(), productEntity.getDescription(), productEntity.getCategory(), productEntity.getPrice());
    }
}
