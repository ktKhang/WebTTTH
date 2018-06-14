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

@WebServlet("/updateCourse")
public class updateCourse extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public updateCourse() {
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
			//khởi tạo thông báo
			String message = "";
			
			course r = new course();
			
			int course_id = Integer.parseInt(request.getParameter("course_id"));
			r.setCourse_id(course_id);
			r.setCoursename(request.getParameter("coursename"));
			r.setDescription(request.getParameter("description"));
			r.setFee(Double.parseDouble(request.getParameter("fee")));
			r.setInfo(request.getParameter("info"));
			r.setTopic_id(Integer.parseInt(request.getParameter("ListTopic")));
			
			boolean flag = editCourseDAO.UpdateCourse(r, conn);
			if(flag == true) {
				message= "Cập nhật thành công!";
			}
			else {
				message= "Cập nhật thất bại!";
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
