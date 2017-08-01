package test;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import dbAccess.DBAccess;

/**
 * Servlet implementation class Test
 */
@WebServlet({ "/Test", "/test" })
public class Test extends HttpServlet {
	
	public String cut(String _fullPath) {
		if (_fullPath != null) {
			int length = _fullPath.length();
			String path = "";
			StringBuilder sb = new StringBuilder(path);
			for (int i=length-1;_fullPath.charAt(i) != '\\';--i) {
				sb.insert(0, _fullPath.charAt(i));
			}
			path = sb.toString();
			return path;
		}
		return null;
	}
	
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Test() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	@SuppressWarnings({ "resource", "unused" })
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter out = response.getWriter();
		boolean isMultipart = ServletFileUpload.isMultipartContent(request);//判断是不是上传文件
		//创建文件工厂，用于多个上传文件的处理，将上传的文件放到指定的文件夹中
		DiskFileItemFactory factory = new DiskFileItemFactory();
		HttpSession session = request.getSession();
		String userName = (String)session.getAttribute("userName");
		DBAccess dba = new DBAccess();
		//ServletContext application = (ServletContext) session.getServletContext();

		// 获得当前Servlet环境
//		ServletContext servletContext = (ServletContext) this.getServletConfig().getServletContext();
//		File repository = (File) servletContext.getAttribute("javax.servlet.context.tempdir");
		File repository = new File("F:\\ temp");
		factory.setRepository(repository);

		//将文件的存储地址指向到工厂中
		ServletFileUpload upload = new ServletFileUpload(factory);

		// Parse the request
		try {//列表是用来保存上传的文件
			List<FileItem> items = upload.parseRequest(request);
			
			if (items != null) {//如果用户上传了头像文件
				for (int i=0;i<items.size();++i) {
					FileItem item = items.get(i);
					String name = cut(item.getName());
					try { 
						String fullPath =  "image/"+userName;
						String fullName = fullPath+"/"+name;
						File tempUser = new File(fullPath);
						tempUser.mkdirs();
						item.write(new File(fullName));
						byte[] image = null;
						File file = new File(fullName);
						FileInputStream in = new FileInputStream(file);
						in.read(image);
						dba.insertImg(userName, image);
						out.print("上传成功！");
					} catch (Exception e) {
						// TODO Auto-generated catch block
						//e.printStackTrace();
					}
				}
			} else {//用户没有上传头像文件
				String fullName = "image/default.jpg";
				byte[] image = null;
				File file = new File(fullName);
				FileInputStream in = new FileInputStream(file);
				in.read(image);
				dba.insertImg(userName, image);
				out.print("上传成功！");
			}
			

			response.sendRedirect("interception/chat.html");
		} catch (FileUploadException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
