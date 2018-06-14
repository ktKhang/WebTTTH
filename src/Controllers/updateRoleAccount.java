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
import DAO.loadUserDAO;
import DBConnection.DBConnection;

@WebServlet("/updateRoleAccount")
public class updateRoleAccount extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public updateRoleAccount() {
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
			//khởi tạo thông báo
			String message = "";
			String accountID = request.getParameter("accountID");
			String roleID = request.getParameter("roleID");
			
			boolean kt = editUserDAO.UpdateRoleAccount(accountID, roleID,conn);
			if(kt == true) {
				message="Cập nhật thành công";
			}
			else {
				message="Cập nhật thất bại";
			}
			//load lại trang account info
			user us = new user();
			
			us = loadUserDAO.LoadAccountInfo(accountID, conn);
			
			request.setAttribute("usInfo", us);
			request.setAttribute("message", message);
			
			RequestDispatcher rd= request.getRequestDispatcher("/WEB-INF/admin_account_info.jsp");
			rd.forward(request, response);
		}
	}
}
