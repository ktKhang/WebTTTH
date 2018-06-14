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

@WebServlet("/updatePasswordAdmin")
public class updatePasswordAdmin extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public updatePasswordAdmin() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		//Khởi tạo đối tượng Session
		HttpSession session = request.getSession(false);
		// Lấy ra username đăng nhập vào
		String username = (String) session.getAttribute("username");
		if(username == null) {
			response.sendRedirect("login");
		}
		else {
			Connection conn = DBConnection.CreateConnection();
			user us = new user();
			us.setAccountname(username);
			us.setPassword(request.getParameter("newpass"));
			boolean flag = editUserDAO.UpdatePassword(us, conn);
			if (flag == true) {
				user uss = new user();
		        uss = loginDAO.getUserInfo(username);
				request.setAttribute("adminInfo", uss);
				RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/admin_info.jsp");
				rd.forward(request, response);
			}
		}
	}

}
