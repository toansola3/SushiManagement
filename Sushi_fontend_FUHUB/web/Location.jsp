<%-- 
    Document   : HomePage
    Created on : 25-Dec-2019, 03:26:19
    /*copyright by fu hub*/
/*link group https://www.facebook.com/groups/498752080529382/*/
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link href="css/location.css" rel="stylesheet" type="text/css"/>
        <link href="css/style.css" rel="stylesheet" type="text/css"/>
    </head>
    <body>
        <div class="container">
            <jsp:include page="Header.jsp"/>
            <div class="content">
                <div class="left">
                    <div class="location_title">
                        Find Sushi World
                    </div>
                    <div class="location">
                        <div class="location_left">
                            <div class="location_header">
                                Address and contact:
                            </div>
                            <p>Sushi World37 Phùng Khắc Khoan, Đa Kao, Quận 1, Thành phố Hồ Chí </p>
                            <p>Tel:123456</p>
                            <p>Email:your-email@your-email.com</p>
                        </div>
                        <div class="location_right">
                            <div class="location_header">
                                Opening hours:
                            </div>
                            <p>Monday: Closed</p>
                            <p>Tuesday - Friday: 10:00 - 20:00</p>
                            <p>Saturday and Sunday: 11.00 - 21:00</p>
                        </div>
                    </div>
                    <div class="map">
                        <iframe src="https://www.google.com/maps/embed?pb=!1m18!1m12!1m3!1d24707.465575703252!2d106.67878041675682!3d10.782267473229005!2m3!1f0!2f0!3f0!3m2!1i1024!2i768!4f13.1!3m3!1m2!1s0x317528b4980b7cb3%3A0xd2b46f5f4bdd7d97!2zbmjDoCBow6BuZyBuaOG6rXQgU3VzaGkgV29ybGQ!5e0!3m2!1svi!2s!4v1667630047012!5m2!1svi!2s" width="600" height="450" style="border:0;" allowfullscreen="" loading="lazy" referrerpolicy="no-referrer-when-downgrade"></iframe>
                    </div>
                </div>
                <jsp:include page="Right.jsp"/>
            </div>
            <jsp:include page="Footer.jsp"/>
        </div>
    </body>
</html>
