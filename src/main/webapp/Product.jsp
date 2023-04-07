<%@ page import="java.util.List" %>
<%@ page import="se.fit.model.Product" %>
<%@ page import="org.hibernate.sql.Update" %><%--
  Created by IntelliJ IDEA.
  User: Heartnet
  Date: 4/7/2023
  Time: 11:21 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Product</title>
</head>
<body>
    <div>
        <h1>Product</h1>
        <table>
            <tr>
                <th>ID</th>
                <th>Name</th>
                <th>Description</th>
                <th>ManID</th>
                <th></th>
                <th></th>
            </tr>
            <%
                List<Product> list = (List<Product>) session.getAttribute("products");
            %>
            <%
                for (Product product : list) {
            %>
                    <tr>
                        <td><%=product.getProductID()%></td>
                        <td><%=product.getProductName()%></td>
                        <td><%=product.getDescription() %></td>
                        <td><%=product.getManufacturer().getManID()%></td>
                        <td><a href="product?action=update&id=<%=product.getProductID()%>"> Update </a></td>
                        <td><a href="product?action=delete&id=<%=product.getProductID()%>">Delete</a></td>
                    </tr>
            <% } %>

        </table>
        <a href="product?action=add">Add Product</a>
    </div>
</body>
</html>
