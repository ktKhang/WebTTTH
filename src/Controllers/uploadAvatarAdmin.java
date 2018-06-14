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

import Bean.Account;
import Bean.user;
import DAO.editUserDAO;
import DAO.loginDAO;
import DBConnection.DBConnection;

@WebServlet("/uploadAvatarAdmin")
public class uploadAvatarAdmin extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public uploadAvatarAdmin() {
        super();
    }
    // vá»‹ trÃ­ Ä‘á»ƒ lÆ°u trá»¯ file uploaded
    private static final String UPLOAD_DIRECTORY = "images"+File.separator+"avatars";
 
    // upload settings
    private static final int MEMORY_THRESHOLD = 1024 * 1024 * 3;  // 3MB
    private static final int MAX_FILE_SIZE = 1024 * 1024 * 40; // 40MB
    private static final int MAX_REQUEST_SIZE = 1024 * 1024 * 50; // 50MB
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//Khá»Ÿi táº¡o Ä‘á»‘i tÆ°á»£ng Session
		HttpSession session = request.getSession(false);
		// Láº¥y ra username Ä‘Äƒng nháº­p vÃ o
		String usname = (String) session.getAttribute("username");
		if(usname == null) {
			response.sendRedirect("login");
		}
		else {
			request.setCharacterEncoding("UTF-8");
			Connection conn = DBConnection.CreateConnection();
			String message="";
			
			// check request cÃ³ chá»©a file upload ko
	        if (!ServletFileUpload.isMultipartContent(request)) {
	            // náº¿u ko thÃ¬ stop
	            PrintWriter writer = response.getWriter();
	            writer.println("Error: Form must has enctype=multipart/form-data.");
	            writer.flush();
	            return;
	        }
	        // cáº¥u hÃ¬nh upload settings
	        DiskFileItemFactory factory = new DiskFileItemFactory();
	        // set ngÆ°á»¡ng vÆ°á»£t quÃ¡ cá»§a bá»™ nhá»› nÆ¡i mÃ  file lÆ°u trá»¯ trÃªn Ä‘Ä©a
	        factory.setSizeThreshold(MEMORY_THRESHOLD);
	        // set vá»‹ trÃ­ táº¡m Ä‘á»ƒ lÆ°u trá»¯ táº­p tin
	        factory.setRepository(new File(System.getProperty("java.io.tmpdir")));
	        
	        ServletFileUpload upload = new ServletFileUpload(factory);
	        
	        // sets maximum size of upload file
	        upload.setFileSizeMax(MAX_FILE_SIZE);
	 
	        // sets maximum size of request (include file + form data)
	        upload.setSizeMax(MAX_REQUEST_SIZE);
	        
	        // táº¡o Ä‘Æ°á»�ng dáº«n lÆ°u trá»¯ file uploaded
	        String uploadPath = getServletContext().getRealPath("")
	                + File.separator + UPLOAD_DIRECTORY;
	        System.out.println(uploadPath);
	        // táº¡o thÆ° má»¥c má»›i náº¿u nÃ³ ko tá»“n táº¡i
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
	                        
	                        // cáº­p nháº­t vÃ o csdl
	                        String ava= UPLOAD_DIRECTORY + "/" + fileName;
	                        System.out.println(ava);
	                        boolean flag = editUserDAO.UpdateAvatar(usname, ava, conn);
	                        if(flag==true) {
	                        	message = "Cập nhật ảnh đại diện thành công!";
	                        	Account acc=(Account) request.getSession().getAttribute("account");
	                            acc.setAvatar(ava);
	                            request.getSession().removeAttribute("account");
	                            request.getSession().setAttribute("account", acc);
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
	        user us = new user();
	        us = loginDAO.getUserInfo(usname);
			request.setAttribute("adminInfo", us);
			request.setAttribute("message", message);
			
			session.setAttribute("adminAvatar", us.getAvatar());	//set láº¡i avatar má»›i vÃ o session
			RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/admin_info.jsp");
			rd.forward(request, response);
		}
	}

}
