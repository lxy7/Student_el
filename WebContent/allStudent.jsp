<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>欢迎${ud.name}登录</title>
</head>
<script>
function addStu()
{
	
		window.location.href="add.jsp";  
}
function search()
{
	var userName= document.myForm.userName.value;
	window.location.href="select.jsp?userName="+userName;  
	}
	
function go()
{
	var a = document.getElementById("page").value;
	window.location.href="allStudent.jsp?currentpage="+a; 
}
</script>
<body>
<jsp:useBean id="sd" class="UserDao.StudentDo"></jsp:useBean>
<jsp:useBean id="sm" class="UserDao.StudentMothod"></jsp:useBean>
<c:set var="sum" value="${sd.getCount() }"></c:set>
<c:out value="${sum }"></c:out>
<c:set var="pagenum" value="5"></c:set>
<c:set var="currentpage" value="1"></c:set>

<c:if test="${sum%pagenum==0 }">
<c:set var="pagecont" value="${sum/pagenum }"></c:set>
</c:if>
<c:if test="${sum%pagenum!=0 }">
<c:set var="pagecont" value="${sum/pagenum+1 }"></c:set>
</c:if>
<c:out value="${pagecont }"></c:out>
<c:if test="${ empty param.currentpage }">
wuwu
</c:if>
<c:if test="${! empty param.currentpage  }">
haha
<c:set var="currentpage" value="${param.currentpage }"></c:set>
</c:if>

<c:set var="li" value="${sd.getPage(currentpage, pagenum) }"></c:set>
<c:out value="${currentpage}"></c:out>
<center>
<form name="myForm">
			学生信息管理<br>
			<table border="1" bordercolor="green" cellspacing="0" width="80%">
				<tr>
					<td>学生姓名：<input type="text" size="12" value="1" maxlength="12"
						name="userName"> <input type="button" value="查询"
						onclick="search();"><br>
					</td>
					<td><input type="button" value="新增" onclick="addStu();"></td>
				</tr>
			</table>
			<table border="1" bordercolor="green" cellspacing="0" width="80%">
				<tr>
					<th>学号</th>
					<th>姓名</th>
					<th>年龄</th>
					<th>性别</th>
					<th>专业</th>
					<th>地址</th>
					<th>操作</th>
				</tr>
				<c:forEach var="l" items="${li}">
			<tr>
			  <td>${l.id }</td>
			 <td>${l.name }</td>
			<td>${l.age } </td>
			<td>${l.sex}</td>
			<td>${l.grad }</td>
			<td>${l.address } </td> 
			<td><a href="delete.jsp?id=${l.id}">删除</a> &nbsp <a
						href="update.jsp?id=${l.id}">修改</a></td>
			</tr>
			</c:forEach>
			</table>
		</form>
		<br>
	共${sum }条记录 当前第${currentpage } 页
	 <a href="allStudent.jsp?currentpage=1">首页</a>

		<c:if test="${currentpage>1 }">
		<a href="allStudent.jsp?currentpage=${currentpage-1 }">上一页</a>
		</c:if>
		
		<c:if test="${currentpage le pagecont  }">
		
		<a href="allStudent.jsp?currentpage=${currentpage+1 }">下一页</a>
		
		</c:if>

		<c:if test="${currentpage <= pagecont  }">
		
		<a href="allStudent.jsp?currentpage=1"></a>
		
		</c:if>
		<a href="allStudent.jsp?currentpage=5">尾页</a> 
		<input type="text" name="currentPage" id="page" size="1" maxlength="3"
			value="${currentpage}"> 
		<input type="button" value="GO"onclick="go()"> 
</center>
	
</body>
</html>