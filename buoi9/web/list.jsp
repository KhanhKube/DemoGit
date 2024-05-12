<%-- 
    Document   : list
    Created on : Jan 29, 2024, 10:07:54 PM
    Author     : admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page import="java.util.List , model.Student" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Student</title>
        <style>
            .link{
                display: block;
                text-align: end;
            }
        </style>
    </head>
    <body>
        <a href="login" class="link">Log out</a>
    <center>
        <h1>List Student</h1>
        <h3><a href="add.jsp">Add News</a></h3>
        <table border = "1px" width = "40%">        
            <tr>
                <th>RollNo</th>
                <th>Name</th>
                <th>mark</th>
                <th colspan="2">Action</th>
            </tr>
            <c:forEach items="${requestScope.data}" var="sd">
                <c:set var="rollNo" value="${sd.rollNo}"/>
                <tr>
                    <td>${rollNo}</td>
                    <td>${sd.name}</td>
                    <td>${sd.mark}</td>
                    <td> 
                        <a href="update?rollNoEdit=${rollNo}">Edit</a> &nbsp;&nbsp;
                    </td>
                    <td>
                        <a href="#" onclick="doDelete('${rollNo}')">Delete</a>
                    </td>
                </tr>
            </c:forEach>
        </table>
    </center>
    <script type="text/javascript">
        function doDelete(id) {
            if (confirm("Are you sure you want to delete this student = " + id)) {
                window.location = "delete?rollNoDelete=" + id;
            }
        }
    </script>
</body>
</html>
