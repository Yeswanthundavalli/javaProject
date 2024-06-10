	<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	    pageEncoding="ISO-8859-1"%>
	<!DOCTYPE html>
	<html>
	<head>
	<meta charset="ISO-8859-1">
	<title>Insert title here</title>
		<!-- <script>
	function addToCart(divId) {
	  var content = document.getElementById(divId).textContent;
	  var xhr = new XMLHttpRequest();
	  xhr.open('POST', 'welcomepage', true);
	  xhr.setRequestHeader('Content-Type', 'application/x-www-form-urlencoded');
	  xhr.send('content=' + encodeURIComponent(content));
	}
		</script> -->
	</head>
	<body>
	<%
	response.setHeader("cache-control","no-cache,no-store,must-revalidate");
	if(session.getAttribute("username")==null){
		response.sendRedirect("Login.jsp");
	}
	%>
	
	welcome to jsp file
	
	<div class="cDiv1" id="div1">
	  one
	  <button onclick="addToCart('div1')">cart</button>
	</div>
	<div class="cDiv2" id="div2">
	  two
	  <button onclick="addToCart('div2')">cart</button>
	</div>
	
	<form action="Logout">
	<input type="submit" value="logout">
	</form>
	</body>
	</html>
