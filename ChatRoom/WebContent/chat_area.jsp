<%@page import="umsg.Umsg"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.*"%>
<%@page import="dbAccess.DBAccess"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<%String youname= session.getAttribute("uname").toString(); %>
<script type="text/javascript">
function send_msg(){
<%

Umsg msg=new Umsg();//定义一个数据包
msg.setUname(youname);//设置用户名字信息
Date now = new Date(); //获取当前时间
SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//可以方便地修改日期格式
String utime = dateFormat.format(now); 
msg.setUtime(utime);//设置当前时间信息

request.setCharacterEncoding("UTF-8");
response.setCharacterEncoding("UTF-8");
response.setContentType("text/html;charset=UTF-8;pageEncoding=UTF-8");

//String ucontent=request.getParameter("content");

if(request.getParameter("content")!=null){
String ucontent=new String(request.getParameter("content").getBytes("ISO-8859-1"),"UTF-8");
%><p>当前你的昵称为:<%=ucontent%></p><%
msg.setUcontent(ucontent);
DBAccess temp=new DBAccess();
temp.Insert_log(msg);
}
%>
}
</script>
</head>
<body>
<form name="form2" id="form2" action="chat_area.jsp" method="get">
<p>当前你的昵称为:<%=youname%></p>
<input id="content" name="content"  size="15" style="width:650px; height:20px;">
<input type="submit" name="send" id="send" value="发送" onclick="send_msg()" >

</form>
</body>
</html>