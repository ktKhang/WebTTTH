package Controllers;

import java.io.IOException;
import java.sql.Connection;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import DAO.ClassDAO;
import DBConnection.DBConnection;

@WebServlet("/Register_Class")
public class Register_Class extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public Register_Class() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");
		HttpSession session = request.getSession();
		if(session.getAttribute("account")==null)
		{
			//
			request.setAttribute("errorStr", "Vui lòng đăng nhập trc khi đăng kí lớp khác!!!");
			//
            RequestDispatcher dispatcher //
                    = this.getServletContext().getRequestDispatcher("/WEB-INF/Login.jsp");
            dispatcher.forward(request, response);
		}
		else
		{
			Connection conn = DBConnection.CreateConnection();
			//lấy thông tin từ resquest
			String class_id=(String)request.getParameter("class_id");
			String course_name=(String)request.getParameter("course_name");
			String fee=(String) request.getParameter("fee");
			int classID=Integer.parseInt(class_id);
			//
			Bean.Class class1 = ClassDAO.getInfobyClassID(conn, classID);
			request.setAttribute("class1", class1);
			request.setAttribute("course_name", course_name);
			request.setAttribute("fee",fee);
			//
			RequestDispatcher rd= request.getRequestDispatcher("/WEB-INF/Khoa1.jsp");
			rd.forward(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
