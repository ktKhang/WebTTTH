package Controllers;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Bean.Account;
import Bean.course;
import Bean.News;
import DAO.CourseDAO;
import DAO.NewsDAO;
import DAO.TestLogin;
import DBConnection.DBConnection;


@WebServlet("/TrangChu")
public class TrangChu extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public TrangChu() {
        super();
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Connection conn = DBConnection.CreateConnection();
		//load COURSE
		List<course> course= CourseDAO.LoadKhoaHoc(conn);
		request.setAttribute("course", course);
		//Load News
		List<News> news=NewsDAO.LoadTinTuc(conn);
		request.setAttribute("news", news);
		
		//Xá»­ lÃ½ Session & Cookie
		HttpSession session = request.getSession();
		//Get an array of Cookies associated with this domain
		Cookie[] cookie= request.getCookies();
		
		Account acc=null;
		
		if(session.getAttribute("account")==null && cookie!=null)
		{
			try {
				acc= TestLogin.findUser(cookie[0].getValue());
				//LÆ°u thÃ´ng tin ngÆ°á»�i dÃ¹ng vÃ o session
				session.setAttribute("account",acc);
				
			} catch (SQLException e) {
				e.printStackTrace();
				System.out.print(e.getMessage());
			}
		}
		//truy cáº­p Ä‘áº¿n trang chá»§
		RequestDispatcher rd= request.getRequestDispatcher("/WEB-INF/trangchu.jsp");
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
