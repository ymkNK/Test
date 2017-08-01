package dbAccess;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import umsg.Umsg;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;


public class DBAccess {
	public DBAccess() {
	// TODO Auto-generated constructor stub
	
	 try {
		Class.forName("com.mysql.jdbc.Driver").newInstance();
	} catch (InstantiationException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (IllegalAccessException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (ClassNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	}
	/**
	 * 这是	 * @param uname 传入一个昵称
	 * @return 如果存在这个昵称，那么返回真，不存在返回假
	 * @throws SQLException 
	 */
	public boolean Sort_User(String uname) throws SQLException{
		
		Connection conn =(Connection) DriverManager.getConnection("jdbc:mysql://localhost/homework?" +
		        "user=root&password=334421&useSSL=false");
		PreparedStatement pst=(PreparedStatement) conn.prepareStatement("call sort_user(?);");
		pst.setString(1, uname);
		ResultSet rs=pst.executeQuery();
		while(rs.next())
		{
			if(rs.getInt(1)>0)
				return true;
		}
		pst.close();
		conn.close();
		return false;
	}

	public void Insert_User(String uname) throws SQLException {
		Connection conn =(Connection) DriverManager.getConnection("jdbc:mysql://localhost/homework?" +
		        "user=root&password=334421&useSSL=false");
		PreparedStatement pst=(PreparedStatement) conn.prepareStatement("call insert_user(?);");
		pst.setString(1, uname);
		pst.executeQuery();
		pst.close();
		conn.close();
	}
	
	public ArrayList<Umsg> Get_all_user() throws SQLException{
		ArrayList<Umsg> temp=new ArrayList<Umsg>();
		ResultSet rs;
		Connection conn =(Connection) DriverManager.getConnection("jdbc:mysql://localhost/homework?" +
		        "user=root&password=334421&useSSL=false");
		PreparedStatement pst=(PreparedStatement) conn.prepareStatement("select * from chat_user;");
		rs=pst.executeQuery();
		while(rs.next())
		{
			Umsg msg=new Umsg();
			msg.setUname(rs.getString(1));
			temp.add(msg);
		}
		rs.close();
		pst.close();
		conn.close();
		
		return temp;
	}
	/**
	 * 使用数据库保存用户说过的话
	 * @param uname
	 * @param utime
	 * @param ucontent
	 * @throws SQLException 
	 */
	public void Insert_log(Umsg msg) throws SQLException{
		
		String uname=msg.getUname();
		String utime=msg.getUtime();
		String ucontent=msg.getUcontent();
		Connection conn =(Connection) DriverManager.getConnection("jdbc:mysql://localhost/homework?" +
		        "user=root&password=334421&useSSL=false");
		PreparedStatement pst=(PreparedStatement) conn.prepareStatement("call insert_log(?,?,?);");
		pst.setString(1, uname);
		pst.setString(2, utime);
		pst.setString(3, ucontent);
		pst.executeQuery();
		pst.close();
		conn.close();
	}
	
	public ArrayList<Umsg> Get_all_log() throws SQLException{
		ArrayList<Umsg> temp=new ArrayList<Umsg>();
		
		ResultSet rs;
		Connection conn =(Connection) DriverManager.getConnection("jdbc:mysql://localhost/homework?" +
		        "user=root&password=334421&useSSL=false");
		PreparedStatement pst=(PreparedStatement) conn.prepareStatement("call get_log();");
		rs=pst.executeQuery();
		
		while(rs.next())
		{
			Umsg msg=new Umsg();
			msg.setUname(rs.getString(1));
			msg.setUtime(rs.getString(2));
			msg.setUcontent(rs.getString(3));
			temp.add(msg);
		}
		rs.close();
		pst.close();
		conn.close();
		return temp;
	}
	
	public void del_log() throws SQLException {
		Connection conn =(Connection) DriverManager.getConnection("jdbc:mysql://localhost/homework?" +
		        "user=root&password=334421&useSSL=false");
		PreparedStatement pst=(PreparedStatement) conn.prepareStatement("call del_log();");
		pst.executeQuery();
		pst.close();
		conn.close();
	}
	public static void main(String[] args) throws SQLException {
		

	}
	public void insertImg(String userName, byte[] image) {
		// TODO Auto-generated method stub
		
	}
}
