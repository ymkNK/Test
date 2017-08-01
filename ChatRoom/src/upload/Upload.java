package upload;
//import java.io.File;
import java.io.IOException;
//import java.io.PrintWriter;
//import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
//
//import org.apache.commons.fileupload.FileItem;
//import org.apache.commons.fileupload.FileUploadException;
//import org.apache.commons.fileupload.disk.DiskFileItemFactory;
//import org.apache.commons.fileupload.servlet.ServletFileUpload;


/**
 * Servlet implementation class Upload
 */
@WebServlet({ "/Upload", "/upload" })
public class Upload extends HttpServlet {

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
    public Upload() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException {
		// TODO Auto-generated method stub
	}

	/**
	 * @throws IOException 
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */

	 protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//	PrintWriter out =response.getWriter();
//	
//	boolean isMultipart = ServletFileUpload.isMultipartContent(request);//判断是不是上传文件
//	//创建文件工厂，用于多个上传文件的处理，将上传的文件放到指定的文件夹中
//	DiskFileItemFactory factory = new DiskFileItemFactory();
//	File repository = new File("F:\\ temp");//设置文件的存储的路径
//	factory.setRepository(repository);
//
//	//将文件的存储地址指向到工厂中
//	ServletFileUpload upload = new ServletFileUpload(factory);
//	try {
//		List<FileItem> items = upload.parseRequest(request);
//		
//	} catch (FileUploadException e) {
//		// TODO Auto-generated catch block
//		e.printStackTrace();
//	}
//
	}

}
