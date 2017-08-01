<%@page import="umsg.Umsg"%>
<%@page import="java.util.*"%>
<%@page import="dbAccess.DBAccess"%>
<%@page import="java.sql.ResultSet"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<% if(session.getAttribute("uname")==null)
{
%>
<meta http-equiv="refresh" content="0;url=user_login.html">
<%
}
%>
<%String youname= session.getAttribute("uname").toString(); %>
</head>
<body>
<h2 >所有用户列表</h2>
<table>
<%
ArrayList<Umsg> temp=new DBAccess().Get_all_user();

for(Umsg msg:temp)
{
	if(msg.getUname().equals(youname)){
	
	%>
	<tr><td><div style="color:#f00"><%=msg.getUname()%></div></td><td>(你在这儿~)</td></tr>
	<%
	}
	else
	{
	%>
	<tr><td><%=msg.getUname()%></td></tr>
	<% 
	}
	
}
%>

</table>

</body>
</html>