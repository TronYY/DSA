<%@ page language="java" contentType="text/html; charset=gb2312"
    pageEncoding="gb2312"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>HelloWorld</title>
</head>
<body >
  <form name="loginForm" method="GET" action="HelloServlet">
    <table>
      <tr>
        <td><div align="right">User Name:</div></td>
        <td><input type="text" name="username"></td>
      </tr>
      <tr>
        <td><div align="right">Password:</div></td>
        <td><input type="password" name="password"></td>
      </tr>
      <tr>
        <td><input type="submit" name="submit" value="submit"></td>
        <td><input type="reset" name="reset" value="reset"></td>
      </tr>
    </table>
  </form>
</body>
</html>