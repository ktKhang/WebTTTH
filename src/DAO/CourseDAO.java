package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Bean.course;

public class CourseDAO {

	public static List<course> LoadKhoaHoc(Connection conn){
		
		List<course> list= new ArrayList<course>();
		
		String sql= "SELECT * from course";
		
		try {
			PreparedStatement ptmt= conn.prepareStatement(sql);
			
			ResultSet rs= ptmt.executeQuery();
			
			while(rs.next()){
				
				int course_id=rs.getInt("course_id");
				String coursename=rs.getString("coursename");
				String courseimage=rs.getString("courseimage");
				String description=rs.getString("description");
				String info=rs.getString("info");
				Double fee=rs.getDouble("fee");
				int topic_id=rs.getInt("topic_id");
				
				course course= new course();
				course.setCourse_id(course_id);
				course.setCoursename(coursename);
				course.setCourseimage(courseimage);
				course.setDescription(description);
				course.setInfo(info);
				course.setFee(fee);
				course.setTopic_id(topic_id);
				
				list.add(course);
				
			}
		
		} catch (SQLException e) {
			e.printStackTrace();
		}
			
		return list;
	}
	public static List<course> getCoursebyTopicID(Connection conn, int Strtopic_id){
		
		List<course> list= new ArrayList<course>();
		
		String sql= "SELECT * from course WHERE topic_id= ?";
		
		try {
			PreparedStatement ptmt= conn.prepareStatement(sql);
			ptmt.setInt(1, Strtopic_id);
			
			ResultSet rs= ptmt.executeQuery();
			
			while(rs.next()){
				
				int course_id=rs.getInt("course_id");
				String coursename=rs.getString("coursename");
				String courseimage=rs.getString("courseimage");
				String description=rs.getString("description");
				String info=rs.getString("info");
				Double fee=rs.getDouble("fee");
				int topic_id=rs.getInt("topic_id");
				
				course course= new course();
				course.setCourse_id(course_id);
				course.setCoursename(coursename);
				course.setCourseimage(courseimage);
				course.setDescription(description);
				course.setInfo(info);
				course.setFee(fee);
				course.setTopic_id(topic_id);
				
				list.add(course);
				
			}
		
		} catch (SQLException e) {
			e.printStackTrace();
		}
			
		return list;
	}
	public static course getCoursebyCourseID(Connection conn, int StrCourse_id){
		
		course course= new course();
		
		String sql= "SELECT * from course WHERE course_id= ?";
		
		try {
			PreparedStatement ptmt= conn.prepareStatement(sql);
			ptmt.setInt(1, StrCourse_id);
			
			ResultSet rs= ptmt.executeQuery();
			
			if(rs.next()){
				
				course.setCourse_id(rs.getInt("course_id"));
				course.setCoursename(rs.getString("coursename"));
				course.setCourseimage(rs.getString("courseimage"));
				course.setDescription(rs.getString("description"));
				course.setInfo(rs.getString("info"));
				course.setFee(rs.getDouble("fee"));
				course.setTopic_id(rs.getInt("topic_id"));
				
			}
		
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return course;
	}
	
}
