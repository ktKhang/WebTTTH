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

import Bean.course;
import DAO.ClassDAO;
import DAO.CourseDAO;
import DBConnection.DBConnection;

@WebServlet("/Course_Info")
public class Course_Info extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public Course_Info() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Connection conn = DBConnection.CreateConnection();
		//Láº¥y thÃ´ng tin tá»« resquest
		String course_id=(String)request.getParameter("course_id");
		int courseID=Integer.parseInt(course_id);
		//Load thÃ´ng tin á»©ng vá»›i mÃ£ course
		course course = CourseDAO.getCoursebyCourseID(conn, courseID);
		request.setAttribute("course", course);
		
		//load thÃ´ng tin lá»›p há»�c tÆ°Æ¡ng á»©ng vá»›i mÃ£ course
		List<Bean.Class> class1=ClassDAO.getClassbyCourseID(conn, courseID);
		request.setAttribute("class_list", class1);
		
		RequestDispatcher rd= request.getRequestDispatcher("/WEB-INF/khoahoc_info.jsp");
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
