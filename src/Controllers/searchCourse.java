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
import DAO.loadCourseDAO;
import DBConnection.DBConnection;

@WebServlet("/searchCourse")
public class searchCourse extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public searchCourse() {
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
			String search = request.getParameter("search");
			
			List<course> listCourse = loadCourseDAO.SearchCourse(search.trim(), conn);
		
			
			request.setAttribute("listCourse", listCourse);
			request.setAttribute("topic", "0");
			
			RequestDispatcher rd= request.getRequestDispatcher("/WEB-INF/admin_course.jsp");
			rd.forward(request, response);
		}
	}

}
