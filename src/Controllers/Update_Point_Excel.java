package Controllers;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.ReadExcel;

/**
 * Servlet implementation class Update_Point_Excel
 */
@WebServlet("/Update_Point_Excel")
public class Update_Point_Excel extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Update_Point_Excel() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println(request.getParameter("uploadFile"));
				
		System.out.println(request.getParameter("uploadFile"));
		if(request.getParameter("uploadFile")==null)
		{
			RequestDispatcher rd= request.getRequestDispatcher("/WEB-INF/Login.jsp");
			rd.forward(request, response);
		}
		else
		{
			String s1=request.getParameter("uploadFile");
			String s2= s1.replaceAll("\\\\", "/");
			System.out.println(s2);
			int id_class=Integer.parseInt(request.getParameter("class_id"));
			try {
				ReadExcel.xuly(s2, id_class);
				System.out.println("update thành công");
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				System.out.println("lỗi: ");
				e.printStackTrace();
			}
			
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
