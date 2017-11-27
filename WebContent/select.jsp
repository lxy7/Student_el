<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="Bean.*"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<%request.setCharacterEncoding("utf-8"); %>
<jsp:useBean id="sm" class="UserDao.StudentMothod"></jsp:useBean>
<c:set var="name" value="${param.userName }"></c:set>

<c:out value="${param.userName }"></c:out>

<c:set var="li" value="${sm.selectAll(name) }" scope="session"></c:set>

	<center>
		<font size="5" face="楷体"><b><center>查询结果</center></b></font><br>
		<hr align="center" width="50%" color="green" size="4" />
		<br>
		<table border="1" bordercolor="green" cellspacing="0" width="50%">
			<tr>
				<th>学号</th>
				<th>姓名</th>
				<th>年龄</th>
				<th>性别</th>
				<th>专业</th>
				<th>地址</th>

			</tr>
			<c:forEach var="l" items="${li}">
			<tr>
			  <td>${l.id }</td>
			 <td>${l.name }</td>
			<td>${l.age } </td>
			<td>${l.sex}</td>
			<td>${l.grad }</td>
			<td>${l.address } </td> 
			</tr>
			</c:forEach>
	

			
			

		</table>
		<center>
			<a href="allStudent.jsp">返回首页</a>
		</center>
</body>
</html>