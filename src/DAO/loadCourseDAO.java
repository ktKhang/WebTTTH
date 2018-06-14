package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Bean.course;

public class loadCourseDAO {
	public static List<course> LoadListCourses(Connection conn){
		List<course> list= new ArrayList<course>();
		
		String sql= "SELECT course_id, coursename, courseimage, SUBSTRING(description, 1, 30) as description, info, fee, topic_id\r\n" + 
				" FROM course";
		
		try {
			PreparedStatement ptmt= conn.prepareStatement(sql);
			
			ResultSet rs= ptmt.executeQuery();
			
			while(rs.next()){
				int course_id= rs.getInt("course_id");
				String coursename= rs.getString("coursename");
				String courseimage=rs.getString("courseimage");
				String description=rs.getString("description");
				String info=rs.getString("info");
				double fee=rs.getDouble("fee");
				int topic_id= rs.getInt("topic_id");

				course r= new course();
				
				r.setCourse_id(course_id);
				r.setCoursename(coursename);
				r.setCourseimage(courseimage);
				r.setDescription(description);
				r.setInfo(info);
				r.setFee(fee);
				r.setTopic_id(topic_id);
				
				list.add(r);
				
			}
		
		} catch (SQLException e) {
			e.printStackTrace();
		}
			
		return list;
	}
	public static course LoadCourseInfo(String courseID, Connection conn){
		
		course r= new course();
		String sql = null;
		sql= "SELECT * FROM course" + 
				" WHERE course_id = '"+courseID+"'";
		try {
			PreparedStatement ptmt= conn.prepareStatement(sql);
			
			ResultSet rs= ptmt.executeQuery();
			
			while(rs.next()){
				int course_id= rs.getInt("course_id");
				String coursename= rs.getString("coursename");
				String courseimage = rs.getString("courseimage");
				String description=rs.getString("description");
				String info = rs.getString("info");
				Double fee = rs.getDouble("fee");
				int topic_id= rs.getInt("topic_id");
				
				r.setCourse_id(course_id);
				r.setCoursename(coursename);
				r.setCourseimage(courseimage);
				r.setDescription(description);
				r.setInfo(info);
				r.setFee(fee);
				r.setTopic_id(topic_id);
			}
		
		} catch (SQLException e) {
			e.printStackTrace();
		}
			
		return r;
	}
	public static List<course> SearchCourse(String searchCourse, Connection conn){
		
		List<course> list= new ArrayList<course>();
		String sql = null;
		if(searchCourse ==null) {
			sql = "SELECT * from course";
		}
		else {
		sql= "SELECT * from course"
				+ " WHERE coursename LIKE N'%"+searchCourse+"%' OR fee LIKE N'%"+searchCourse+"%'";
		}
		
		try {
			PreparedStatement ptmt= conn.prepareStatement(sql);
			
			ResultSet rs= ptmt.executeQuery();
			
			while(rs.next()){
				int course_id= rs.getInt("course_id");
				String coursename= rs.getString("coursename");
				String courseimage=rs.getString("courseimage");
				String description=rs.getString("description");
				String info=rs.getString("info");
				double fee=rs.getDouble("fee");
				int topic_id= rs.getInt("topic_id");

				course r= new course();
				
				r.setCourse_id(course_id);
				r.setCoursename(coursename);
				r.setCourseimage(courseimage);
				r.setDescription(description);
				r.setInfo(info);
				r.setFee(fee);
				r.setTopic_id(topic_id);
				
				list.add(r);
				
			}
		
		} catch (SQLException e) {
			e.printStackTrace();
		}
			
		return list;
	}
	public static List<course> LoadCourseBasedonTopic(int topicID, Connection conn){
		List<course> list= new ArrayList<course>();
		String sql="";
		if(topicID == 0) {
			sql= "SELECT * FROM course";
		}
		else {
			sql= "SELECT * FROM course WHERE topic_id = "+topicID+"";
		}
		try {
			PreparedStatement ptmt= conn.prepareStatement(sql);
			
			ResultSet rs= ptmt.executeQuery();
			
			while(rs.next()){
				int course_id= rs.getInt("course_id");
				String coursename= rs.getString("coursename");
				String courseimage=rs.getString("courseimage");
				String description=rs.getString("description");
				String info=rs.getString("info");
				double fee=rs.getDouble("fee");
				int topic_id= rs.getInt("topic_id");

				course r= new course();
				
				r.setCourse_id(course_id);
				r.setCoursename(coursename);
				r.setCourseimage(courseimage);
				r.setDescription(description);
				r.setInfo(info);
				r.setFee(fee);
				r.setTopic_id(topic_id);
				
				list.add(r);
				
			}
		
		} catch (SQLException e) {
			e.printStackTrace();
		}
			
		return list;
	}
}	
