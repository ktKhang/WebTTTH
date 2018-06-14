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

import Bean.comment;
import Bean.discussion;
import DAO.editDiscussionDAO;
import DAO.loadDiscussionDAO;
import DBConnection.DBConnection;

@WebServlet("/addCommentAdmin")
public class addCommentAdmin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public addCommentAdmin() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		Connection conn = DBConnection.CreateConnection();
		
		String discussionID = request.getParameter("discussionID");
		String accountID = request.getParameter("accountID");
		String message = request.getParameter("message");
		
		comment d = new comment();
		d.setAccount_id(Integer.parseInt(accountID));
		d.setDiscussion_id(Integer.parseInt(discussionID));
		d.setComment(message);
		
		editDiscussionDAO.InsertComment(d, conn);
		
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
