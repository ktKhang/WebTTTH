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
import DAO.editDiscussionDAO;
import DAO.loadDiscussionDAO;
import DBConnection.DBConnection;

@WebServlet("/addPostInfo")
public class addPostInfo extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public addPostInfo() {
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
			request.setCharacterEncoding("UTF-8");
			Connection conn = DBConnection.CreateConnection();
			String message="";
			
	        discussion c = new discussion();
            c.setAccount_id(Integer.parseInt(request.getParameter("account_id")));
            c.setTitle(request.getParameter("title"));
            c.setContent(request.getParameter("content"));
            c.setDiscussiontopic_id(Integer.parseInt(request.getParameter("listTopic")));
            
            boolean flag = editDiscussionDAO.InsertDiscussion(c, conn);
            if(flag == true) {
    			message= "Thêm thành công!";
    		}
    		else {
    			message= "Thêm thất bại!";
    		}
            
            // load lại trang forum admin
            int threadID = Integer.parseInt(request.getParameter("threadID"));
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
			request.setAttribute("message", message);
			
			RequestDispatcher rd= request.getRequestDispatcher("/WEB-INF/admin_forum_content.jsp");
			rd.forward(request, response);
		}
	}

}
