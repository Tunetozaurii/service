package ro.unibuc.hello.data;


import org.springframework.data.annotation.Id;

import java.util.Random;

public class ProductEntity {
    @Id
    private long id = new Random().nextLong();
    private String name;
    private int quantity;
    private String description;
    private String category;
    private int price;

    public ProductEntity() {
    }

    public ProductEntity(long id, String name, int quantity, String description, String category, int price) {
        this.id = id;
        this.name = name;
        this.quantity = quantity;
        this.description = description;
        this.category = category;
        this.price = price;

    }

    public ProductEntity(int i, String product, int i1, String description, String category) {
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
}
