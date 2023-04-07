<%@ page import="se.fit.model.Manufacturer" %>
<%@ page import="java.util.List" %>
<%@ page import="se.fit.model.Product" %><%--
  Created by IntelliJ IDEA.
  User: Heartnet
  Date: 4/7/2023
  Time: 11:21 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Update Product</title>
</head>
<body>
<% List<Manufacturer> manufacturers = (List<Manufacturer>) session.getAttribute("manufacturers");
    Product product = (Product) session.getAttribute("product");
%>
<h1>Update Product</h1>

<form action="product?action=update-product" method="post" id="addProduct">
    <input type="text" id="id" name="id" placeholder="Nhap id" value="<%=product.getProductID()%>">
    <input type="text" id="productName" name="productName" placeholder="Nhap ten san pham" value="<%=product.getProductName()%>">
    <input type="text" id="des" name="des" placeholder="Nhap thong tin san pham" value="<%=product.getDescription()%>">
    <select name="manId" >
        <% for (Manufacturer manufacturer : manufacturers) { %>
            <% if(manufacturer.getManID().equals( product.getManufacturer().getManID())) {%>
                    <option value="<%=manufacturer.getManID()%>" selected="selected"><%=manufacturer.getManID()%></option>
                <%} else {%>
                    <option value="<%=manufacturer.getManID()%>" ><%=manufacturer.getManID()%></option>
        <% } %>
        <% } %>
    </select>
    <input type="submit" value="submit">
</form>
</body>
</html>
