<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
  
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>New Contact</title>

<script src="<c:url value='/resources/JS/Validations.js'/>" type="text/javascript"></script>
</head>
<body>
<jsp:include page="header.jsp"></jsp:include><br><br>
<center>
	<div class="contener">
		<div class="row">
			<div class="col col-form">
				<div class="bg-cont">
					<form class="l-form form" name="frm" action="save" method="post" onsubmit="return formSubmit()">
						<input type="text" class="i-control l-control" name="name" value="" id="name" placeholder="Enter Name" onkeyup="myName()"/><span class="notice-span" id="msgname"></span>
						<input type="text" class="i-control l-control" name="email" value="" id="email" placeholder="Enter Email"  onkeyup="myEmail()"/><span class="notice-span" id="msgemail"></span>
						<input type="text" class="i-control l-control" name="contact" value="" id="contact" placeholder="Enter Contact" onkeyup="myContact()"><span class="notice-span" id="msgcont"></span>
						<input type="text" class="i-control l-control" name="username" value="" id="username" placeholder="Enter Username" onkeyup="myUsername()"><span class="notice-span" id="msguname"></span>
						<input type="text" class="i-control l-control" name="password" value="" id="password" placeholder="Enter Password" onkeyup="myPassword()"><span class="notice-span" id="msgpass"></span>
						<textarea placeholder="Enter Address" id="address" name="address" onkeyup="myAddress()"></textarea><span class="notice-span" id="msgadd"></span>
						<input type="submit" class="submit" value="Add New Contact" name="s">
						${msg}
					</form>
				</div>
			</div>
		</div>
	</div>
</center>
	
</body>
</html>