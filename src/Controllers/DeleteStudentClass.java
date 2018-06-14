package Controllers;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.UserDAO;


@WebServlet("/DeleteStudentClass")
public class DeleteStudentClass extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
 
    public DeleteStudentClass() {
        super();
        
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		String sc_id1=(String)request.getParameter("sc_id");
		System.out.println(sc_id1);
		int sc_id=Integer.parseInt(sc_id1);
		UserDAO.DeleteStudentClass(sc_id);
		request.getRequestDispatcher("/WEB-INF/ThongTinTaiKhoan_user.jsp").forward(request, response);
	}

}
