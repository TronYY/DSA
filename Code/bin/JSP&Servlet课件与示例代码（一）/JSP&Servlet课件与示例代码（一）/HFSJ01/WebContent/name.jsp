<%@ page language="java" contentType="text/html; charset=gb2312"
    pageEncoding="gb2312"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312">
<title>Post/Get</title>
</head>
<body>
<form method="post" action="AndroidServlet?name=getReq" >
<p>使用get方法提交</p>
name: 
<input name="gname" type="text"  />
<br />
age: 
<input name="gage" type="text"  />
<br />
<!--input type="button" value="get提交"  onclick=" window.location.href='getReq.jsp'"-->
<input type="submit" value="提交"/>
</form>
<form method="post" action="AndroidServlet?name=postReq">
<p>使用post方法提交</p>
name: 
<input name="pname" type="text"  />
<br />
age: 
<input name="page" type="text"  />
<br />
<!--input type="button" value="post提交" onclick =" window.location.href='postReq.jsp'"-->
<input type="submit" value="提交" />
</form>
</body>
</html>