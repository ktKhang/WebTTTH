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

import Bean.student;
import DAO.editClassDAO;
import DAO.loadClassDAO;
import DBConnection.DBConnection;

@WebServlet("/deleteStudents2")
public class deleteStudents2 extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public deleteStudents2() {
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
			
			String[] studentDel2 = request.getParameterValues("studentDel2[]");
			
			List<String> listDel =  Arrays.asList(studentDel2);
			
			boolean flag = editClassDAO.DeleteStudent_Class(listDel, conn);
			if(flag==true) {
				message="Xóa thành công";
			}
			else {
				message="Lỗi!";
			}
			//load lại
			List<student> listStudent = loadClassDAO.LoadAllStudents(conn);
			List<student> listStudent2 = loadClassDAO.LoadAllStudents2(conn);
			
			request.setAttribute("listStudent", listStudent);
			request.setAttribute("listStudent2", listStudent2);
			request.setAttribute("message", message);
			
			
			RequestDispatcher rd= request.getRequestDispatcher("/WEB-INF/admin_listRegistedSt.jsp");
			rd.forward(request, response);
		}
	}

}
