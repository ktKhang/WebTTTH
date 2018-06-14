package Controllers;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Bean.user;
import DAO.loginDAO;

@WebServlet("/viewProfileAdmin")
public class viewProfileAdmin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public viewProfileAdmin() {
        super();
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String usname = (String) request.getSession().getAttribute("username");
		if(usname == null) {
			response.sendRedirect("login");
		}
		
		else {
			user us = new user();
			
			us = loginDAO.getUserInfo(usname);
			request.setAttribute("adminInfo", us);
			request.setAttribute("message", "");
			RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/admin_info.jsp");
			rd.forward(request, response);
		}	
	}

}
