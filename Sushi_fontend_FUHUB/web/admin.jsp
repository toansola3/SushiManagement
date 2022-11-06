<%-- 
    Document   : admin.jsp
    Created on : Nov 4, 2022, 5:49:12 PM
    Author     : NgocHao
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <link rel="icon" href="images/background/admin.jpg"
              type="image/x-icon">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Admin Page</title>
        <link href="css/adminSearch.css" rel="stylesheet" type="text/css"/>
        <link href="css/adminTable.css" rel="stylesheet" type="text/css"/>
    </head>
    <body>
        <c:if test="${LIST_USER==null || LIST_USER.getRoleId() ne 'AD'}">
            <c:redirect url="login.html"/>
        </c:if>
        <div class="headerWC"> 
            <div>Wellcome Admin : ${sessionScope.LIST_USER.fullName}</div>
        </div> 
        <div class="topnav">
            <a class="active" href="HomePage.jsp">Trang chủ</a>          
            <div class="search-container">
                <form action="MainController">
                    <input type="text" placeholder="Tìm kiếm.." name="txtSearch" value="${param.txtSearch}">
                    <button type="submit" value="Search User" name="btAction">Search</button>
                </form>
            </div> 
        </div>
        <div class="container">
            <c:if test="${requestScope.SEARCH_USERS!=null}">
                <table>
                    <thead>
                        <tr>
                            <th>No</th>
                            <th>UserID</th>
                            <th>Full Name</th>
                            <th>Password</th>
                            <th>roleID</th>
                            <th>Status</th>
                            <th>Delete</th>
                            <th>Update</th>
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach var="user" items="${requestScope.SEARCH_USERS}" varStatus="index">
                            <c:url var="urlRewriting" value="MainController">
                                <c:param name="btAction" value="Delete"/>
                                <c:param name="userID" value="${user.getUserID()}"/>
                                <c:param name="txtSearch" value="${param.txtSearch}"/>
                            </c:url>
                            <tr>
                        <form action="MainController">
                            <td>${index.count}</td>
                            <td>${user.getUserID()}
                                <input type="hidden" name="txtUserID" value="${user.getUserID()}" />
                            </td>
                            <td>
                                <input class="form-input" type="text" name="txtName" value="${user.getFullName()}" />
                            </td>
                            <td>${user.getPassword()}</td>
                            <td>${user.getRoleId()}</td>
                            <td>${user.isStatus()}</td>
                            <td> <a href="${urlRewriting}">Delete</a> </td>
                            <td>
                                <input type="hidden" name="txtSearch" value="${param.txtSearch}" />
                                <input type="submit" class="form-input" value="Update" name="btAction" />
                            </td>
                        </form>
                        </tr>
                    </c:forEach>                                   
                    </tbody>
                </table>      
            </c:if>
        </div>
    </body>
</html>
