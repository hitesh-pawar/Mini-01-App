<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<script>
	function deleteConfirm(){
		return confirm("Are you sure, you want to confirm ?");
	}
</script>
</head>
<body>
	
	<h1>View Contact here</h1>

	<p><font color="green">${delSucc}</font></p>
	
	<a href="/">+Add New Contact </a>
	<table border="1">
		<tr>
			<td>Contact Name</td>
			<td>Contact Email</td>
			<td>Contact Number</td>
			<td>Action</td>
		</tr>
		<c:forEach items="${contacts}" var="contact">
			<tr>
				<td>${contact.contactName}</td>
				<td>${contact.contactEmail}</td>
				<td>${contact.contactNum}</td>
				<td>
					<a href="editContact?cid=${contact.contactId}">Edit</a>
					<a href="deleteContact?cid=${contact.contactId}" onclick="return deleteConfirm()">Delete</a>
				</td>
			</tr>
		</c:forEach>
	</table>

</body>
</html>