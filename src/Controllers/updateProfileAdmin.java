package Controllers;

import java.io.IOException;
import java.sql.Connection;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Bean.user;
import DAO.editUserDAO;
import DAO.loginDAO;
import DBConnection.DBConnection;

@WebServlet("/updateProfileAdmin")
public class updateProfileAdmin extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public updateProfileAdmin() {
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
			request.setCharacterEncoding("UTF-8");
			Connection conn = DBConnection.CreateConnection();
			String message = "";
			
			user us = new user();
			
			us.setAccountname(username);
			us.setName(request.getParameter("name"));
			us.setSex(request.getParameter("listsex"));
			us.setBirthday(request.getParameter("birthday"));
			us.setMail(request.getParameter("mail"));
			us.setPhonenumber(request.getParameter("phonenumber"));
			
			System.out.println(request.getParameter("name"));
			System.out.println(request.getParameter("listsex"));
			System.out.println(request.getParameter("birthday"));
			System.out.println(request.getParameter("mail"));
			System.out.println(request.getParameter("phonenumber"));
			boolean flag = editUserDAO.UpdateUser(us, conn);
			if (flag == true) {
				message="Cập nhật hồ sơ thành công!";
			}
			else {
				message="Cập nhật thất bại!";
			}
			user uss = new user();
			uss= loginDAO.getUserInfo(username);
			request.setAttribute("adminInfo", uss);
			request.setAttribute("message", message);
			
			session.setAttribute("adminName", us.getName());	//set lại name vào session
			
			RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/admin_info.jsp");
			rd.forward(request, response);
		}
	}

}
