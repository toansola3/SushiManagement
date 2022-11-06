<%-- 
    Document   : SushiDetail
    Created on : 26-Dec-2019, 16:14:45
    Author     : Hoan toan hanh phuc 
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link href="css/style.css" rel="stylesheet" type="text/css"/>
    </head>
    <body>
        <div class="container">
            <jsp:include page="Header.jsp"/>
            <div class="content">
                <div class="left">
                    <div class="sushi">
                        <div class="sushi_title">Intro :${param.txtName}</div>
                        <div class="sushi_detail">
                            <div class="sushi_image">
                                <img src="images/sushi/${param.txtImg}" alt=""/>
                            </div>
                            ${param.txtDetailDes}
                        </div>
                        <div class="sushi_price">
                            Price: ${param.txtPrice} $
                        </div>
                    </div>
                </div>
                <jsp:include page="Right.jsp"/>
            </div>
            <jsp:include page="Footer.jsp"/>
        </div>
    </body>
</html>
