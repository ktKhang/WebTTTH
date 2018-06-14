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

import Bean.News;
import Bean.Type_of_news;
import DAO.NewsDAO;
import DAO.Type_of_newsDAO;
import DBConnection.DBConnection;

@WebServlet("/viewNewsInfo")
public class viewNewsInfo extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public viewNewsInfo() {
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
			
			int newsID = Integer.parseInt(request.getParameter("newsID"));
			List<Type_of_news> typenw = Type_of_newsDAO.LoadTypeNews(conn);
			
			News c = new News();
			c = NewsDAO.getNewsbyNewsID(conn, newsID);
			request.setAttribute("newsInfo", c);
			request.setAttribute("listTypeofNews", typenw);
			
			RequestDispatcher rd= request.getRequestDispatcher("/WEB-INF/admin_news_info.jsp");
			rd.forward(request, response);
		}
	}

}
