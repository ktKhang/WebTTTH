package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import Bean.course;

public class editCourseDAO {
	public static boolean InsertCourse(course r, Connection conn) {
		String sql = "INSERT INTO course (coursename, description, info, fee, topic_id) "
				+ "VALUES (?, ?, ?, ?, ?);\r\n" + 
				"";
		
			try {
			
			PreparedStatement ptmt = conn.prepareStatement(sql);
			
			ptmt.setString(1, r.getCoursename());
			ptmt.setString(2, r.getDescription());
			ptmt.setString(3, r.getInfo());
			ptmt.setDouble(4, r.getFee());
			ptmt.setInt(5, r.getTopic_id());
			
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
	public static boolean UpdateCourse(course r, Connection conn) {
		String sql = "update course set  coursename=?, description=?, info=?, "
				+ " fee=?, topic_id=? where course_id='"+r.getCourse_id()+"';";
		
			try {
			
			PreparedStatement ptmt = conn.prepareStatement(sql);
			
			ptmt.setString(1, r.getCoursename());
			ptmt.setString(2, r.getDescription());
			ptmt.setString(3, r.getInfo());
			ptmt.setDouble(4, r.getFee());
			ptmt.setInt(5, r.getTopic_id());
			
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
	public static boolean UpdateImage(String course_id, String avatar, Connection conn)
	{
		String sql = "update course set  courseimage=? where course_id='"+course_id+"';";
		
		try {
		
			PreparedStatement ptmt = conn.prepareStatement(sql);
			
			ptmt.setString(1, avatar);
			
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
	public static boolean DeleteCourse (List<String> listDel, Connection conn) {
		
		boolean t = false;
		try {
			
			for(String acceptThem:listDel) {
				String sql = "Delete from course "+
						" WHERE course_id = '"+acceptThem+"'";
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
