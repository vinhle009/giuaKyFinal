package se.fit.model;


import jakarta.persistence.*;

@Entity
@Table(name = "Product")
public class Product {
    @Id
    private String productID;
    private String productName;
    private String description;
    @ManyToOne
    @JoinColumn(name = "manID")
    private Manufacturer manID;

    public Product() {
    }

    public Product(String productID, String productName, String description, Manufacturer manufacturer) {
        this.productID = productID;
        this.productName = productName;
        this.description = description;
        this.manID = manufacturer;
    }

    public Product(String productID, String productName, String description) {
        this.productID = productID;
        this.productName = productName;
        this.description = description;
    }

    public String getProductID() {
        return productID;
    }

    public void setProductID(String productID) {
        this.productID = productID;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Manufacturer getManufacturer() {
        return manID;
    }

    public void setManufacturer(Manufacturer manufacturer) {
        this.manID = manufacturer;
    }

    @Override
    public String toString() {
        return "Product{" +
                "productID='" + productID + '\'' +
                ", productName='" + productName + '\'' +
                ", description='" + description + '\'' +
                ", manufacturer=" + manID +
                '}';
    }
}
