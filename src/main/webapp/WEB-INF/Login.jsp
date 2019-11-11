<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transactional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>Login App</title>
	</head>
	<body>
		<div>
			<form action="Login" method="post">
				<p>Username
				<br><input type="text" placeholder="username" name="username"/>
				<p>Password
				<br><input type="password" placeholder="password" name="password"/>
				<p><input type="submit" value="Bejelentkezes">
				<p><a href="addUser">Regisztracio</a>
			</form>
		</div>
	</body>
</html>