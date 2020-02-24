<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
     <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form:form  action ="welcome" method="get" modelAttribute="summa">
<table>
<tr><td>Enter the userName</td><td><input type="text" name="userName" ></td></tr>
<tr><td>Enter the password</td><td><input type="password" name="password" ></td></tr>
<tr><td><input type="reset" value="Reset" class="btn btn-primary"></td><td><input type="submit"  class="btn btn-primary" value="Submit"></td></tr>
</table>
</form:form>
</body>
</html>