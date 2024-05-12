<%-- 
    Document   : add
    Created on : Jan 29, 2024, 11:07:16 PM
    Author     : admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="model.Student" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Add Student</title>
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
        <h1>ADD Student</h1>
        <h3 style="color: red">${requestScope.err}</h3>
        <form action="add" method="get">
            <span class="label"> RollNo</span><input type="text" required name="rollNo" autofocus><br>
            <span class="label"> Name</span><input type="text" required name="name" ><br>
            <span class="label">Mark</span><input type="text" required name="mark" ><br>
            <a class="back" href="list" >Back</a>
            <input class="btn btn-detail" type="submit" value="Insert" >

        </form> 
    </center>
</body>
</html>
