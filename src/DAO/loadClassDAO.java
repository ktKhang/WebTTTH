package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Bean.Class;
import Bean.student;
import Bean.teacher;
import Bean.user;

public class loadClassDAO {
	public static List<Class> LoadListClasses(Connection conn){
		List<Class> list= new ArrayList<Class>();
		
		String sql= "SELECT * FROM class";
		
		try {
			PreparedStatement ptmt= conn.prepareStatement(sql);
			
			ResultSet rs= ptmt.executeQuery();
			
			while(rs.next()){
				int class_id= rs.getInt("class_id");
				String classname= rs.getString("classname");
				String startday=rs.getString("startday");
				String endday=rs.getString("endday");
				String timestudy=rs.getString("timestudy");
				String location=rs.getString("location");
				int number_of_students= rs.getInt("number_of_students");
				String testday=rs.getString("testday");
				int course_id= rs.getInt("course_id");

				Class r= new Class();
				
				r.setClass_id(class_id);
				r.setClassname(classname);
				r.setStartday(startday);
				r.setEndday(endday);
				r.setTimestudy(timestudy);
				r.setLocation(location);
				r.setNumber_of_students(number_of_students);
				r.setTestday(testday);
				r.setCourse_id(course_id);
				
				list.add(r);
				
			}
		
		} catch (SQLException e) {
			e.printStackTrace();
		}
			
		return list;
	}
	public static List<Class> SearchClass(String searchClass, Connection conn){
		
		List<Class> list= new ArrayList<Class>();
		String sql = null;
		if(searchClass ==null) {
			sql = "SELECT * from class";
		}
		else {
		sql= "SELECT * from class"
				+ " WHERE classname LIKE N'%"+searchClass+"%' OR startday LIKE N'%"+searchClass+"%' OR location LIKE N'%"+searchClass+"%'";
		}
		
		try {
			PreparedStatement ptmt= conn.prepareStatement(sql);
			
			ResultSet rs= ptmt.executeQuery();
			
			while(rs.next()){
				int class_id= rs.getInt("class_id");
				String classname= rs.getString("classname");
				String startday=rs.getString("startday");
				String endday=rs.getString("endday");
				String timestudy=rs.getString("timestudy");
				String location=rs.getString("location");
				int number_of_students= rs.getInt("number_of_students");
				String testday=rs.getString("testday");
				int course_id= rs.getInt("course_id");

				Class r= new Class();
				
				r.setClass_id(class_id);
				r.setClassname(classname);
				r.setStartday(startday);
				r.setEndday(endday);
				r.setTimestudy(timestudy);
				r.setLocation(location);
				r.setNumber_of_students(number_of_students);
				r.setTestday(testday);
				r.setCourse_id(course_id);
				
				list.add(r);
				
			}
		
		} catch (SQLException e) {
			e.printStackTrace();
		}
			
		return list;
	}
	public static List<Class> LoadClassBasedonCourse(int courseID, Connection conn){
		List<Class> list= new ArrayList<Class>();
		String sql="";
		if(courseID == 0) {
			sql= "SELECT * FROM class";
		}
		else {
			sql= "SELECT * FROM class WHERE course_id = "+courseID+"";
		}
		try {
			PreparedStatement ptmt= conn.prepareStatement(sql);
			
			ResultSet rs= ptmt.executeQuery();
			
			while(rs.next()){
				int class_id= rs.getInt("class_id");
				String classname= rs.getString("classname");
				String startday=rs.getString("startday");
				String endday=rs.getString("endday");
				String timestudy=rs.getString("timestudy");
				String location=rs.getString("location");
				int number_of_students= rs.getInt("number_of_students");
				String testday=rs.getString("testday");
				int course_id= rs.getInt("course_id");

				Class r= new Class();
				
				r.setClass_id(class_id);
				r.setClassname(classname);
				r.setStartday(startday);
				r.setEndday(endday);
				r.setTimestudy(timestudy);
				r.setLocation(location);
				r.setNumber_of_students(number_of_students);
				r.setTestday(testday);
				r.setCourse_id(course_id);
				
				list.add(r);
				
			}
		
		} catch (SQLException e) {
			e.printStackTrace();
		}
			
		return list;
	}
	public static Class LoadClassInfo(String classID, Connection conn){
		
		Class r= new Class();
		String sql = null;
		sql= "SELECT * FROM class" + 
				" WHERE class_id = '"+classID+"'";
		try {
			PreparedStatement ptmt= conn.prepareStatement(sql);
			
			ResultSet rs= ptmt.executeQuery();
			
			while(rs.next()){
				int class_id= rs.getInt("class_id");
				String classname= rs.getString("classname");
				String startday=rs.getString("startday");
				String endday=rs.getString("endday");
				String timestudy=rs.getString("timestudy");
				String location=rs.getString("location");
				int number_of_students= rs.getInt("number_of_students");
				String testday=rs.getString("testday");
				int course_id= rs.getInt("course_id");
				
				r.setClass_id(class_id);
				r.setClassname(classname);
				r.setStartday(startday);
				r.setEndday(endday);
				r.setTimestudy(timestudy);
				r.setLocation(location);
				r.setNumber_of_students(number_of_students);
				r.setTestday(testday);
				r.setCourse_id(course_id);
			}
		
		} catch (SQLException e) {
			e.printStackTrace();
		}
			
		return r;
	}
	public static Class LoadClassInfo2(String classID, Connection conn){
		
		Class r= new Class();
		String sql = null;
		sql= "select class_id, classname, startday, endday, timestudy, location, number_of_students, testday, class.course_id, coursename from class join course on class.course_id = course.course_id\r\n" + 
				"where class_id = '"+classID+"'";
		try {
			PreparedStatement ptmt= conn.prepareStatement(sql);
			
			ResultSet rs= ptmt.executeQuery();
			
			while(rs.next()){
				int class_id= rs.getInt("class_id");
				String classname= rs.getString("classname");
				String startday=rs.getString("startday");
				String endday=rs.getString("endday");
				String timestudy=rs.getString("timestudy");
				String location=rs.getString("location");
				int number_of_students= rs.getInt("number_of_students");
				String testday=rs.getString("testday");
				int course_id= rs.getInt("course_id");
				String coursename=rs.getString("coursename");
				
				r.setClass_id(class_id);
				r.setClassname(classname);
				r.setStartday(startday);
				r.setEndday(endday);
				r.setTimestudy(timestudy);
				r.setLocation(location);
				r.setNumber_of_students(number_of_students);
				r.setTestday(testday);
				r.setCourse_id(course_id);
				r.setCoursename(coursename);
			}
		
		} catch (SQLException e) {
			e.printStackTrace();
		}
			
		return r;
	}
	//load danh sách giảng viên của 1 lớp
	public static List<teacher> LoadListTeachers(String classID, Connection conn){
		
		List<teacher> list= new ArrayList<teacher>();
		String sql= "SELECT tc_id, name, mail FROM teacher_class join account on teacher_class.account_id = account.account_id\r\n" + 
				"where class_id = '"+classID+"'";
		
		try {
			PreparedStatement ptmt= conn.prepareStatement(sql);
			
			ResultSet rs= ptmt.executeQuery();
			
			while(rs.next()){
				int tc_id= rs.getInt("tc_id");
				String name= rs.getString("name");
				String mail=rs.getString("mail");

				teacher r= new teacher();
				
				r.setTc_id(tc_id);
				r.setName(name);
				r.setMail(mail);
				
				list.add(r);
				
			}
		
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return list;
	}
	//load các giảng viên ko dạy lớp đó
	public static List<user> LoadAllTeachers(String classID, Connection conn){
		
		List<user> list= new ArrayList<user>();
		String sql= "select account_id, name, mail from account where role_id='2' and account_id not in "
				+ "(select account_id from teacher_class where class_id = '"+classID+"')";
		
		try {
			PreparedStatement ptmt= conn.prepareStatement(sql);
			
			ResultSet rs= ptmt.executeQuery();
			
			while(rs.next()){
				int account_id= rs.getInt("account_id");
				String name= rs.getString("name");
				String mail=rs.getString("mail");

				user r= new user();
				
				r.setAccount_id(account_id);
				r.setName(name);
				r.setMail(mail);
				
				list.add(r);
				
			}
		
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return list;
	}
	//load danh sách học viên của 1 lớp
		public static List<student> LoadListStudents(String classID, Connection conn){
			
			List<student> list= new ArrayList<student>();
			String sql= "select sc_id, name, birthday, sex, phonenumber, mail, avatar, point, confirm from student_class join account on student_class.account_id = account.account_id\r\n" + 
					"where confirm = 1 and class_id = '"+classID+"'";
			
			try {
				PreparedStatement ptmt= conn.prepareStatement(sql);
				
				ResultSet rs= ptmt.executeQuery();
				
				while(rs.next()){
					int sc_id= rs.getInt("sc_id");
					String name= rs.getString("name");
					String birthday=rs.getString("birthday");
					String sex=rs.getString("sex");
					String phonenumber=rs.getString("phonenumber");
					String mail=rs.getString("mail");
					String avatar=rs.getString("avatar");
					float point=rs.getFloat("point");
					boolean confirm=rs.getBoolean("confirm");

					student s= new student();
					
					s.setSc_id(sc_id);
					s.setName(name);
					s.setBirthday(birthday);
					s.setSex(sex);
					s.setPhonenumber(phonenumber);
					s.setMail(mail);
					s.setAvatar(avatar);
					s.setPoint(point);
					s.setConfirm(confirm);
					
					list.add(s);
					
				}
			
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
			return list;
		}
		//load toàn bộ danh sách học viên trong các lớp
		public static List<student> LoadAllStudents(Connection conn){
			
			List<student> list= new ArrayList<student>();
			String sql= "select sc_id, name, phonenumber, mail, avatar, confirm, classname, coursename from course, class, student_class, account\r\n" + 
					" where course.course_id = class.course_id and class.class_id = student_class.class_id" + 
					" and student_class.account_id = account.account_id and confirm = 1";
			
			try {
				PreparedStatement ptmt= conn.prepareStatement(sql);
				
				ResultSet rs= ptmt.executeQuery();
				
				while(rs.next()){
					int sc_id= rs.getInt("sc_id");
					String name= rs.getString("name");
					String phonenumber=rs.getString("phonenumber");
					String mail=rs.getString("mail");
					String avatar=rs.getString("avatar");
					boolean confirm=rs.getBoolean("confirm");
					String classname=rs.getString("classname");
					String coursename=rs.getString("coursename");

					student s= new student();
					
					s.setSc_id(sc_id);
					s.setName(name);
					s.setPhonenumber(phonenumber);
					s.setMail(mail);
					s.setAvatar(avatar);
					s.setConfirm(confirm);
					s.setRegisteredClass(classname);
					s.setRegisteredCourse(coursename);
					
					list.add(s);
					
				}
			
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
			return list;
		}
		//load danh sách học viên gửi đơn đăng kí
		public static List<student> LoadAllStudents2(Connection conn){
			
			List<student> list= new ArrayList<student>();
			String sql= "select sc_id, name, phonenumber, mail, avatar, confirm, classname, coursename from course, class, student_class, account\r\n" + 
					" where course.course_id = class.course_id and class.class_id = student_class.class_id" + 
					" and student_class.account_id = account.account_id and confirm = 0";
			
			try {
				PreparedStatement ptmt= conn.prepareStatement(sql);
				
				ResultSet rs= ptmt.executeQuery();
				
				while(rs.next()){
					int sc_id= rs.getInt("sc_id");
					String name= rs.getString("name");
					String phonenumber=rs.getString("phonenumber");
					String mail=rs.getString("mail");
					String avatar=rs.getString("avatar");
					boolean confirm=rs.getBoolean("confirm");
					String classname=rs.getString("classname");
					String coursename=rs.getString("coursename");

					student s= new student();
					
					s.setSc_id(sc_id);
					s.setName(name);
					s.setPhonenumber(phonenumber);
					s.setMail(mail);
					s.setAvatar(avatar);
					s.setConfirm(confirm);
					s.setRegisteredClass(classname);
					s.setRegisteredCourse(coursename);
					
					list.add(s);
					
				}
			
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
			return list;
		}
}
