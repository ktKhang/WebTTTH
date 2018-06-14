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

import Bean.topicDiscussion;
import DAO.loadDiscussionDAO;
import DBConnection.DBConnection;

@WebServlet("/addPost")
public class addPost extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public addPost() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//Khởi tạo đối tượng Session
		HttpSession session = request.getSession(false);
		// Lấy ra username đăng nhập vào
		String username = (String) session.getAttribute("username");
		if(username == null) {
			response.sendRedirect("login");
		}
		else {
			Connection conn = DBConnection.CreateConnection();
			int threadID = Integer.parseInt(request.getParameter("threadID"));
			
			List<topicDiscussion> listTopic = loadDiscussionDAO.LoadListTopic(threadID, conn);
			request.setAttribute("listTopic", listTopic);
			
			request.setAttribute("name", request.getParameter("name"));
			request.setAttribute("threadID", threadID);
			
			RequestDispatcher rd= request.getRequestDispatcher("/WEB-INF/admin_addNewPost.jsp");
			rd.forward(request, response);
		}
	}

}
