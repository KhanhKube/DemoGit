<%-- 
    Document   : update
    Created on : Jan 30, 2024, 1:51:48 PM
    Author     : admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Update Student</title>
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
                margin-left: 20px;
            }
            .back{
                margin-top: 10px;
                margin-left: 170px;
                font-size: 120%;
            }
        </style>
    </head>
    <body>
    <center>
        <h1>Update Student</h1>  
        <c:set var="c" value="${requestScope.update}"/>
        <form action="update" method="post">
            <span class="label"> RollNo</span><input type="text" readonly name="rollNo" value="${c.rollNo}" ><br>
            <span class="label"> Name</span><input type="text" required name="name"  value="${c.name}" ><br>
            <span class="label">Mark</span><input type="text" required name="mark" value="${c.mark}" ><br>
            <a class="back" href="list" >Back</a>
            <input class="btn btn-detail" type="submit" value="Edit" >

        </form> 
    </center>
</body>
</html>
