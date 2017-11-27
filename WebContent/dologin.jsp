<%@page import="org.apache.tomcat.util.buf.UDecoder"%>
<%@page import="java.awt.Window"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>


<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>欢迎登录</title>
</head>
<body>
<%-- <jsp:useBean id="user" class="Bean.User" scope="page"></jsp:useBean>
<jsp:setProperty property="name" name="user"/>
<jsp:setProperty property="password" name="user"/> --%>
<jsp:useBean id="ud" class="UserDao.UserDao" scope="session"></jsp:useBean>
<jsp:setProperty property="*" name="ud"/>

<c:out value="${ud.getValid()}"></c:out>
<c:if test="${ud.getValid()}">
<jsp:forward page="allStudent.jsp"></jsp:forward>
</c:if>
<c:if test="${!ud.getValid()}">
<jsp:forward page="loginfailure.jsp"></jsp:forward>
</c:if>
	

</body>
</html>