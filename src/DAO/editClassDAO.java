package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import Bean.Class;

public class editClassDAO {
	public static boolean InsertClass(Class r, Connection conn) {
		String sql = "INSERT INTO class (classname, startday, endday, timestudy, location, number_of_students, testday, course_id) "
				+ "VALUES (?, ?, ?, ?, ?, ?, ?, ?);\r\n" + 
				"";
		
			try {
			
			PreparedStatement ptmt = conn.prepareStatement(sql);
			
			ptmt.setString(1, r.getClassname());
			ptmt.setString(2, r.getStartday());
			ptmt.setString(3, r.getEndday());
			ptmt.setString(4, r.getTimestudy());
			ptmt.setString(5, r.getLocation());
			ptmt.setInt(6, r.getNumber_of_students());
			ptmt.setString(7, r.getTestday());
			ptmt.setInt(8, r.getCourse_id());
			
			int kt = ptmt.executeUpdate();

			if(kt!=0){
				
				return true;
			}
			ptmt.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("Error :"+e.getMessage());
		}

		return false;
	}
	public static boolean DeleteClass (List<String> listDel, Connection conn) {
		
		boolean t = false;
		try {
			
			for(String acceptThem:listDel) {
				String sql = "Delete from class "+
						" WHERE class_id = '"+acceptThem+"'";
				PreparedStatement stmt = conn.prepareStatement(sql);
				stmt.executeUpdate();
			}
			t = true;
		}

		catch (Exception e) {
			e.printStackTrace();
		}
		return t;
	}
	public static boolean DeleteTeacher_Class(int tc_id, Connection conn) {

		boolean t = false;

		String sql = "Delete From teacher_class Where tc_id =?";

		try {
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setInt(1, tc_id);
			stmt.executeUpdate();
			t = true;
		}

		catch (Exception e) {
			e.printStackTrace();
		}
		return t;
	}
	public static boolean AddTeacher_Class(List<String> listDel, String classID, Connection conn) {
		
		boolean t = false;
		try {
			
			for(String acceptThem:listDel) {
				String sql = "INSERT INTO teacher_class (account_id, class_id) VALUES ('"+acceptThem+"', '"+classID+"');";
				PreparedStatement stmt = conn.prepareStatement(sql);
				stmt.executeUpdate();
			}
			t = true;
		}

		catch (Exception e) {
			e.printStackTrace();
		}
		return t;
	}
	public static boolean UpdateClass(Class r, Connection conn) {
		String sql = "update `class` set  classname=?, startday=?, endday=?, timestudy=?, location=?,"
				+ " testday=? where class_id='"+r.getClass_id()+"';";
		
			try {
			
			PreparedStatement ptmt = conn.prepareStatement(sql);
			
			ptmt.setString(1, r.getClassname());
			ptmt.setString(2, r.getStartday());
			ptmt.setString(3, r.getEndday());
			ptmt.setString(4, r.getTimestudy());
			ptmt.setString(5, r.getLocation());
			ptmt.setString(6, r.getTestday());
			
			int kt = ptmt.executeUpdate();

			if(kt!=0){
				
				return true;
			}
			ptmt.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("Error :"+e.getMessage());
		}

		return false;
	}
	public static boolean DeleteStudent_Class(List<String> listDel, Connection conn) {
		
		boolean t = false;
		try {
			
			for(String acceptThem:listDel) {
				String sql = "Delete From student_class Where sc_id ='"+acceptThem+"'";
				PreparedStatement stmt = conn.prepareStatement(sql);
				stmt.executeUpdate();
			}
			t = true;
		}

		catch (Exception e) {
			e.printStackTrace();
		}
		return t;
	}
	public static boolean AcceptStudent(List<String> listDel, Connection conn) {
		
		boolean t = false;
		try {
			
			for(String acceptThem:listDel) {
				String sql = "Update student_class set confirm = 1 "
						+ "Where sc_id ='"+acceptThem+"'";
				PreparedStatement stmt = conn.prepareStatement(sql);
				stmt.executeUpdate();
			}
			t = true;
		}

		catch (Exception e) {
			e.printStackTrace();
		}
		return t;
	}
}
