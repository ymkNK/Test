<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.Date"%>
<%@page import="umsg.Umsg"%>
<%@page import="java.util.ArrayList"%>
<%@page import="dbAccess.DBAccess"%>
<%@page import="java.sql.ResultSet"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta http-equiv="refresh" content="1">
<title>Insert title here</title>
<script type="text/javascript">
</script>
</head>
<body>
<table>
<tr>
<td><div id="d1" style="color:#f00">聊天信息</div></td><td></td><td><div id="d1"style="color:#f00">
<%
Date now = new Date(); //获取当前时间
SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//可以方便地修改日期格式
String utime = dateFormat.format(now); 
out.print("当前时间："+utime);
%></div></td></tr>
<%
ArrayList<Umsg> temp=new DBAccess().Get_all_log();
ArrayList<Umsg> temp2=new ArrayList<Umsg>();
int i=0;
for(Umsg msg:temp)
{
	i++;
	if(temp.size()<20)
	{
		%>
		<tr><td><div style="font-size:10px">用户 <%=msg.getUname()%> 在<%=msg.getUtime() %> 发布了消息:</div></td>
		<td><div style="color:#46A3FF"><%=msg.getUcontent()%></div></td></tr>
		<%
	}
	else 
	{
		if(i>=temp.size()-18)
	{
	%>
	<tr><td><div style="font-size:12px">用户 <%=msg.getUname()%> 在<%=msg.getUtime() %> 发布了消息:</div></td>
	<td><div style="color:#46A3FF"><%=msg.getUcontent()%></div></td></tr>
	<%
	}
	}
}
%>

</table>
</body>
</html>