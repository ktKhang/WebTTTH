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

@WebServlet("/loadBasedonTopic")
public class loadBasedonTopic extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public loadBasedonTopic() {
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
			int topicID = Integer.parseInt(request.getParameter("topicID"));
			
			List<course> listCourse = loadCourseDAO.LoadCourseBasedonTopic(topicID, conn);
			
			request.setAttribute("listCourse", listCourse);
			request.setAttribute("topic", topicID);
			
			RequestDispatcher rd= request.getRequestDispatcher("/WEB-INF/admin_course.jsp");
			rd.forward(request, response);
		}
	}

}
