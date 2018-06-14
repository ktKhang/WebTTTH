package Controllers;

import java.io.IOException;
import java.sql.Connection;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Bean.course;
import DAO.loadCourseDAO;
import DBConnection.DBConnection;

@WebServlet("/viewCourseInfo")
public class viewCourseInfo extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public viewCourseInfo() {
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
			Connection conn = DBConnection.CreateConnection();
			
			String courseID = request.getParameter("courseID");
			course c = new course();
			c = loadCourseDAO.LoadCourseInfo(courseID, conn);
			request.setAttribute("courseInfo", c);
			RequestDispatcher rd= request.getRequestDispatcher("/WEB-INF/admin_course_info.jsp");
			rd.forward(request, response);
		}
	}

}
