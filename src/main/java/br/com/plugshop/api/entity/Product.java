package br.com.plugshop.api.entity;

import javax.persistence.*;

@Entity
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(nullable = false,length = 150)
    private String name;

    @Column(nullable = false,length = 9)
    private Double price;

    @Column(nullable = false)
    private String description;

    @Column(nullable = false,length = 9)
    private long quantity;

    @Column(nullable = false)
    private String size;

    @Column(nullable = false)
    private String imgUrl;

    @Column(nullable = false)
    private int type;

    @Column(nullable = false)
    private String characteristics;

    @Column
    private String tags;

    public String productList() {
        return "Product{" +
                "name='" + name + '\'' +
                ", price=" + price +
                ", description='" + description + '\'' +
                ", imgUrl='" + imgUrl + '\'' +
                '}';
    }

    public String getTags() {
        return tags;
    }

    public void setTags(String tags) {
        this.tags = tags;
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public long getQuantity() {
        return quantity;
    }

    public void setQuantity(long quantity) {
        this.quantity = quantity;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public String getCharacteristics() {
        return characteristics;
    }

    public void setCharacteristics(String characteristics) {
        this.characteristics = characteristics;
    }
}
