<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Header</title>
        <link href="<c:url value='/resources/CSS/style.css'/>" rel="stylesheet">
    </head>
    <body>
        <header>
        <div class="dark-bg">
			<div class="container">
				<div class="row">
					<div class="col col-4 textaling col-head">
						<a href="#"><h2>Phone Book Application</h2></a>
					</div>
					<div class="col col-8 col-head">
						<nav>
							<ul>
								<li><a href="home">home</a></li>
								<li><a href="NewContact">New Contact</a></li>
								<li><a href="viewrecords">View Contact</a></li>
								<li><a href="#">Search Contact</a></li>
							</ul>
						</nav>
					</div>
				</div>
			</div>
		</div>
	</header>
    </body>
</html>