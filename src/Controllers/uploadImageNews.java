package Controllers;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import Bean.News;
import Bean.Type_of_news;
import DAO.NewsDAO;
import DAO.Type_of_newsDAO;
import DBConnection.DBConnection;

@WebServlet("/uploadImageNews")
public class uploadImageNews extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
    public uploadImageNews() {
        super();
    }
    // vị trí để lưu trữ file uploaded
    private static final String UPLOAD_DIRECTORY = "images"+File.separator+"TinTuc";
 
    // upload settings
    private static final int MEMORY_THRESHOLD = 1024 * 1024 * 3;  // 3MB
    private static final int MAX_FILE_SIZE = 1024 * 1024 * 40; // 40MB
    private static final int MAX_REQUEST_SIZE = 1024 * 1024 * 50; // 50MB
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//Khởi tạo đối tượng Session
		HttpSession session = request.getSession(false);
		// Lấy ra username đăng nhập vào
		String usname = (String) session.getAttribute("username");
		if(usname == null) {
			response.sendRedirect("login");
		}
		else {
			request.setCharacterEncoding("UTF-8");
			Connection conn = DBConnection.CreateConnection();
			String message="";
			
			String IDupload = request.getParameter("IDupload");
			// check request có chứa file upload ko
	        if (!ServletFileUpload.isMultipartContent(request)) {
	            // nếu ko thì stop
	            PrintWriter writer = response.getWriter();
	            writer.println("Error: Form must has enctype=multipart/form-data.");
	            writer.flush();
	            return;
	        }
	        
	        // cấu hình upload settings
	        DiskFileItemFactory factory = new DiskFileItemFactory();
	        // set ngưỡng vượt quá của bộ nhớ nơi mà file lưu trữ trên đĩa
	        factory.setSizeThreshold(MEMORY_THRESHOLD);
	        // set vị trí tạm để lưu trữ tập tin
	        factory.setRepository(new File(System.getProperty("java.io.tmpdir")));
	        
	        ServletFileUpload upload = new ServletFileUpload(factory);
	        
	        // sets maximum size of upload file
	        upload.setFileSizeMax(MAX_FILE_SIZE);
	 
	        // sets maximum size of request (include file + form data)
	        upload.setSizeMax(MAX_REQUEST_SIZE);
	        
	        // tạo đường dẫn lưu trữ file uploaded
	        String uploadPath = getServletContext().getRealPath("")
	                + File.separator + UPLOAD_DIRECTORY;
	        
	        // tạo thư mục mới nếu nó ko tồn tại
	        File uploadDir = new File(uploadPath);
	        if (!uploadDir.exists()) {
	            uploadDir.mkdir();
	        }
	        
	        try {
	            List<FileItem> formItems = upload.parseRequest(request);
	 
	            if (formItems != null && formItems.size() > 0) {
	                // iterates over form's fields
	                for (FileItem item : formItems) {
	                    // processes only fields that are not form fields
	                    if (!item.isFormField()) {
	                        String fileName = new File(item.getName()).getName();
	                        String filePath = uploadPath + File.separator + fileName;
	                        File storeFile = new File(filePath);
	 
	                        // saves the file on disk
	                        item.write(storeFile);
	                        
	                        // cập nhật vào csdl
	                        String ava= UPLOAD_DIRECTORY + "/" + fileName;
	                        boolean flag = NewsDAO.UpdateImage(IDupload, ava, conn);
	                        if(flag==true) {
	                        	message = "Cập nhật ảnh tin tức thành công!";
	                        }
	                        else {
	                        	message = "Cập nhật thất bại!";
	                        }
	                        
	                    }
	                }
	            }
	        } catch (Exception ex) {
	            request.setAttribute("msg", "There was an error: " + ex.getMessage());
	        }
			List<Type_of_news> typenw = Type_of_newsDAO.LoadTypeNews(conn);
			
			News c = new News();
			c = NewsDAO.getNewsbyNewsID(conn, Integer.parseInt(IDupload));
			request.setAttribute("newsInfo", c);
			request.setAttribute("listTypeofNews", typenw);
			request.setAttribute("message", message);
			
			RequestDispatcher rd= request.getRequestDispatcher("/WEB-INF/admin_news_info.jsp");
			rd.forward(request, response);
		}
	}

}
