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

@WebServlet("/addNewsInfo")
public class addNewsInfo extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public addNewsInfo() {
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
			request.setCharacterEncoding("UTF-8");
			Connection conn = DBConnection.CreateConnection();
			String message="";
			
			System.out.println(request.getParameter("account_id"));
            System.out.println(request.getParameter("ListType"));
            System.out.println(request.getParameter("title"));
            System.out.println(request.getParameter("content"));
			
	        News c = new News();
            c.setAccount_id(Integer.parseInt(request.getParameter("account_id")));
            c.setType_id(Integer.parseInt(request.getParameter("ListType")));
            c.setTitle(request.getParameter("title"));
            c.setContent_news(request.getParameter("content"));
            
            boolean flag = NewsDAO.InsertNews(c, conn);
            if(flag == true) {
    			message= "Thêm tin tức thành công!";
    		}
    		else {
    			message= "Thêm thất bại!";
    		}
            // load lại trang admin news
            List<News> nw = NewsDAO.LoadListNewsAdmin(conn);
			List<Type_of_news> typenw = Type_of_newsDAO.LoadTypeNews(conn);
			request.setAttribute("listNews", nw);
			request.setAttribute("listTypeofNews", typenw);
			request.setAttribute("type", "0");
			request.setAttribute("message", message);
			
			RequestDispatcher rd= request.getRequestDispatcher("/WEB-INF/admin_news.jsp");
			rd.forward(request, response);
		}
	}

}
