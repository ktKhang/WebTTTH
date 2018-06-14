package Controllers;

import java.io.IOException;
import Controllers.*;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Bean.Account;
import Bean.user;
import DAO.TestLogin;
import DAO.loginDAO;

@WebServlet("/login")
public class login extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public login() {
        super();
    }

    //Hiá»ƒn thá»‹ trang Login
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		RequestDispatcher rd= request.getRequestDispatcher("/WEB-INF/Login.jsp");
		rd.forward(request, response);
	}

	//Thá»±c thi Submit
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String userName = request.getParameter("userName");
        String password = MD5.encryption(request.getParameter("password"));
        String rememberStr = request.getParameter("remember");
        //Kiểm tra người dùng có check remember không
        boolean remember = "Y".equals(rememberStr);
        
        Account user = null;
        boolean hasError = false;
        String errorStr = null;
        try {
			user=TestLogin.TestAccount(userName,password);
			if(user==null)
			{
				hasError=true;
				errorStr="Tên đăng nhập hoặc mật khẩu không chính xác!!!";
			}
		} catch (SQLException e) {
			e.printStackTrace();
			hasError=true;
			errorStr=e.getMessage();
		}
        if(hasError){//trường hợp có lỗi
			request.setAttribute("errorStr", errorStr);
			request.setAttribute("account", user);
            RequestDispatcher dispatcher //
                    = this.getServletContext().getRequestDispatcher("/WEB-INF/Login.jsp");
            dispatcher.forward(request, response);
        }
        else
        {
        	
            if (remember) {
                Cookie cookie=new Cookie("nameCookie",user.getAccountname());
                cookie.setMaxAge(3*24*60*60);
                response.addCookie(cookie);
            }
            else {
                Cookie cookie=new Cookie("nameCookie",null);
                cookie.setMaxAge(0);
                response.addCookie(cookie);
            }
			if(user.getRole_id()==2||user.getRole_id()==3)//user
			{
				HttpSession session = request.getSession();
				session.setAttribute("account",user);
	            response.sendRedirect(request.getContextPath() + "/TrangChu");
			}
			else if(user.getRole_id()==1)
			{
				HttpSession session = request.getSession();
				session.setAttribute("username", userName);
				
				user us = new user();
				us= loginDAO.getUserInfo(userName);
				session.setAttribute("adminName", us.getName());
				session.setAttribute("adminAvatar", us.getAvatar());
				session.setAttribute("adminID", us.getAccount_id());
				System.out.println(us.getName());
				request.setAttribute("adminInfo", us);
			
				RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/admin_info.jsp");
				rd.forward(request, response);
			}
        }
        
	}

}
