<%--
  Created by IntelliJ IDEA.
  User: Heartnet
  Date: 4/7/2023
  Time: 10:12 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Add Manufacturer</title>
</head>
<body>
    <h1>Add Manufacturer</h1>

    <form action="manufacturer?action=add-manufacturer" method="post" id="addManufacturer">
        <input type="text" id="id" name="id" placeholder="Nhap id">
        <input type="text" id="name" name="name" placeholder="Nhap ten nha san xuat">
        <input type="text" id="contactName" name="contactName" placeholder="Nhap thong ten lien lac">
        <input type="text" id="contactMail" name="contactMail" placeholder="Nhap thong mail lien lac">
        <input type="text" id="contactPhone" name="contactPhone" placeholder="Nhap thong so dien thoai lien lac">
        <input type="text" id="website" name="website" placeholder="Nhap website nhấn xuat">
        <input type="submit" value="submit">
    </form>
</body>
</html>
