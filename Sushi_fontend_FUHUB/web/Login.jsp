<%-- 
    Document   : login
    Created on : Nov 4, 2022, 5:52:43 PM
    Author     : NgocHao
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login Page</title>
        <link href="css/login.css" rel="stylesheet" type="text/css"/>
    </head>
    <body>
        <section>
            <div class="img-bg">
                <img src="https://niemvuilaptrinh.ams3.cdn.digitaloceanspaces.com/tao_trang_dang_nhap/hinh_anh_minh_hoa.jpg"
                     alt="Hình Ảnh Minh Họa">
            </div>
            <div class="noi-dung">
                <div class="form">
                    <h2> Welcome Login  Account </h2>
                    <form action="MainController" method="POST">
                        <div class="input-form">
                            <span>Input the User Name</span>
                            <input type="text" name="txtUser" value="" required="" />
                        </div>
                        <div class="input-form">
                            <span>Input the password</span>
                            <input type="password" name="txtPassword" value="" required=""/>
                        </div>                       
                        <div class="input-form">
                            <input type="submit" value="Login" name="btAction" />
                        </div>
                        <div class="input-form">
                            <input type="reset" value="Reset" />
                        </div>
                        <div class="input-form">
                            <h1  color="red">${requestScope.ERROR_LOGIN}</h1>
                        </div>
                        <div class="input-form">
                            <p>Do you not have an account? <a href="createUser.jsp">Create an account</a></p>
                        </div>
                    </form>                
                </div>
            </div>
        </section>
    </body>
</html>
