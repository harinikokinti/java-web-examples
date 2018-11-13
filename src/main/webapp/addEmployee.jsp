<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<html>

<body>
	<form action="AddOrEditEmployee" method="POST">
	
		<c:if test="${not empty requestScope.editEmployee}">
			<c:set var="id" value="${requestScope.editEmployee.empId}" />
			<c:set var="firstName"
				value="${requestScope.editEmployee.firstName}" />
			<c:set var="lastName"
				value="${requestScope.editEmployee.lastName}" />
				
		</c:if>		
		<input type="hidden" name="id" value="${id}"/>  
		<input type="hidden" name="action" value="${param.action}" />   
		First Name: <input type="text" name="first_name" value="${firstName}"/> <br /> 
		Last Name: <input type="text" name="last_name" value="${lastName}"/>
		<input type="submit" value="SUBMIT">
		</br>
		
		<a href="/java-web-examples/employeeHome.html" > GoHome</a>

	</form>

</body>

</html>