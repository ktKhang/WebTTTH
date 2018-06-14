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

import Bean.comment;
import Bean.discussion;
import DAO.editDiscussionDAO;
import DAO.loadDiscussionDAO;
import DBConnection.DBConnection;

@WebServlet("/deleteComments")
public class deleteComments extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public deleteComments() {
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
			
			String[] cmtDel = request.getParameterValues("cmtDel[]");
			
			List<String> listDel =  Arrays.asList(cmtDel);
			
			boolean flag = editDiscussionDAO.DeleteComments(listDel, conn);
			if(flag==true) {
				message="Xóa thành công";
			}
			else {
				message="Lỗi!";
			}
			//load lại trang list comments
			String discussionID = request.getParameter("discussionID");
			discussion c = new discussion();
			
			List<comment> listCmt = loadDiscussionDAO.LoadListComments(discussionID, conn);
			c = loadDiscussionDAO.LoadDiscussionInfo(discussionID, conn);
			
			request.setAttribute("threadID", request.getParameter("thread"));
			request.setAttribute("name", request.getParameter("name"));
			request.setAttribute("disInfo", c);
			request.setAttribute("listCmt", listCmt);
			request.setAttribute("message", message);
			
			
			RequestDispatcher rd= request.getRequestDispatcher("/WEB-INF/admin_listComments.jsp");
			rd.forward(request, response);
		}
	}

}
