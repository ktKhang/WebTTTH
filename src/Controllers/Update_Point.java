package Controllers;

import java.io.IOException;
import java.sql.Connection;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Bean.ViewListStudent;
import DAO.ListClass;
import DAO.ListStudent;
import DBConnection.DBConnection;


@WebServlet("/Update_Point")
public class Update_Point extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
    public Update_Point() {
        super();
        
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String class_id1=(String)request.getParameter("class_id");
		System.out.println(class_id1);
		String account_id1=(String)request.getParameter("account_id");
		System.out.println(account_id1);
		String point=(String)request.getParameter("point");
		System.out.println(point);
		int account_id=Integer.parseInt(account_id1);
		int class_id=Integer.parseInt(class_id1);
		ListClass.Update_Point(account_id, class_id, point);
		
		Connection conn = DBConnection.CreateConnection();
		List<ViewListStudent> student =ListStudent.ViewListStudents(conn, class_id);
		request.setAttribute("ListStudent", student);
		
		System.out.println(student);
		
		request.setAttribute("class_id",class_id);
		request.setAttribute("account_id", account_id);
		request.getRequestDispatcher("/WEB-INF/List_Student.jsp").forward(request, response);
	}

}
