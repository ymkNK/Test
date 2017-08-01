package code;

import java.awt.Font;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import java.awt.*;
/**
 * Servlet implementation class Code
 */
@WebServlet({"/Code","/code"})
public class Code extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Code() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("image/jpeg");
		response.addHeader("Cache_Control","no-cache");
		response.addHeader("Pragma","no-cache"); 
		response.addDateHeader("Expires",0); 
		
		BufferedImage img =new BufferedImage(80, 30, BufferedImage.TYPE_INT_RGB);
		java.awt.Graphics g= img.getGraphics();
		Random r = new Random();
		int a=r.nextInt(10);
		int b=r.nextInt(10);
		int answer =a+b;
		HttpSession session=request.getSession();
		session.setAttribute("answer", answer);
		g.setFont(new Font("ËÎÌו",Font.BOLD,24)); 
		g.setColor(new Color(r.nextInt(256), r.nextInt(256), r.nextInt(256)));
		g.drawString(a+"" ,10 , 20);
		g.setColor(new Color(r.nextInt(256), r.nextInt(256), r.nextInt(256)));
		g.drawString("+",25 , 20);
		g.setColor(new Color(r.nextInt(256), r.nextInt(256), r.nextInt(256)));
		g.drawString(b+"",40 , 20);
		g.setColor(new Color(r.nextInt(256), r.nextInt(256), r.nextInt(256)));
		g.drawString("=",55 , 20);
		for(int i=0;i<15;i++)
		{
			g.setColor(new Color(r.nextInt(256), r.nextInt(256), r.nextInt(256)));
			g.drawLine(r.nextInt(80), r.nextInt(30),r.nextInt(80), r.nextInt(30));
		}
		ImageIO.write(img, "jpeg", response.getOutputStream());
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}
	

}
