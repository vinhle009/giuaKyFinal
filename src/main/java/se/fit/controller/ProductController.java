package se.fit.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import se.fit.model.Product;
import se.fit.service.ManufacturerService;
import se.fit.service.ProductService;

import java.io.IOException;

@WebServlet(urlPatterns = "/product")
public class ProductController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ProductService productService = new ProductService();
        ManufacturerService manufacturerService = new ManufacturerService();
        HttpSession session = req.getSession(true);
        String action = req.getParameter("action");

        switch (action){
            case "add":
                session.setAttribute("manufacturers" ,manufacturerService.getAllManufacturers());
                req.getRequestDispatcher("addProduct.jsp").forward(req,resp);
                break;
            case "update":
                String id = req.getParameter("id");
                Product product = productService.getProductById(id);
                session.setAttribute("product" ,product);
                session.setAttribute("manufacturers" ,manufacturerService.getAllManufacturers());
                req.getRequestDispatcher("updateProduct.jsp").forward(req,resp);
                break;
            case "delete":
                String id1 = req.getParameter("id");
                Product product1 = productService.getProductById(id1);
                productService.deleteProduct(product1);
                session.setAttribute("products" ,productService.getAllProducts());
                resp.sendRedirect("product?action=list");
                break;
            case "list":
                session.setAttribute("products" ,productService.getAllProducts());
                req.getRequestDispatcher("Product.jsp").forward(req,resp);
                break;
            default:
                req.getRequestDispatcher("index.jsp").forward(req,resp);
                break;
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
        String action = req.getParameter("action");
        ProductService productService = new ProductService();
        ManufacturerService manufacturerService = new ManufacturerService();
        HttpSession session = req.getSession(true);
        switch (action){
            case "add-product":
                String Id = req.getParameter("id");
                String Name = req.getParameter("productName");
                String Description = req.getParameter("des");
                String ManId = req.getParameter("manId");
                Product product = new Product(Id,Name,Description,manufacturerService.getManufacturerById(ManId));

                if(productService.addProduct(product) != null) {
                    session.setAttribute("products", productService.getAllProducts());
                    resp.sendRedirect("product?action=list");
                }
                break;
            case "update-product":
                String Id1 = req.getParameter("id");
                String Name1 = req.getParameter("productName");
                String Description1 = req.getParameter("des");
                String ManId1 = req.getParameter("manId");
                Product product1 = new Product(Id1,Name1,Description1,manufacturerService.getManufacturerById(ManId1));

                if(productService.updateProduct(product1) != null) {
                    session.setAttribute("products", productService.getAllProducts());
                    resp.sendRedirect("product?action=list");
                }
                break;
        }
    }
}
