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

import Bean.student;
import DAO.loadClassDAO;
import DBConnection.DBConnection;

@WebServlet("/viewRegisteredStudents")
public class viewRegisteredStudents extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public viewRegisteredStudents() {
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
			
			List<student> listStudent = loadClassDAO.LoadAllStudents(conn);
			List<student> listStudent2 = loadClassDAO.LoadAllStudents2(conn);
			
			request.setAttribute("listStudent", listStudent);
			request.setAttribute("listStudent2", listStudent2);
			
			
			RequestDispatcher rd= request.getRequestDispatcher("/WEB-INF/admin_listRegistedSt.jsp");
			rd.forward(request, response);
		}
	}

}
