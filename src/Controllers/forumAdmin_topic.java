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

@WebServlet("/forumAdmin_topic")
public class forumAdmin_topic extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public forumAdmin_topic() {
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
			int threadID = Integer.parseInt(request.getParameter("thread"));
			int topic = 0;
			
			if(threadID == 1){
				topic = 1;
			}
			else if(threadID == 2) {
				topic = 4;
			}
			else if(threadID == 3) {
				topic = 6;
			}
			else if(threadID == 4) {
				topic = 9;
			}
			else if(threadID == 5) {
				topic = 11;
			}
			
			List<topicDiscussion> listTopic = loadDiscussionDAO.LoadListTopic(threadID, conn);
			List<discussion> listDiscussion = loadDiscussionDAO.LoadListDiscussion(topic, conn);
			
			request.setAttribute("name", request.getParameter("name"));
			request.setAttribute("listDiscussion", listDiscussion);
			request.setAttribute("listTopic", listTopic);
			request.setAttribute("topic", topic);
			request.setAttribute("threadID", threadID);
			
			RequestDispatcher rd= request.getRequestDispatcher("/WEB-INF/admin_forum_content.jsp");
			rd.forward(request, response);
		}
	}

}
