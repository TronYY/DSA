<%@ page language="java" contentType="text/html; charset=GB2312"
    pageEncoding="GB2312"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>ÀûÓÃµÝ¹é·¨ÔÚJava WebÄ¿Â¼ÖÐ²éÕÒ×ÓÄ¿Â¼</title>
</head>
<body>
 <form>
	    <table>
          <tr>
            <td>ºÏÍ¬±àºÅ</td>
            <td><input id="ContrackID" type="text" value=""></input> </td>
            <td>ºÏÍ¬±êÌâ</td>
            <td><input id="ContrackTitle" type="text" value=""></input> </td>
          </tr>
          <tr>
            <td>´ÓÇ©Ô¼ÈÕÆÚ</td>
            <td><input id="FromSigningDate" type="text" value="" onclick="MyCalendar.SetDate(this)" value="" readonly="readonly" 
                       onclick="MyCalendar.SetDate(this,document.getElementById('date'))" value="" /></input> </td>
            <td>µ½Ç©Ô¼ÈÕÆÚ</td>
            <td><input id="ToSigningDate" type="text" value="" onclick="MyCalendar.SetDate(this)" value="" readonly="readonly" 
                       onclick="MyCalendar.SetDate(this,document.getElementById('date'))" value="" /></input> </td>
          </tr>
          <tr>
          <td>±¸×¢</td>
           <td><input id="Remarks" type="text" value=""></input> </td>
          </tr>
          <tr>
            <td colspan="4">
              <center>
                <input id="subbutton" type="button" value="²éÑ¯" onclick="finddata()"/>
                <input id="resetbutton" type="reset" value="Çå¿Õ"/>
              </center>
            </td>
          </tr>
        </table>
      </form>
</body>
</html>