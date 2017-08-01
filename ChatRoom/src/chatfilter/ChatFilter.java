package chatfilter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet Filter implementation class ChatFilter
 */

@WebFilter({ "/ChatFilter", "/*" })
public class ChatFilter implements Filter {

    /**
     * Default constructor. 
     */
    public ChatFilter() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		// TODO Auto-generated method stub
		// place your code here
		HttpServletRequest req=(HttpServletRequest) request;
		HttpServletResponse resp=(HttpServletResponse) response;
		HttpSession session=req.getSession();
		//System.out.println(req.getRequestURI());
		if(session.getAttribute("uname")==null)
		{
		String temp=req.getRequestURI();
		if(temp.equals("/ChatRoom/user_login.html")||temp.equals("/ChatRoom/user_login.jsp")
				||temp.equals("/ChatRoom/code")||temp.equals("/ChatRoom/sortuser")
				||temp.equals("/ChatRoom/checknick"))
		{
			chain.doFilter(request, response);
		}
		else 
			resp.sendRedirect("user_login.html");
		}else
		{
		chain.doFilter(request, response);
		}
		
		//chain.doFilter(request, response);
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
