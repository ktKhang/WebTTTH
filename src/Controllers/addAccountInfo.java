package Controllers;

import java.io.IOException;
import Controllers.*;
import java.sql.Connection;
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

@WebServlet("/addAccountInfo")
public class addAccountInfo extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public addAccountInfo() {
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
			String message="";
			
	        user c = new user();
            c.setAccountname(request.getParameter("username"));
            c.setRole_id(Integer.parseInt(request.getParameter("roleID")));
            c.setName(request.getParameter("name"));
            c.setBirthday(request.getParameter("birthday"));
            c.setSex(request.getParameter("sex"));
            c.setMail(request.getParameter("email"));
            c.setPhonenumber(request.getParameter("phonenumber"));
            c.setPassword(MD5.encryption(request.getParameter("password")));
            
            boolean flag = editUserDAO.InsertAccount(c, conn);
            if(flag == true) {
    			message= "Thêm tài khoản thành công!";
    		}
    		else {
    			message= "Thêm thất bại!";
    		}
            // load lại trang account admin
            List<user> us = loadUserDAO.LoadAllUsers(username, conn);
			request.setAttribute("listAccount", us);
			request.setAttribute("role", "4");
			request.setAttribute("message", message);
			
			RequestDispatcher rd= request.getRequestDispatcher("/WEB-INF/admin_account.jsp");
			rd.forward(request, response);
		}
	}

}
