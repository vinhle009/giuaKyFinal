<%@ page import="se.fit.model.Manufacturer" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: Heartnet
  Date: 4/7/2023
  Time: 4:18 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Manufacturer</title>
</head>
<body>
<div>
  <h1>Manufacturer</h1>
  <table>
    <tr>
      <th>ID</th>
      <th>Name</th>
      <th>ContactName</th>
      <th>ContactEmail</th>
      <th>ContactPhone</th>
      <th>Website</th>
      <th></th>
      <th></th>
    </tr>
    <%
      List<Manufacturer> list = (List<Manufacturer>) session.getAttribute("manufacturers");
    %>
    <%
      for (Manufacturer manufacturer : list) {
    %>
    <tr>
      <td><%=manufacturer.getManID()%></td>
      <td><%=manufacturer.getManName()%></td>
      <td><%=manufacturer.getManContactName() %></td>
      <td><%=manufacturer.getManContactEmail()%></td>
      <td><%=manufacturer.getManContactPhone()%></td>
      <td><%=manufacturer.getManWebsite()%></td>
      <td><a href="manufacturer?action=update&id=<%=manufacturer.getManID()%>"> Update </a></td>
      <td><a href="manufacturer?action=delete&id=<%=manufacturer.getManID()%>">Delete</a></td>
    </tr>
    <% } %>

  </table>
    <a href="manufacturer?action=add">Add new manufacturer</a>
</div>

</body>
</html>
