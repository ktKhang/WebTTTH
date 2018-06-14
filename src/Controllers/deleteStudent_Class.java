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
import Bean.student;
import DAO.editClassDAO;
import DAO.loadClassDAO;
import DBConnection.DBConnection;

@WebServlet("/deleteStudent_Class")
public class deleteStudent_Class extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public deleteStudent_Class() {
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
			String message="";
			
			String[] studentDel = request.getParameterValues("studentDel[]");
			
			List<String> listDel =  Arrays.asList(studentDel);
			
			boolean flag = editClassDAO.DeleteStudent_Class(listDel, conn);
			if(flag==true) {
				message="Xóa thành công";
			}
			else {
				message="Lỗi!";
			}
			//load lại trang listStudent
			String classID = request.getParameter("classID");
			Class c = new Class();
			
			List<student> listStudent = loadClassDAO.LoadListStudents(classID, conn);
			c = loadClassDAO.LoadClassInfo2(classID, conn);
			
			request.setAttribute("classInfo", c);
			request.setAttribute("listStudent", listStudent);
			request.setAttribute("message", message);
			
			
			RequestDispatcher rd= request.getRequestDispatcher("/WEB-INF/admin_listStudents.jsp");
			rd.forward(request, response);
			
		}
	}

}
