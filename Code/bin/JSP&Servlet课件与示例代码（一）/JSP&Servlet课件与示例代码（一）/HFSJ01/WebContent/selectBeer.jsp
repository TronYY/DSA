<%@ page language="java" contentType="text/html; charset=gb2312"
	pageEncoding="gb2312"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312">
<title>Select Beer</title>
</head>
<h1 align="center">Beer Selection Page</h1>
<form method="post" action="SelectBeer.do">
	Select beer characteristics
	<p>
		Color: <select name="color" size="1">
			<option value=”light”>light</option>
			<option value=”amber”>amber</option>
			<option value=”brown”>brown</option>
			<option value=”dark”>dark</option>
		</select> <br>
		<br>
	<center>
		<input type="submit" name="submit" value="submit">
	</center>
</form>

</html>