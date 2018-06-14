package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import Bean.user;

public class editUserDAO {
	public static boolean UpdateUser(user us ,Connection conn)
	{
		String sql = "update account set  name=?, birthday=?, sex=?, "
				+ "mail=?, phonenumber=?  where accountname='"+us.getAccountname()+"';";
		
			try {
			
			PreparedStatement ptmt = conn.prepareStatement(sql);
			
			ptmt.setString(1, us.getName());
			ptmt.setString(2, us.getBirthday());
			ptmt.setString(3, us.getSex());
			ptmt.setString(4, us.getMail());
			ptmt.setString(5, us.getPhonenumber());
			
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
	public static boolean UpdatePassword(user us ,Connection conn)
	{
		String sql = "update account set  password=? where accountname='"+us.getAccountname()+"';";
		
			try {
			
			PreparedStatement ptmt = conn.prepareStatement(sql);
			
			ptmt.setString(1, us.getPassword());
			
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
	public static boolean UpdateAvatar(String username, String avatar, Connection conn)
	{
		String sql = "update account set  avatar=? where accountname='"+username+"';";
		
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
	public static boolean DeleteAccount (List<String> listDel, Connection conn) {
		
		boolean t = false;
		try {
			
			for(String acceptThem:listDel) {
				String sql = "Delete from account "+
						" WHERE account_id = '"+acceptThem+"'";
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
	public static boolean ResetPassword (List<String> listDel, Connection conn) {
		
		boolean t = false;
		try {
			
			for(String acceptThem:listDel) {
				String sql = "Update account set password='000'"+
						" WHERE account_id = '"+acceptThem+"'";
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
	public static boolean InsertAccount(user r, Connection conn) {
		String sql = "INSERT INTO account (accountname, password, name, birthday, sex, mail, phonenumber, role_id)"
				+ " VALUES (?, ?, ?, ?, ?, ?, ?, ?); ";
		
			try {
			
			PreparedStatement ptmt = conn.prepareStatement(sql);
			
			ptmt.setString(1, r.getAccountname());
			ptmt.setString(2, r.getPassword());
			ptmt.setString(3, r.getName());
			ptmt.setString(4, r.getBirthday());
			ptmt.setString(5, r.getSex());
			ptmt.setString(6, r.getMail());
			ptmt.setString(7, r.getPhonenumber());
			ptmt.setInt(8, r.getRole_id());
			
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
	public static boolean UpdateRoleAccount(String account_id, String role_id ,Connection conn)
	{
		String sql = "update account set role_id = '"+role_id+"' where account_id='"+account_id+"';";
		
			try {
			
			PreparedStatement ptmt = conn.prepareStatement(sql);
			
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
}
