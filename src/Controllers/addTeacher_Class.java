package Controllers;

import java.io.IOException;
import java.sql.Connection;
import java.util.Arrays;
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

@WebServlet("/addTeacher_Class")
public class addTeacher_Class extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public addTeacher_Class() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//Khởi tạo đối tượng session
		HttpSession session = request.getSession(false);
		// Lấy ra usname đăng nhập vào
		String username = (String) session.getAttribute("username");
		if(username == null) {
			response.sendRedirect("login");
		}
		else {
			Connection conn = DBConnection.CreateConnection();
			String message="";
			String classID = request.getParameter("classID");
			
			String[] teacherDel = request.getParameterValues("teacherDel[]");
			
			List<String> listDel =  Arrays.asList(teacherDel);
			
			boolean flag = editClassDAO.AddTeacher_Class(listDel, classID, conn);
			if(flag==true) {
				message="Thêm thành công";
			}
			else {
				message="Thêm thất bại!";
			}
			//load lại trang class info
			
			Class c = new Class();
			c = loadClassDAO.LoadClassInfo(classID, conn);
			
			List<teacher> listTeacher = loadClassDAO.LoadListTeachers(classID, conn);
			List<user> listAllTeacher = loadClassDAO.LoadAllTeachers(classID, conn);
			
			request.setAttribute("classInfo", c);
			request.setAttribute("listTeacher", listTeacher);
			request.setAttribute("listAllTeacher", listAllTeacher);
			request.setAttribute("message", message);
			
			RequestDispatcher rd= request.getRequestDispatcher("/WEB-INF/admin_class_info.jsp");
			rd.forward(request, response);
		}
	}

}
