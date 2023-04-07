<%@ page import="se.fit.model.Manufacturer" %><%--
  Created by IntelliJ IDEA.
  User: Heartnet
  Date: 4/7/2023
  Time: 10:12 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Update Manufacturer</title>
</head>
<body>
    <% Manufacturer manufacturer = (Manufacturer) session.getAttribute("manufacturer");%>
    <h1>Update Manufacturer</h1>

    <form action="manufacturer?action=update-manufacturer" method="post" id="updateManufacturer">
        <input type="text" id="id" name="id" placeholder="Nhap id" value="<%=manufacturer.getManID()%>">
        <input type="text" id="name" name="name" placeholder="Nhap ten nha san xuat" value="<%=manufacturer.getManName()%>">
        <input type="text" id="contactName" name="contactName" placeholder="Nhap thong ten lien lac" value="<%=manufacturer.getManContactName()%>">
        <input type="text" id="contactMail" name="contactMail" placeholder="Nhap thong mail lien lac" value="<%=manufacturer.getManContactEmail()%>">
        <input type="text" id="contactPhone" name="contactPhone" placeholder="Nhap thong so dien thoai lien lac" value="<%=manufacturer.getManContactPhone()%>">
        <input type="text" id="website" name="website" placeholder="Nhap ưebsite nhấn xuat" value="<%=manufacturer.getManWebsite()%>">
        <input type="submit" value="submit">
    </form>
</body>
</html>
