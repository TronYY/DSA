<%@ page language="java" contentType="text/html; charset=GB2312"
    pageEncoding="GB2312"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>利用递归法在Java Web目录中查找子目录</title>
</head>
<body>
 <form>
	    <table>
          <tr>
            <td>合同编号</td>
            <td><input id="ContrackID" type="text" value=""></input> </td>
            <td>合同标题</td>
            <td><input id="ContrackTitle" type="text" value=""></input> </td>
          </tr>
          <tr>
            <td>从签约日期</td>
            <td><input id="FromSigningDate" type="text" value="" onclick="MyCalendar.SetDate(this)" value="" readonly="readonly" 
                       onclick="MyCalendar.SetDate(this,document.getElementById('date'))" value="" /></input> </td>
            <td>到签约日期</td>
            <td><input id="ToSigningDate" type="text" value="" onclick="MyCalendar.SetDate(this)" value="" readonly="readonly" 
                       onclick="MyCalendar.SetDate(this,document.getElementById('date'))" value="" /></input> </td>
          </tr>
          <tr>
          <td>备注</td>
           <td><input id="Remarks" type="text" value=""></input> </td>
          </tr>
          <tr>
            <td colspan="4">
              <center>
                <input id="subbutton" type="button" value="查询" onclick="finddata()"/>
                <input id="resetbutton" type="reset" value="清空"/>
              </center>
            </td>
          </tr>
        </table>
      </form>
</body>
</html>