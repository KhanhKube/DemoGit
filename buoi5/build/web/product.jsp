<%-- 
    Document   : product
    Created on : Jan 17, 2024, 8:44:35 AM
    Author     : admin
--%>
<%@page import="java.util.List , model.Product" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Product</title>
    </head>
    <body>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Product</title>
       
    </head>
    <body>

    <center >
            <c:if test="${requestScope.idEdit == null}"> <!-- insert -->
            <form action="product"  method="get">
                <h1>Insert New Product</h1>    
            </c:if>   
                <c:if test="${requestScope.idEdit != null}"> <!-- edit -->
            <form action="product"  method="post">
               <h1>Edit a Product</h1>  
                </c:if>   
                <table>
                    <tr>
                        <td>Product's ID:</td>
                        <td> <input type="text" name="id" value="${requestScope.idEdit}"  required=""/> </td>
                    </tr>  
                    <tr>
                        <td>Product's Name:</td>
                        <td> <input type="text" name="name" value="${requestScope.nameEdit}" required=""/> </td>
                    </tr>  
                    <tr>
                        <td>Provider:</td>
                        <td> <input type="text" name="provider" value="${requestScope.providerEdit}"  required=""/> </td>
                    </tr>  
                    <tr>
                        <td> Unit's Price:</td>
                        <td> <input type="text" name="price" value="${requestScope.priceEdit}"  required=""/> </td>
                    </tr>                 
                </table>
                    <c:if test="${requestScope.idEdit != null}">
                        <input style="margin-left: 12%" type="submit" value="Edit" name="edit"/>
                    </c:if>       
                    <c:if test="${requestScope.idEdit == null}">
                        <input style="margin-left: 12%" type="submit" value="Insert" name="insert"/>
                    </c:if>                  
                    <input type="reset" value="Reset"/>
            </form>
        <h2 class="h2">List Product</h2>
        <table border="1px">
                <tr>
                    <th>Product's ID</th>
                    <th>Product's Name</th>
                    <th>Provider</th>
                    <th>Unit's Price</th>
                    <th colspan="2"> <a href="" style="color: blue">Insert New</a></th>  
                </tr>
                <c:forEach items="${requestScope.list}" var="product">
                    <tr>
                        <td>${product.id}</td>
                        <td>${product.name}</td>
                        <td>${product.provider}</td>
                        <td>${product.price}</td>
                        <td><a href="product?idEdit=${product.id}" style="color: blue">Edit</a></td>                                 
                        <td><a href="product?idDelete=${product.id}"  style="color: blue">Delete</a></td>
                    </tr>
                </c:forEach>                        
            </table>
            
    </center>
        
    </body>
</body>
</html>
