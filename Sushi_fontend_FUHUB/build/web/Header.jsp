<%-- 
    Document   : Header
    Created on : 26-Dec-2019, 14:44:27
    Author     : Hoan toan hanh phuc 
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link href="css/header.css" rel="stylesheet" type="text/css"/>
    </head>
    <body>
        <div class="header">
            <div class="title">The Sushi Restaurant</div>
            <div class="subtitle">Welcome ${sessionScope.LIST_USER.fullName} to my website</div>
        </div>
        <div class="menu">
            <ul class="nav">
                <li><a href="HomePage.jsp">Home</a></li>
                <li><a href="Menu.jsp">Menu and price list</a></li>
                <li><a href="Location.jsp">Find Us</a></li>
            </ul>
        </div>
    </body>
</html>
