<%-- 
    Document   : login
    Created on : Jan 23, 2024, 8:48:56 PM
    Author     : admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login</title>
        <style>
            body{
                background-color:  rgb(0, 201, 167);
            }
            .tt{
                display: block;
                text-align: start;
                margin-left: 19px;
                margin-top: 5px;
            }
            .ip{
                width: 300px;
                height: 26px;
                background: black;
                margin-top: 10px;
                border: 1px solid white;
                border-radius: 2px; 
                color: white;
            }
            .sm{                     
                margin-top: 30px;         
                margin-bottom: 30px;
                width: 300px;
                height: 30px;              
                color: white;
                border-radius: 3px;
                border-width: 0px;
                background: rgb(0, 201, 167);
            }
            .div{
                border: 1px solid rgb(0, 201, 167);  
                width: 350px;
                background-color: black;
                border-width: 2px;
                
            }
            .form{
              border: 3px solid rgb(0, 201, 167);
            }
            
        </style>
    </head>
    <body>
    <center >
        <div class="div">
            <form class="form" action="login" method="post">
                <h2 style="text-align: center ; display: inline-block; margin-bottom: 10px ;color: white">Login Form</h2>
                <%
                    if(request.getAttribute("ms") != null ){
                        String ms =(String) request.getAttribute("ms");
                        %>
                        <h2 style="color: red"><%=ms %></h2>
                        <%
                    }
                %>
                <div>              
                    <input class="ip" type="text" placeholder="Email Address " name="user" required><br>
                    <input class="ip" style="margin-bottom: 10px" type="password" placeholder="Password" name="pass" required><br> 
                    <span style="color: rgb(0, 201, 167);margin-right: 192px;">Forgot password?</span><br/>
                    <button class="sm" type="submit">Login</button><br/>
                    <div style="margin-bottom: 20px">
                        <span style="color: white ; margin-bottom: 20px">Not a member?</span><span style="color: rgb(0, 201, 167);margin-left: 2px">Signup now</span>
                    </div> 
                </div>
            </form>
        </div>
    </center>
</body>
</html>
