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

import Bean.Topic;
import Bean.course;
import DAO.CourseDAO;
import DAO.TopicDAO;
import DBConnection.DBConnection;

@WebServlet("/Course")
public class Course extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public Course() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		Connection conn = DBConnection.CreateConnection();
		List<course> course=null;
		//
		request.setAttribute("id", 0);
		if(request.getQueryString()!=null)
		{
			//Lấy thông tin từ resquest
			String topic_id=(String)request.getParameter("topic_id");
			int topic=Integer.parseInt(topic_id);
			request.setAttribute("id", topic_id);
			//Load thông tin ứng với mã topic
			course = CourseDAO.getCoursebyTopicID(conn, topic);
		}
		else		//load ALL COURSE
		{
			course= CourseDAO.LoadKhoaHoc(conn);
		}
		request.setAttribute("course", course);
		
		//load Topic
		List<Topic> topic= TopicDAO.LoadTopicCourse(conn);
		request.setAttribute("topic", topic);
		//
		RequestDispatcher rd= request.getRequestDispatcher("/WEB-INF/khoahoc.jsp");
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
