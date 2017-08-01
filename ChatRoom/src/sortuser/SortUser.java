package sortuser;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;




import dbAccess.DBAccess;

/**
 * Servlet implementation class SortUser
 */
@WebServlet({ "/SortUser", "/sortuser" })
public class SortUser extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SortUser() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8;pageEncoding=UTF-8");
		HttpSession session=request.getSession();
		if(request.getParameter("code").equals(session.getAttribute("answer").toString()))
		{
			PrintWriter out=response.getWriter();
			String uname=new String(request.getParameter("uname").getBytes("ISO-8859-1"),"UTF-8");
			DBAccess dba=new DBAccess();

			try {
				if(dba.Sort_User(uname)){
					
					if(session.getAttribute("uname")==null){
					out.print("<h1>"+uname+" ����ǳ��Ѿ���ռ��</h1><a href=\"user_login.html\" >����</a>");
					}
					else
					{
						session.setAttribute("uname", uname);
						out.print("<h1>�ٴε�¼�ɹ�����ӭ<div style=\"color:#f00\">"+uname+"</div></h1>");
						out.print("<a href=\"chatFrame.jsp\">ǰ��������</a>");
					
					}
				
				}
				else
				{
					dba.Insert_User(uname);
					
					session.setAttribute("uname", uname);
					
					out.print("<h1>��¼�ɹ�����ӭ<div style=\"color:#f00\">"+uname+"</div></h1>");
					out.print("<a href=\"chatFrame.jsp\">ǰ��������</a>");
				}
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}else
		{
			System.out.println(request.getParameter("code"));
			System.out.println(session.getAttribute("answer"));
			PrintWriter out=response.getWriter();
			out.print("��֤���������,<a href=\"user_login.html\">���ص�¼����</a>");
		}
		
	
	
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
