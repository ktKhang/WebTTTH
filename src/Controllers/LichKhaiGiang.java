package Controllers;

import java.io.IOException;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Bean.Class;
import Bean.course;
import DAO.ClassDAO;
import DAO.CourseDAO;
import DBConnection.DBConnection;

@WebServlet("/LichKhaiGiang")
public class LichKhaiGiang extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public LichKhaiGiang() {
        super();
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//load thông tin course_id&coursename
		Connection conn = DBConnection.CreateConnection();
		List<course> course = CourseDAO.LoadKhoaHoc(conn);
		request.setAttribute("course", course);
		//Load thông tin lịch khai giảng
		List<Class> class1=new ArrayList<Class>();
		for(int i=0;i<course.size();i++){
			List<Class> class2=ClassDAO.getClassbyCourseID(conn, course.get(i).getCourse_id());
			class1.addAll(class2);
		}
		request.setAttribute("list_class", class1);
		
		//where class.startday>=curdate()
		//chuyển sang lichkhaigiang.jsp
		RequestDispatcher rd= request.getRequestDispatcher("/WEB-INF/lichkhaigiang.jsp");
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doGet(request, response);
	}

}
