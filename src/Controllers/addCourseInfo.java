package Controllers;

import java.io.IOException;
import java.sql.Connection;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


import Bean.course;
import DAO.editCourseDAO;
import DAO.loadCourseDAO;
import DBConnection.DBConnection;

@WebServlet("/addCourseInfo")
public class addCourseInfo extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public addCourseInfo() {
        super();
    }
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
			
	        course c = new course();
            c.setCoursename(request.getParameter("coursename"));
            c.setTopic_id(Integer.parseInt(request.getParameter("ListTopic")));
            c.setFee(Double.parseDouble(request.getParameter("fee")));
            c.setDescription(request.getParameter("description"));
            c.setInfo(request.getParameter("info"));
            
            boolean flag = editCourseDAO.InsertCourse(c, conn);
            if(flag == true) {
    			message= "Thêm khóa học thành công!";
    		}
    		else {
    			message= "Thêm thất bại!";
    		}
            // load lại trang admin_course
            List<course> listCourse = loadCourseDAO.LoadListCourses(conn);
			
			request.setAttribute("listCourse", listCourse);
			request.setAttribute("topic", "0");
			request.setAttribute("message", message);
			
			RequestDispatcher rd= request.getRequestDispatcher("/WEB-INF/admin_course.jsp");
			rd.forward(request, response);
		}
	}

}
