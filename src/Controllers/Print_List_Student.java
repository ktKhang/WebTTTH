package Controllers;

import java.io.IOException;
import java.sql.Connection;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.JFileChooser;

import Bean.ViewListStudent;
import DAO.ListStudent;
import DAO.WriteExcel;
import DBConnection.DBConnection;


@WebServlet("/Print_List_Student")
public class Print_List_Student extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
    public Print_List_Student() {
        super();
      
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int cla= Integer.parseInt((String) request.getParameter("list"));
		System.out.println(cla);
		String acc=request.getParameter("list1");
		
		JFileChooser f = new JFileChooser();
        f.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY); 
        f.showSaveDialog(null);
        System.out.println(f.getSelectedFile());
        String s2= f.getSelectedFile().toString().replaceAll("\\\\", "/");
        System.out.println(s2);
		String excelFilePath = s2+"/DanhSach_students_"+cla+".xlsx";
		System.out.println(excelFilePath);
		
		Connection conn = DBConnection.CreateConnection();
		List<Bean.ViewListStudent> listBook = (List<ViewListStudent>) ListStudent.ViewListStudents(conn, cla);
		WriteExcel.writeExcel(listBook,excelFilePath);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
