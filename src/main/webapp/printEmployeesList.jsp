<%@ page import="java.io.*,java.util.*,java.sql.*"%>
<%@ page import="javax.servlet.http.*,javax.servlet.*"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://harini.com/display.tld" prefix="display"%>

<html>
<head>
<title>My First JSP Program</title>
</head>

<body>

	<!-- 
	<display:table data="employees" scope="request">
		<display:column header="Employee Id" value="ID" />
		<display:column header="First Name" value="FIRST_NAME" />
		<display:column header="Last Name" value="LAST_NAME" />
	</display:table> -->

	<table border="1 px" width="25%">
		<tr>
			<th>Actions</th>
			<th>First Name</th>
			<th>Last Name</th>
		</tr>

		<%-- <display:tableBody data="employees" scope="request" /> --%>

		<tbody>
			<c:forEach var="employeeObject" items="${requestScope.employees}">
				<tr>
					<td>
<a href="/java-web-examples/EditEmployeeServlet?action=edit&id=<c:out value="${employeeObject.empId}" /> ">
							<img src="/java-web-examples/images/edit_icon.png"
							alt="no image found" height="20" width="20">
					</a>
					
<a href="/java-web-examples/AddOrEditEmployee?action=delete&id=<c:out value="${employeeObject.empId}" /> ">
							<img src="/java-web-examples/images/delete_icon.png"
							alt="no image found" height="20" width="20">
					</a>
					
					</td>
					<td><c:out value="${employeeObject.firstName}" /></td>
					<td><c:out value="${employeeObject.lastName}" /></td>

				</tr>
			</c:forEach>


		</tbody>

	</table>
	
	<a href = "/java-web-examples/employeeHome.html" > Go Home</a>
</body>

</html>