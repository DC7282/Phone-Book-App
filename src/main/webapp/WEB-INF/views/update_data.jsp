<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
 <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>update user data</title>
<script src="<c:url value='/resources/JS/Validations.js'/>" type="text/javascript"></script>
<script type="text/javascript">
      alert($("#s").val());
 </script>
</head>
<body>
<jsp:include page="header.jsp"></jsp:include><br><br>
<center>
	<div class="contener">
		<div class="row">
			<div class="col col-form">
				<div class="bg-cont">
					<c:forEach var="c" items="${list}">
					<form class="l-form form" name="frm" action="update.do?userId=${c.getId()}" method="post" onsubmit="return UpdateFormSubmit()">
					
						<input type="text" class="i-control l-control" name="name" value="${c.getName()}" id="name" placeholder="Enter Name" onkeyup="myName()"/><span class="notice-span" id="msgname"></span>
						<input type="text" class="i-control l-control" name="email" value="${c.getEmail()}" id="email" placeholder="Enter Email"  onkeyup="myEmail()"  disabled/><span class="notice-span" id="msgemail"></span>
						<input type="text" class="i-control l-control" name="contact" value="${c.getContact()}" id="contact" placeholder="Enter Contact" onkeyup="myContact()"  disabled/><span class="notice-span" id="msgcont"></span>
						<input type="text" class="i-control l-control" name="username" value="${c.getUsername()}" id="username" placeholder="Enter Username" onkeyup="myUsername()"  disabled/><span class="notice-span" id="msguname"></span>
						<input type="text" class="i-control l-control" name="password" value="${c.getPassword()}" id="password" placeholder="Enter Password" onkeyup="myPassword()"/><span class="notice-span" id="msgpass"></span>
						<input type="text" class="i-control l-control" name="address" value="${c.getAddress()}" id="address" placeholder="Enter Address" onkeyup="myAddress()"/><span class="notice-span" id="msgadd"></span>
					
						<input type="submit" class="submit" value="Update Data" name="s" id="s"/>
					</form>
					</c:forEach>	
				</div>
			</div>
		</div>
	</div>
</center>
</body>
</html>