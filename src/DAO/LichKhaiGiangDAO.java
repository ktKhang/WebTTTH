package DAO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Bean.user;
import Bean.course;
import Bean.LichKhaiGiang;
import DBConnection.DBConnection;

public class LichKhaiGiangDAO {
	public static List<LichKhaiGiang> LoadLichKhaiGiangs(Connection conn){
		
		List<LichKhaiGiang> list= new ArrayList<LichKhaiGiang>();
		
		String sql= "SELECT * from class where course_id='1'";
		
		try {
			PreparedStatement ptmt= conn.prepareStatement(sql);
			
			ResultSet rs= ptmt.executeQuery();
			
			while(rs.next()){
				int class_id=rs.getInt("class_id");
				String classname= rs.getString("classname");
				String timestudy=rs.getString("timestudy");
				String startday=rs.getString("startday");
				String location=rs.getString("location");
				
				LichKhaiGiang lkg= new LichKhaiGiang();
				
				lkg.setClass_id(class_id);
				lkg.setClassname(classname);
				lkg.setTimestudy(timestudy);
				lkg.setStartday(startday);
				lkg.setLocation(location);
				
				
				
				list.add(lkg);
				
			}
		
		} catch (SQLException e) {
			e.printStackTrace();
		}
			
		return list;
	}
	public static List<LichKhaiGiang> LoadThietKeDoHoa(Connection conn){
		
		List<LichKhaiGiang> list= new ArrayList<LichKhaiGiang>();
		
		String sql= "SELECT * from class where course_id='2'";
		
		try {
			PreparedStatement ptmt= conn.prepareStatement(sql);
			
			ResultSet rs= ptmt.executeQuery();
			
			while(rs.next()){
				int class_id=rs.getInt("class_id");
				String classname= rs.getString("classname");
				String timestudy=rs.getString("timestudy");
				String startday=rs.getString("startday");
				String location=rs.getString("location");
				
				LichKhaiGiang lkg= new LichKhaiGiang();
				
				lkg.setClass_id(class_id);
				lkg.setClassname(classname);
				lkg.setTimestudy(timestudy);
				lkg.setStartday(startday);
				lkg.setLocation(location);
				
				
				
				list.add(lkg);
				
			}
		
		} catch (SQLException e) {
			e.printStackTrace();
		}
			
		return list;
	}
	public static List<LichKhaiGiang> LoadTinHocVanPhong(Connection conn){
		
		List<LichKhaiGiang> list= new ArrayList<LichKhaiGiang>();
		
		String sql= "SELECT * from class where course_id='3'";
		
		try {
			PreparedStatement ptmt= conn.prepareStatement(sql);
			
			ResultSet rs= ptmt.executeQuery();
			
			while(rs.next()){
				int class_id=rs.getInt("class_id");
				String classname= rs.getString("classname");
				String timestudy=rs.getString("timestudy");
				String startday=rs.getString("startday");
				String location=rs.getString("location");
				
				LichKhaiGiang lkg= new LichKhaiGiang();
				
				lkg.setClass_id(class_id);
				lkg.setClassname(classname);
				lkg.setTimestudy(timestudy);
				lkg.setStartday(startday);
				lkg.setLocation(location);
				
				
				
				list.add(lkg);
				
			}
		
		} catch (SQLException e) {
			e.printStackTrace();
		}
			
		return list;
	}
	public static List<LichKhaiGiang> LoadLapTrinhDiDong(Connection conn){
		
		List<LichKhaiGiang> list= new ArrayList<LichKhaiGiang>();
		
		String sql= "SELECT * from class where course_id='4'";
		
		try {
			PreparedStatement ptmt= conn.prepareStatement(sql);
			
			ResultSet rs= ptmt.executeQuery();
			
			while(rs.next()){
				int class_id=rs.getInt("class_id");
				String classname= rs.getString("classname");
				String timestudy=rs.getString("timestudy");
				String startday=rs.getString("startday");
				String location=rs.getString("location");
				
				LichKhaiGiang lkg= new LichKhaiGiang();
				
				lkg.setClass_id(class_id);
				lkg.setClassname(classname);
				lkg.setTimestudy(timestudy);
				lkg.setStartday(startday);
				lkg.setLocation(location);
				
				
				
				list.add(lkg);
				
			}
		
		} catch (SQLException e) {
			e.printStackTrace();
		}
			
		return list;
	}
	public static List<LichKhaiGiang> LoadMangMayTinh(Connection conn){
		
		List<LichKhaiGiang> list= new ArrayList<LichKhaiGiang>();
		
		String sql= "SELECT * from class where course_id='5'";
		
		try {
			PreparedStatement ptmt= conn.prepareStatement(sql);
			
			ResultSet rs= ptmt.executeQuery();
			
			while(rs.next()){
				int class_id=rs.getInt("class_id");
				String classname= rs.getString("classname");
				String timestudy=rs.getString("timestudy");
				String startday=rs.getString("startday");
				String location=rs.getString("location");
				
				LichKhaiGiang lkg= new LichKhaiGiang();
				
				lkg.setClass_id(class_id);
				lkg.setClassname(classname);
				lkg.setTimestudy(timestudy);
				lkg.setStartday(startday);
				lkg.setLocation(location);
				
				
				
				list.add(lkg);
				
			}
		
		} catch (SQLException e) {
			e.printStackTrace();
		}
			
		return list;
	}
	public static List<LichKhaiGiang> LoadThietKeCoSoDuLieu(Connection conn){
		
		List<LichKhaiGiang> list= new ArrayList<LichKhaiGiang>();
		
		String sql= "SELECT * from class where course_id='6'";
		
		try {
			PreparedStatement ptmt= conn.prepareStatement(sql);
			
			ResultSet rs= ptmt.executeQuery();
			
			while(rs.next()){
				int class_id=rs.getInt("class_id");
				String classname= rs.getString("classname");
				String timestudy=rs.getString("timestudy");
				String startday=rs.getString("startday");
				String location=rs.getString("location");
				
				LichKhaiGiang lkg= new LichKhaiGiang();
				
				lkg.setClass_id(class_id);
				lkg.setClassname(classname);
				lkg.setTimestudy(timestudy);
				lkg.setStartday(startday);
				lkg.setLocation(location);
				
				
				
				list.add(lkg);
				
			}
		
		} catch (SQLException e) {
			e.printStackTrace();
		}
			
		return list;
	}
	public static List<LichKhaiGiang> LoadLapTrinhWeb(Connection conn){
		
		List<LichKhaiGiang> list= new ArrayList<LichKhaiGiang>();
		
		String sql= "SELECT * from class where course_id='7'";
		
		try {
			PreparedStatement ptmt= conn.prepareStatement(sql);
			
			ResultSet rs= ptmt.executeQuery();
			
			while(rs.next()){
				int class_id=rs.getInt("class_id");
				String classname= rs.getString("classname");
				String timestudy=rs.getString("timestudy");
				String startday=rs.getString("startday");
				String location=rs.getString("location");
				
				LichKhaiGiang lkg= new LichKhaiGiang();
				
				lkg.setClass_id(class_id);
				lkg.setClassname(classname);
				lkg.setTimestudy(timestudy);
				lkg.setStartday(startday);
				lkg.setLocation(location);
				
				
				
				list.add(lkg);
				
			}
		
		} catch (SQLException e) {
			e.printStackTrace();
		}
			
		return list;
	}
	public static List<LichKhaiGiang> LoadTinHocChoTre(Connection conn){
		
		List<LichKhaiGiang> list= new ArrayList<LichKhaiGiang>();
		
		String sql= "SELECT * from class where course_id='8'";
		
		try {
			PreparedStatement ptmt= conn.prepareStatement(sql);
			
			ResultSet rs= ptmt.executeQuery();
			
			while(rs.next()){
				int class_id=rs.getInt("class_id");
				String classname= rs.getString("classname");
				String timestudy=rs.getString("timestudy");
				String startday=rs.getString("startday");
				String location=rs.getString("location");
				
				LichKhaiGiang lkg= new LichKhaiGiang();
				
				lkg.setClass_id(class_id);
				lkg.setClassname(classname);
				lkg.setTimestudy(timestudy);
				lkg.setStartday(startday);
				lkg.setLocation(location);
				
				
				
				list.add(lkg);
				
			}
		
		} catch (SQLException e) {
			e.printStackTrace();
		}
			
		return list;
	}
	public LichKhaiGiang getClass(int class_id) {
		Connection con = DBConnection.CreateConnection();
		String sql = "select * from class where class_id='" + class_id + "'";
		LichKhaiGiang lkg = new LichKhaiGiang();
		try {
			PreparedStatement ps = (PreparedStatement) con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				String classname=rs.getString("classname");
				String timestudy=rs.getString("timestudy");
				String startday=rs.getString("startday");
				String location=rs.getString("location");
				lkg = new LichKhaiGiang(class_id,classname,timestudy,startday,location);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return lkg;
	}
	public user getUser(int account_id) {
		Connection con = DBConnection.CreateConnection();
		String sql = "select * from account where account_id='" + account_id + "'";
		user us = new user();
		try {
			PreparedStatement ps = (PreparedStatement) con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				String name=rs.getString("name");
				System.out.println(name);
				String phonenumber=rs.getString("phonenumber");
				String mail=rs.getString("mail");
				System.out.println(name);
				String birthday=rs.getString("birthday");
				String sex=rs.getString("sex");
				String avatar=rs.getString("avatar");
				us = new user(account_id,name,phonenumber,mail,birthday,sex,avatar);
			}
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return us;
	}
	public course getCourse(int class_id) {
		Connection con = DBConnection.CreateConnection();
		String sql = "select coursename from course where course_id= (select course_id from class where class_id='" + class_id + "')";
		course course = new course();
		try {
			PreparedStatement ps = (PreparedStatement) con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
			
				String coursename=rs.getString("coursename");
				
				course = new course(coursename);
			}
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return course;
	}
	
	
	
	
}
