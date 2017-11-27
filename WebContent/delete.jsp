<%@page import="org.apache.jasper.tagplugins.jstl.core.Param"%>
<%@page import="UserDao.StudentMothod"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>删除</title>
</head>
<script type="text/javascript"></script>
<body>

<jsp:useBean id="sm" class="UserDao.StudentMothod"></jsp:useBean>
<c:set var="id" value="${param.id}"></c:set>
<c:if test="${sm.delete(id)}">
<jsp:forward page="allStudent.jsp"></jsp:forward>
</c:if> 
<c:if test="${!sm.delete(id)}">
<jsp:forward page="allStudent.jsp"></jsp:forward>
</c:if> 	



</body>
</html>