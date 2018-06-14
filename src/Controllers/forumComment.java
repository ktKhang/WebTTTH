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

import Bean.comment;
import Bean.discussion;
import DAO.loadDiscussionDAO;
import DBConnection.DBConnection;

@WebServlet("/forumComment")
public class forumComment extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public forumComment() {
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
			String discussionID = request.getParameter("discussionID");
			discussion c = new discussion();
			
			List<comment> listCmt = loadDiscussionDAO.LoadListComments(discussionID, conn);
			c = loadDiscussionDAO.LoadDiscussionInfo(discussionID, conn);
			
			request.setAttribute("threadID", request.getParameter("thread"));
			request.setAttribute("name", request.getParameter("name"));
			request.setAttribute("disInfo", c);
			request.setAttribute("listCmt", listCmt);
			request.setAttribute("discussionID", discussionID);
			
			RequestDispatcher rd= request.getRequestDispatcher("/WEB-INF/admin_listComments.jsp");
			rd.forward(request, response);
		}
	}

}
