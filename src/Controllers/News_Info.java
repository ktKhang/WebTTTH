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

import DAO.NewsDAO;
import Bean.News;
import DAO.Type_of_newsDAO;
import DBConnection.DBConnection;

@WebServlet("/News_Info")
public class News_Info extends HttpServlet {
	private static final long serialVersionUID = 1L;
 
    public News_Info() {
        super();
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Connection conn = DBConnection.CreateConnection();
		//Lấy thông tin từ resquest
		String news_id=(String)request.getParameter("news_id");
		int newsID=Integer.parseInt(news_id);
		News news_info=NewsDAO.getNewsbyNewsID(conn, newsID);
		request.setAttribute("news_info", news_info);
		List<Bean.News> news=NewsDAO.LoadTinTuc(conn);
		request.setAttribute("news", news);
		//load danh sách Loại tintuc
		List<Bean.Type_of_news> typenews=Type_of_newsDAO.LoadTypeNews(conn);
		request.setAttribute("typenews", typenews);
		//
		RequestDispatcher rd= request.getRequestDispatcher("/WEB-INF/Muc_Tin.jsp");
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
