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

import Bean.user;
import DAO.loadUserDAO;
import DBConnection.DBConnection;

@WebServlet("/searchAccount")
public class searchAccount extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public searchAccount() {
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
			String search = request.getParameter("search");
			
			List<user> listAccount = loadUserDAO.SearchAccount(username, search.trim(), conn);
			
			request.setAttribute("listAccount", listAccount);
			request.setAttribute("role", "4");
			
			RequestDispatcher rd= request.getRequestDispatcher("/WEB-INF/admin_account.jsp");
			rd.forward(request, response);
		}
	}

}
