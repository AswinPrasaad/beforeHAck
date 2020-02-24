<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
    
      <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
      
     <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form:form method="get">

Welcome user

	<table border="1" cellpadding="5">
			<caption>
				<h2> Registered Peoples</h2>
			</caption>
			<tr>
			<!-- <th>User Id</th> -->
				<th>ID</th>
				<th>Name</th>
				<th>Address</th>
				
				<th>Actions</th>
			</tr>
			<c:if test="${viewList != null}">
			<c:forEach var="obj" items="${viewList}"> 
				<tr>
				<%-- <td><c:out value="${obj.usergetId()}"/></td>  --%>
					<td><c:out value="${obj.userId}"/></td>
					<td><c:out value="${obj.userName}"/></td>
					<td><c:out value="${obj.address}"/></td>
					
					<td><%-- <a href="edit?id=<c:out value='${obj.id}' />">Edit</a> --%>
						<!-- &nbsp;&nbsp;&nbsp;&nbsp; --> <a
						href="delete?id=<c:out value='${obj.userId}' />">Delete</a></td>
				</tr>
			 </c:forEach>
			 </c:if>
			 	<c:if test="${viewById != null}">
			 <tr>
				<%-- <td><c:out value="${obj.user.getId()}"/></td>  --%>
					<td><c:out value="${viewById.userId}"/></td>
					<td><c:out value="${viewById.userName}"/></td>
					<td><c:out value="${viewById.address}"/></td>
					
					<td><%-- <a href="edit?id=<c:out value='${obj.id}' />">Edit</a> --%>
						<!-- &nbsp;&nbsp;&nbsp;&nbsp; --> <a
						href="delete?id=<c:out value='${viewById.userId}' />">Delete</a></td>
						
				</tr>
				</c:if>
		</table>
</form:form>

</body>
</html>