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

import Bean.discussion;
import Bean.topicDiscussion;
import DAO.loadDiscussionDAO;
import DBConnection.DBConnection;

@WebServlet("/loadBasedonTopicdis")
public class loadBasedonTopicdis extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
    public loadBasedonTopicdis() {
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
			int topicID = Integer.parseInt(request.getParameter("topicID"));
			int threadID = Integer.parseInt(request.getParameter("thread"));
			
			List<topicDiscussion> listTopic = loadDiscussionDAO.LoadListTopic(threadID, conn);
			List<discussion> listDiscussion = loadDiscussionDAO.LoadListDiscussion(topicID, conn);
			
			request.setAttribute("name", request.getParameter("name"));
			request.setAttribute("listDiscussion", listDiscussion);
			request.setAttribute("listTopic", listTopic);
			request.setAttribute("topic", topicID);
			request.setAttribute("threadID", threadID);
			
			RequestDispatcher rd= request.getRequestDispatcher("/WEB-INF/admin_forum_content.jsp");
			rd.forward(request, response);
		}
	}

}
