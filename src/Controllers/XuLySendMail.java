package Controllers;


import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.SendMail;

@WebServlet("/XuLySendMail")
public class XuLySendMail extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public XuLySendMail() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");
		String name=request.getParameter("name");
		String mail=request.getParameter("email");
		String title=request.getParameter("topic");
		String content=request.getParameter("message");
		String Pass=request.getParameter("passEmail");
		SendMail send=new SendMail();
		try {
			send.send("smtp.gmail.com", "daothimy46@gmail.com", mail, Pass,
			       title, "From: "+name+", " +content);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		response.sendRedirect(request.getContextPath() + "/Contact");
		
	}

}
