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

@WebServlet("/loadBasedonRole")
public class loadBasedonRole extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public loadBasedonRole() {
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
			int roleID = Integer.parseInt(request.getParameter("roleID"));
			
			List<user> listAccount = loadUserDAO.LoadAccountBasedonRole(usname, roleID, conn);
			
			request.setAttribute("listAccount", listAccount);
			request.setAttribute("role", roleID);
			
			RequestDispatcher rd= request.getRequestDispatcher("/WEB-INF/admin_account.jsp");
			rd.forward(request, response);
		}
	}

}
