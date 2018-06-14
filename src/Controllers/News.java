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
import DAO.Type_of_newsDAO;
import DBConnection.DBConnection;

@WebServlet("/News")
public class News extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public News() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Connection conn = DBConnection.CreateConnection();
		List<Bean.News> news=null;
		List<Bean.News> news1=null;
		if(request.getQueryString()!=null)
		{
			//Lấy thông tin từ resquest
			String type_id=(String)request.getParameter("type_id");
			int type=Integer.parseInt(type_id);
			news=NewsDAO.LoadNewsbyTypeID(conn, type);
			news1=NewsDAO.LoadTinTuc(conn);
		}
		else		//load ALL news
		{
			//load ds TinTuc
			news=NewsDAO.LoadTinTuc(conn);
			news1=news;
		}
		request.setAttribute("news", news);
		request.setAttribute("news1", news1);
		//load ds loại tintuc
		List<Bean.Type_of_news> typenews=Type_of_newsDAO.LoadTypeNews(conn);
		request.setAttribute("typenews", typenews);
		
		//
		RequestDispatcher rd= request.getRequestDispatcher("/WEB-INF/TinTuc.jsp");
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
