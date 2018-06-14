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

import Bean.Class;
import Bean.teacher;
import Bean.user;
import DAO.editClassDAO;
import DAO.loadClassDAO;
import DBConnection.DBConnection;

@WebServlet("/deleteTeacher_Class")
public class deleteTeacher_Class extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public deleteTeacher_Class() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//Khởi tạo đối tượng Session
		HttpSession session = request.getSession(false);
		// Lấy ra username đăng nhập vào
		String username = (String) session.getAttribute("username");
		if(username == null) {
			response.sendRedirect("login");
		}
		else {
			Connection conn = DBConnection.CreateConnection();
			int tc_id = Integer.parseInt(request.getParameter("tc_id"));
			
			editClassDAO.DeleteTeacher_Class(tc_id, conn);
			
			String classID = request.getParameter("classID");
			Class c = new Class();
			c = loadClassDAO.LoadClassInfo(classID, conn);
			
			List<teacher> listTeacher = loadClassDAO.LoadListTeachers(classID, conn);
			List<user> listAllTeacher = loadClassDAO.LoadAllTeachers(classID, conn);
			
			request.setAttribute("classInfo", c);
			request.setAttribute("listTeacher", listTeacher);
			request.setAttribute("listAllTeacher", listAllTeacher);
			
			RequestDispatcher rd= request.getRequestDispatcher("/WEB-INF/admin_class_info.jsp");
			rd.forward(request, response);
			
		}
	}

}
