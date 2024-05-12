<%-- 
    Document   : insert
    Created on : Jan 23, 2024, 10:03:56 PM
    Author     : admin
--%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="java.util.List , model.Customer" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Inserts</title>
        <style>
            a:visited{
                color: blue;
            }

            .label {
                width: 110px;
                display: inline-block;
                margin-bottom: 10px;
            }

            .btn {
                background-image: linear-gradient(#fff, #ccc);
                border: 1px solid #000;
                border-radius: 2px;
            }

            .btn-detail {
                margin-left: 180px;
            }
        </style>
    </head>
    <body>      
    <center>
        <c:if test="${requestScope.idEdit == null}">
            <h1>Insert Customer</h1>
            <form action="customer" method="get">
            </c:if> 
            <c:if test="${requestScope.idEdit != null}">
                <h1>Edit Customer</h1>
                <form action="customer" method="post">
                </c:if>
                <c:if test="${requestScope.idEdit == null}">
                    <span class="label"> ID</span><input type="text" name="id" value="${requestScope.idEdit}"><br>
                </c:if>   
                <c:if test="${requestScope.idEdit != null}">
                    <span class="label"> ID</span><input type="text" name="id" readonly value="${requestScope.idEdit}"><br>
                </c:if>  
                <span class="label"> Name</span><input type="text" name="name" value="${requestScope.nameEdit}"><br>
                <span class="label">E-Mail</span><input type="text" name="email" value="${requestScope.emailEdit}"><br>
                <span class="label">Address</span><input type="text" name="address" value="${requestScope.addressEdit}"><br>  
                <c:if test="${requestScope.idEdit == null}">
                    <input class="btn btn-detail" type="submit" value="Insert" >  
                </c:if>
                <c:if test="${requestScope.idEdit != null}">
                    <input class="btn btn-detail" type="submit" value="Edit" >  
                </c:if>        
            </form> 
    </center>

</body>
</html>
