package se.fit.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import se.fit.model.Manufacturer;
import se.fit.service.ManufacturerService;

import java.io.IOException;

@WebServlet(urlPatterns = "/manufacturer")
public class ManController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ManufacturerService manufacturerService = new ManufacturerService();
        String action = req.getParameter("action");
        HttpSession session = req.getSession(true);

        switch (action){
            case "add":
                req.getRequestDispatcher("addManufacturer.jsp").forward(req,resp);
                break;
            case "update":
                String id = req.getParameter("id");
                session.setAttribute("manufacturer" ,manufacturerService.getManufacturerById(id));
                req.getRequestDispatcher("updateManufacturer.jsp").forward(req,resp);
                break;
            case "delete":
                String id1 = req.getParameter("id");
                Manufacturer manufacturer = manufacturerService.getManufacturerById(id1);
                manufacturerService.deleteManufacturer(manufacturer);
                session.setAttribute("manufacturers" ,manufacturerService.getAllManufacturers());
                resp.sendRedirect("manufacturer?action=list");
                break;
            case "list":
                session.setAttribute("manufacturers" ,manufacturerService.getAllManufacturers());
                req.getRequestDispatcher("Manufacturer.jsp").forward(req,resp);
                break;
            default:
                req.getRequestDispatcher("index.jsp").forward(req,resp);
                break;
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        ManufacturerService manufacturerService = new ManufacturerService();
        HttpSession session = req.getSession(true);
        switch (action){
            case "add-manufacturer":
                String id = req.getParameter("id");
                String name = req.getParameter("name");
                String contactName = req.getParameter("contactName");
                String contactMail = req.getParameter("contactMail");
                String contactPhone = req.getParameter("contactPhone");
                String website = req.getParameter("website");

                Manufacturer manufacturer = new Manufacturer(id,name,contactName,contactMail,contactPhone,website);
                manufacturerService.addManufacturer(manufacturer);
                session.setAttribute("manufacturers" ,manufacturerService.getAllManufacturers());
                resp.sendRedirect("manufacturer?action=list");
                break;
            case "update-manufacturer":
                String id1 = req.getParameter("id");
                String name1 = req.getParameter("name");
                String contactName1 = req.getParameter("contactName");
                String contactMail1 = req.getParameter("contactMail");
                String contactPhone1 = req.getParameter("contactPhone");
                String website1 = req.getParameter("website");

                Manufacturer manufacturer1 = new Manufacturer(id1,name1,contactName1,contactMail1,contactPhone1,website1);
                manufacturerService.updateManufacturer(manufacturer1);
                session.setAttribute("manufacturers" ,manufacturerService.getAllManufacturers());
                resp.sendRedirect("manufacturer?action=list");
                break;

        }
    }
}
