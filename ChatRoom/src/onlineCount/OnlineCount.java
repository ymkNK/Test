package onlineCount;

import java.util.ArrayList;

import javax.servlet.ServletContext;
import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;



import umsg.Umsg;

/**
 * Application Lifecycle Listener implementation class OnlineCount
 *
 */
@WebListener
public class OnlineCount implements HttpSessionListener {

    /**
     * Default constructor. 
     */
    public OnlineCount() {
        // TODO Auto-generated constructor stub
    }

	/**
     * @see HttpSessionListener#sessionCreated(HttpSessionEvent)
     */
	@SuppressWarnings("unchecked")
    public void sessionCreated(HttpSessionEvent arg0) {
        // TODO Auto-generated method stub
    	HttpSession session=arg0.getSession();
    	ServletContext application =  session.getServletContext();
		if(application.getAttribute("OnlineUsers")==null)
    	{
			ArrayList<Umsg> temp=new ArrayList<Umsg>();
	    	Umsg msg=new Umsg();
	    	msg.setUname(session.getAttribute("uname").toString());
	    	temp.add(msg);
	    	application.setAttribute("Onlineuser", temp);
    	}else
    	{
			ArrayList<Umsg> temp=(ArrayList<Umsg>) application.getAttribute("Onlineuser");
	    	Umsg msg=new Umsg();
	    	msg.setUname(session.getAttribute("uname").toString());
	    	temp.add(msg);
	    	application.setAttribute("Onlineuser", temp);
    	}
    	
    }

	/**
     * @see HttpSessionListener#sessionDestroyed(HttpSessionEvent)
     */
    public void sessionDestroyed(HttpSessionEvent arg0) {
        // TODO Auto-generated method stub
    }
	
}
