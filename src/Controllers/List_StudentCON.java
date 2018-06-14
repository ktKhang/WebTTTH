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
import DAO.ListStudent;
import DBConnection.DBConnection;

@WebServlet("/List_StudentCON")
public class List_StudentCON extends HttpServlet {
	private static final long serialVersionUID = 1L;
  
    public List_StudentCON() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		String Stringclass_id=(String)request.getParameter("class_id");
		System.out.println(Stringclass_id);
		String Stringaccount_id=(String)request.getParameter("account_id");
		int class_id = Integer.parseInt(Stringclass_id);
		int account_id=Integer.parseInt(Stringaccount_id);
		
		Connection conn = DBConnection.CreateConnection();
		List<ViewListStudent> student =ListStudent.ViewListStudents(conn, class_id);
		request.setAttribute("ListStudent", student);
		
		System.out.println(student);
		
		request.setAttribute("class_id",class_id);
		request.setAttribute("account_id", account_id);
		request.getRequestDispatcher("/WEB-INF/List_Student.jsp").forward(request, response);
	
	}

}
