package checknick;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLEncoder;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dbAccess.DBAccess;

/**
 * Servlet implementation class CheckNick
 */
@SuppressWarnings("unused")
@WebServlet({ "/CheckNick", "/checknick" })
public class CheckNick extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CheckNick() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
    	String nick = request.getParameter("nick");
		PrintWriter out = response.getWriter();
		
		DBAccess dba=new DBAccess();
		try {
			if(dba.Sort_User(new String(nick.getBytes("ISO-8859-1"),"UTF-8"))){
				out.print("yes");
				//System.out.println(new String(nick.getBytes("ISO-8859-1"),"UTF-8")+"yes");
			}else
			{
				out.print("no");
				//System.out.println(new String(nick.getBytes("ISO-8859-1"),"UTF-8")+"no");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
