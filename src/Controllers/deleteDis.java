package Controllers;

import java.io.IOException;
import java.sql.Connection;
import java.util.Arrays;
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

@WebServlet("/deleteDis")
public class deleteDis extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public deleteDis() {
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
			String message="";
			
			String[] newsDel = request.getParameterValues("newsDel[]");
			
			List<String> listDel =  Arrays.asList(newsDel);
			
			boolean flag = editDiscussionDAO.DeletePost(listDel, conn);
			if(flag==true) {
				message="Xóa thành công";
			}
			else {
				message="Lỗi!";
			}
			//load lại trang forum content
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
			request.setAttribute("message", message);
			
			RequestDispatcher rd= request.getRequestDispatcher("/WEB-INF/admin_forum_content.jsp");
			rd.forward(request, response);
		}
	}

}
