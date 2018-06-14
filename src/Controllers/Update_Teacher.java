package Controllers;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Bean.Account;
import DAO.UserDAO;

@WebServlet("/Update_Teacher")
public class Update_Teacher extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
    public Update_Teacher() {
        super();
        
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		if(request.getSession().getAttribute("account")!=null) {
			doPost(request, response);
		}
		
		else {
			response.sendRedirect("login");
		}
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		String name=(String)request.getParameter("name");
		System.out.println(name);
		String birthday=(String)request.getParameter("birthday");
		System.out.println(birthday);
		String mail=(String)request.getParameter("mail");
		System.out.println(mail);
		String sdt=(String)request.getParameter("sdt");
		System.out.println(sdt);
		String sex=(String)request.getParameter("gender");
		System.out.println(sex);
		Account user=new Account();
		user.setName(name);
		user.setBirthday(birthday);
		user.setMail(mail);
		user.setPhonenumber(sdt);
		user.setSex(sex);
		if(request.getSession().getAttribute("account") ==null) {
			response.sendRedirect("login");
		}
	    Account acc=(Account) request.getSession().getAttribute("account");
		int account_id1=acc.getAccount_id();
		user.setAccount_id(account_id1);
		user.setAvatar(acc.getAvatar());
		
		UserDAO.updateUser(user);
		
		request.getSession().removeAttribute("account");
		request.getSession().setAttribute("account",user);
		
		request.getRequestDispatcher("/WEB-INF/ThongTinTaiKhoan_Teacher.jsp").forward(request, response);
		
	}

}
