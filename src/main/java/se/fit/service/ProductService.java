package se.fit.service;

import se.fit.model.Product;
import se.fit.repositories.GenericRepo;

import java.util.List;

public class ProductService {
    private GenericRepo<Product, String> productRepo;

    public ProductService() {
        productRepo = new GenericRepo<>("Product");
    }

    public Product addProduct(Product product) {
        return productRepo.add(product);
    }

    public Product updateProduct(Product product) {
        return productRepo.update(product);
    }

    public boolean deleteProduct(Product product) {
        return productRepo.delete(product, product.getProductID());
    }

    public Product getProductById(String id){
        return productRepo.findById(new Product(), id);
    }

    public List<Product> getAllProducts() {
        return productRepo.findAll();
    }
}
