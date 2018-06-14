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

import Bean.discussion;
import Bean.user;
import DAO.loadDiscussionDAO;
import DBConnection.DBConnection;

@WebServlet("/thaoluan_khugiaitri")
public class thaoluan_khugiaitri extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public thaoluan_khugiaitri() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Connection conn = DBConnection.CreateConnection();
		int topicID = Integer.parseInt(request.getParameter("topicID"));
		
		List<discussion> listDiscussion = loadDiscussionDAO.LoadListDiscussion(topicID, conn);
		List<user> listAccDiscussion = loadDiscussionDAO.LoadListAccountDiscussion(topicID, conn);
		
		request.setAttribute("listDiscussion", listDiscussion);
		request.setAttribute("listAccDiscussion", listAccDiscussion);
		
		if(topicID == 9) {
			RequestDispatcher rd= request.getRequestDispatcher("/WEB-INF/thaoluan_khugiaitri.jsp");
			rd.forward(request, response);
		}
		else if(topicID == 10) {
			RequestDispatcher rd= request.getRequestDispatcher("/WEB-INF/thaoluan_khugiaitri2.jsp");
			rd.forward(request, response);
		}
	}

}
