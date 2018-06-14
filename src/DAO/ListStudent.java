package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Bean.ViewListStudent;

public class ListStudent {

public static List<ViewListStudent> ViewListStudents(Connection conn,int class_id){
		
		List<ViewListStudent> list= new ArrayList<ViewListStudent>();
		
		String sql= " select * "+""
				+ "from account,(select account_id, point from student_class where confirm='1' and class_id= '"+class_id+"')as A"+
		" where account.account_id=A.account_id ";
		
		try {
			PreparedStatement ptmt= conn.prepareStatement(sql);
			
			ResultSet rs= ptmt.executeQuery();
			
			while(rs.next()){
				
				String account_id=rs.getString("account_id");
				String name=rs.getString("name");
				String birthday=rs.getString("birthday");
				String sex=rs.getString("sex");
				String mail=rs.getString("mail");
				String point=rs.getString("point");
				
				
				ViewListStudent student= new ViewListStudent();
				
				student.setAccount_id(account_id);
				student.setName(name);
				student.setBirthday(birthday);
				student.setSex(sex);
				student.setMail(mail);
				student.setPoint(point);
				
				list.add(student);
				
			}
		
		} catch (SQLException e) {
			e.printStackTrace();
		}
			
		return list;
	}
}
