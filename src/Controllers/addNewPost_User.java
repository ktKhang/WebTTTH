package Controllers;

import java.io.IOException;
import java.sql.Connection;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Bean.discussion;
import DAO.editDiscussionDAO;
import DBConnection.DBConnection;

@WebServlet("/addNewPost_User")
public class addNewPost_User extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public addNewPost_User() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		Connection conn = DBConnection.CreateConnection();
		
		int topicID = Integer.parseInt(request.getParameter("topicID"));
		
        discussion c = new discussion();
        c.setTitle(request.getParameter("title"));
        c.setContent(request.getParameter("content"));
        c.setAccount_id(Integer.parseInt(request.getParameter("accountID")));
        c.setDiscussiontopic_id(topicID);
        
        editDiscussionDAO.InsertDiscussion(c, conn);
        
        if(topicID == 1 || topicID == 2 || topicID == 3) {
	        request.setAttribute("topicID", request.getParameter("topicID"));
	        RequestDispatcher rd= request.getRequestDispatcher("user_thaoluan_daisanh");
			rd.forward(request, response);
        }
        if(topicID == 6 || topicID == 7 || topicID == 8) {
	        request.setAttribute("topicID", request.getParameter("topicID"));
	        RequestDispatcher rd= request.getRequestDispatcher("user_thaoluan_goccongnghe");
			rd.forward(request, response);
        }
        if(topicID == 4 || topicID == 5) {
	        request.setAttribute("topicID", request.getParameter("topicID"));
	        RequestDispatcher rd= request.getRequestDispatcher("user_thaoluan_goclaptrinh");
			rd.forward(request, response);
        }
        if(topicID == 9 || topicID == 10) {
	        request.setAttribute("topicID", request.getParameter("topicID"));
	        RequestDispatcher rd= request.getRequestDispatcher("user_thaoluan_khugiaitri");
			rd.forward(request, response);
        }
        if(topicID == 11) {
	        request.setAttribute("topicID", request.getParameter("topicID"));
	        RequestDispatcher rd= request.getRequestDispatcher("user_thaoluan_thuongmaivamuaban");
			rd.forward(request, response);
        }
	}

}
