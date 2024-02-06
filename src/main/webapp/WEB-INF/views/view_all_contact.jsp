<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
 <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>View All Contacts</title> 
<script src="<c:url value='/resources/JS/Validations.js'/>" type="text/javascript"></script>
<script src="https://kit.fontawesome.com/8d3850c5fe.js" crossorigin="anonymous"></script>
<style type="text/css">

</style>
</head>
<body>
<jsp:include page="header.jsp"></jsp:include>
<br><br> 
<input type="text" class="search" name="search" value="" id="search" placeholder="Search" onkeyup="searchData(this.value)"/>
<br><br> 
<div class="contener">
	<div class="row">
		<div class="col">
			<div class="usersearch" id="table">
				<table>
					<tr><th>Sr. No</th><th>Name</th><th>Email</th><th>Contact</th><th>UserName</th><!-- <th>Password</th> --><th>Address</th><th>Delete</th><th>Update</th></tr>
					<c:forEach var="c" items="${list}">
						<tr>
						<input type="hidden"value="${c.getId()}"/>
							<td>${count=count+1}</td>
							<td>${c.getName()}</td>
							<td>${c.getEmail()}</td>
							<td>${c.getContact()}</td>
							<td>${c.getUsername()}</td>
							<!-- <td>${c.getPassword()}</td> -->
							<td>${c.getAddress()}</td>
							<td><a href="delete.do?id=${c.getId()}" class="delete" ><i class="fa-regular fa-trash-can"></i>&nbsp Delete</a></td>
							<td><a href="updatedataid.do?id=${c.getId()}" class="update"><i class="fa-solid fa-pen-to-square"></i>&nbsp Update</a></td>
						</tr>
					</c:forEach>
				</table>
				${deletedata}
			 </div>
		 </div>
	 </div>
 </div>

</body>
</html>