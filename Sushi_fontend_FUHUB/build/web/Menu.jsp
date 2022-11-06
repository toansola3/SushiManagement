<%-- 
    Document   : HomePage
    Created on : 26-Dec-2019, 14:40:59
    Author     : Hoan toan hanh phuc 
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link href="css/menu.css" rel="stylesheet" type="text/css"/>
        <link href="css/style.css" rel="stylesheet" type="text/css"/>
    </head>
    <body>
        <div class="container">
            <jsp:include page="Header.jsp"/>
            <div class="content">
                <div class="left">
                    <div class="menu_title">
                        Menu and Price list
                    </div>
                    <c:if test="${sessionScope.MENU_SUSHI==null}">
                        <c:redirect url="MenuSushiServlet"></c:redirect>
                    </c:if>
                    
                    <c:forEach items="${sessionScope.MENU_SUSHI}" var="menu">
                        <div class="perMenu">
                            <table class="menu_table">
                                <tr>
                                    <td class="row_left">${menu.name}</td>
                                    <td class="row_right">Price</td>
                                </tr>
                                <tr>
                                    <td class="row_left">${menu.shortDes}</td>
                                    <td class="row_right">€${menu.price}</td>
                                </tr>
                            </table> 
                            <p>
                                ${menu.detailDes}
                            </p>
                        </div>
                    </c:forEach>
                    <c:if test="${sessionScope.COUNT_SUSHI==null}">
                        <!-- nếu đặt if này ở dưới from sẽ bị lỗi-->
                        <c:redirect url="MovePageServlet"></c:redirect>
                    </c:if>
                    <div class="paging">
                        <c:forEach begin="1" end="${sessionScope.COUNT_SUSHI}" var="i">
                            <a href="MainController?btAction=MovePage&clickPage=${i}">${i}</a>
                        </c:forEach>
                    </div>
                </div>
                <jsp:include page="Right.jsp"/>
            </div>
            <jsp:include page="Footer.jsp"/>
        </div>
    </body>
</html>
