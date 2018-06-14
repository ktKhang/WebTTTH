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
import Bean.course;
import DAO.editClassDAO;
import DAO.loadClassDAO;
import DAO.loadCourseDAO;
import DBConnection.DBConnection;

@WebServlet("/deleteClass")
public class deleteClass extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public deleteClass() {
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
			
			String[] classDel = request.getParameterValues("classDel[]");
			
			List<String> listDel =  Arrays.asList(classDel);
			
			boolean flag = editClassDAO.DeleteClass(listDel, conn);
			if(flag==true) {
				message="Xóa thành công";
			}
			else {
				message="Lỗi!";
			}
			//load lại trang classAdmin
			List<Class> listClass = loadClassDAO.LoadListClasses(conn);
			List<course> listCourse = loadCourseDAO.LoadListCourses(conn);
			
			request.setAttribute("listClass", listClass);
			request.setAttribute("listCourse", listCourse);
			request.setAttribute("message", message);
			request.setAttribute("course", "0");
			
			RequestDispatcher rd= request.getRequestDispatcher("/WEB-INF/admin_class.jsp");
			rd.forward(request, response);
		}
	}

}
