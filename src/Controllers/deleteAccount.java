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

import Bean.user;
import DAO.editUserDAO;
import DAO.loadUserDAO;
import DBConnection.DBConnection;

@WebServlet("/deleteAccount")
public class deleteAccount extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public deleteAccount() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
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
			
			String[] accountDel = request.getParameterValues("accountDel[]");
			String action = request.getParameter("action");
			
			List<String> listDel =  Arrays.asList(accountDel);
			
			if ("delete".equals(action)) {	//delete list tài khoản
				boolean flag = editUserDAO.DeleteAccount(listDel, conn);
				if(flag==true) {
					message="Xóa thành công";
				}
				else {
					message="Lỗi!";
				}
			} 
			else if ("reset".equals(action)) {	//reset password list tài khoản
				boolean flag = editUserDAO.ResetPassword(listDel, conn);
				if(flag==true) {
					message="Reset password thành công";
				}
				else {
					message="Lỗi!";
				}
			}
			
			
			//load lại trang account admin
			List<user> us = loadUserDAO.LoadAllUsers(username, conn);
			request.setAttribute("listAccount", us);
			request.setAttribute("role", "4");
			request.setAttribute("message", message);
			
			RequestDispatcher rd= request.getRequestDispatcher("/WEB-INF/admin_account.jsp");
			rd.forward(request, response);
		}
	}

}
