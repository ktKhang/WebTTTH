package DAO;

import java.sql.*;

import com.mysql.jdbc.PreparedStatement;

import Bean.user;
import DBConnection.DBConnection;

public class loginDAO {
	
	// Lấy thông tin user
	public static user getUserInfo(String username) {
		Connection con = DBConnection.CreateConnection();
		String sql = "select * from account where accountname='"+username+"'";
		user us = new user();
		try {
			PreparedStatement ps = (PreparedStatement) con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				int account_id = rs.getInt("account_id");
				String usname = rs.getString("accountname");
				String password = rs.getString("password").trim();
				String name = rs.getString("name");
				String birthday = rs.getString("birthday");
				String sex = rs.getString("sex");
				String email = rs.getString("mail");
				String phonenumber = rs.getString("phonenumber");
				String avatar = rs.getString("avatar");
				us = new user(account_id,usname,password,name,birthday,sex,email,phonenumber,avatar);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return us;
	}
}
