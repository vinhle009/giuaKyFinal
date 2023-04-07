package se.fit.test;


import se.fit.model.Manufacturer;
import se.fit.model.Product;
import se.fit.service.ManufacturerService;
import se.fit.service.ProductService;

public class HelloServlet  {
    public static void main(String[] args) {


            ManufacturerService manufacturerService = new ManufacturerService();
            ProductService productService= new ProductService();
//            Manufacturer manufacturer = new Manufacturer("113","Nha lam","Abc","Abc","Abc","Abc");
//            Product product = new Product("124","Banh trang tron","Banh trang bao ngon");
//            product.setManufacturer(manufacturer);
//
//            System.out.println(manufacturerService.addManufacturer(manufacturer));
//            System.out.println(productService.addProduct(product));

//            manufacturerService.getAllManufacturers().forEach(System.out::println);
//            productService.getAllProducts().forEach(System.out::println);
            System.out.println(productService.getProductById("124"));

    }
}