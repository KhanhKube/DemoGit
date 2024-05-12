<%-- 
    Document   : customer
    Created on : Jan 24, 2024, 11:44:06 AM
    Author     : admin
--%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.List , model.Customer" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Customer Manger</title>
    </head>
    <body>
    <center>
        <h1>Customer Manger</h1>
        <form>
            <input type="text" name="search">
            <input type="submit" value="Search" name="search">
        </form>

        <h3><a href="insert.jsp" style="color: blue">New Customer</a></h3>

        <table border="1px" width="40%">
            <tr>
                <th>ID</th>
                <th>Name</th>
                <th>E-mail</th>
                <th>Address</th>
                <th colspan="2">Action</th>
            </tr>
            <c:forEach items="${requestScope.list}" var="customer">
                <tr>
                    <td>${customer.id}</td>
                    <td>${customer.name}</td>
                    <td>${customer.email}</td>
                    <td>${customer.address}</td>
                    <td>
                        <a href="customer?idEdit=${customer.id}">Edit</a>                        
                    </td>
                    <td>
                        <a href="customer?idDelete=${customer.id}">Delete</a>
                    </td>
      
                </tr>
            </c:forEach>
    </center>
</body>
</html>
