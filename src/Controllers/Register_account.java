package Controllers;

import java.io.IOException;
import Controllers.*;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Bean.Account;
import DAO.AccountDAO;

@WebServlet("/Register_account")
public class Register_account extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public Register_account() {
        super();
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher rd= request.getRequestDispatcher("/WEB-INF/Register.jsp");
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8");
		//Lấy thông tin request
		String accountname=request.getParameter("username1"); 
		String password= MD5.encryption(request.getParameter("password0")); 
		String name=request.getParameter("name");
		String birthday=request.getParameter("birthday");
		String sex=request.getParameter("sex");
		String mail=request.getParameter("email");
		String phonenumber=request.getParameter("phonenumber");
		
		Account acc=new Account();
		acc.setAccountname(accountname);
		acc.setPassword(password);
		acc.setName(name);
		
		acc.setBirthday(birthday);
		acc.setPhonenumber(phonenumber);
		acc.setSex(sex);
		acc.setMail(mail);
		
		if(AccountDAO.Insert_Account(acc))
		{
			request.setAttribute("errorStr","Đăng ký thành công vui lòng đăng nhập lại !!!");
			RequestDispatcher dispatcher //
            = this.getServletContext().getRequestDispatcher("/WEB-INF/Login.jsp");
			dispatcher.forward(request, response);
		}
		else
		{
			response.sendRedirect(request.getContextPath() + "/TrangChu");
		}
		
	}

}
