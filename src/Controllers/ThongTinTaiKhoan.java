package Controllers;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/ThongTinTaiKhoan")
public class ThongTinTaiKhoan extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ThongTinTaiKhoan() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int roleID = Integer.parseInt(request.getParameter("roleID"));
		System.out.println(roleID);
		
			//
			if(roleID == 2) {
				RequestDispatcher rd= request.getRequestDispatcher("/WEB-INF/ThongTinTaiKhoan_Teacher.jsp");
				rd.forward(request, response);
			}
			else if(roleID == 3) {
				RequestDispatcher rd= request.getRequestDispatcher("/WEB-INF/ThongTinTaiKhoan_user.jsp");
				rd.forward(request, response);
			}
			else {
				RequestDispatcher rd= request.getRequestDispatcher("login");
				rd.forward(request, response);
			}
		
		
	}

}
