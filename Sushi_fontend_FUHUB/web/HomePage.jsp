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
    
        <link rel="icon" href="images/background/user.jpg"
              type="image/x-icon">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>User Page</title>
        <link href="css/style.css" rel="stylesheet" type="text/css"/>
    </head>
    <body>
         <c:if test="${LIST_USER==null }">
            <c:redirect url="login.html"/>
        </c:if>
        <div class="container">
            <jsp:include page="Header.jsp"/>
            <div class="content">
                <div class="left">
                    <div class="image_top">
                        <div class="image_child">
                        </div>
                    </div>
                    <c:if test="${sessionScope.LIST_SUSHI==null}">
                        <c:redirect url="SuShiServlet"></c:redirect>
                    </c:if>
                    
                    <c:forEach var="sushi" items="${sessionScope.LIST_SUSHI}">
                        <div class="list_product">
                            <div class="product_title">
                                ${sushi.getName()}                               
                            </div>
                            <div class="product_image">        
                                <form action="SushiDetail.jsp" method="POST">
                                    <input type="hidden" name="txtImg" value="${sushi.getImage()}" /> 
                                    <input type="hidden" name="txtPrice" value="${sushi.getPrice()}" /> 
                                    <input type="hidden" name="txtName" value="${sushi.getName()} " /> 
                                    <input type="hidden" name="txtDetailDes" value="${sushi.getDetailDes()}" /> 
                                    <img src="images/sushi/${sushi.getImage()}" alt=""/>
                                    <input class="form-input" type="submit" value="View Detail" />
                                </form>
                            </div>
                            ${sushi.getShortDes()}
                        </div>
                    </c:forEach>

                    <div class="paging">
                        
                    </div>
                </div>
                <jsp:include page="Right.jsp"/>
            </div>
            <jsp:include page="Footer.jsp"/>
        </div>
    </body>
</html>
