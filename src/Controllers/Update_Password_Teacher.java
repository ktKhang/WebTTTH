package Controllers;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Bean.Account;
import Bean.user;
import DAO.UserDAO;

@WebServlet("/Update_Password_Teacher")
public class Update_Password_Teacher extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
    public Update_Password_Teacher() {
        super();
      
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String passnew=(String)request.getParameter("MKCap2");
		user user=new user();
		
		user.setPassword(passnew);
		Account acc=(Account)request.getSession().getAttribute("account");
		int account_id1=acc.getAccount_id();
		user.setAccount_id(account_id1);
		UserDAO.updatePass(user);
		request.getRequestDispatcher("/WEB-INF/ThongTinTaiKhoan_Teacher.jsp").forward(request, response);
	}

}
