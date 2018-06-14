package Controllers;

import java.io.IOException;
import java.sql.Connection;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.Student_ClassDAO;
import DBConnection.DBConnection;

@WebServlet("/Insert_StudentClass")
public class Insert_StudentClass extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public Insert_StudentClass() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");

		Connection conn = DBConnection.CreateConnection();
		String Stringaccount_id=(String)request.getParameter("account_id");
		String Stringclass_id=(String)request.getParameter("class_id");
		int account_id=Integer.parseInt(Stringaccount_id);
		int class_id=Integer.parseInt(Stringclass_id);
		if(Student_ClassDAO.InsertStudent_Class(conn, account_id, class_id)==true)
		{
			request.setAttribute("error","Đăng kí lớp thành công! Mời bạn đến trung tâm để đóng tiền!!");
		}
		else
		{
			request.setAttribute("error", "Đăng kí lớp thất bại!!!");
			
		}
		RequestDispatcher rd= request.getRequestDispatcher("/WEB-INF/trangchu.jsp");
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
