package DAO;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import Bean.Account;
import Bean.user;
import DBConnection.DBConnection;

public class UserDAO {
	
	  public static void updateUser(Account user) {
	        try {
	            PreparedStatement preparedStatement = DBConnection.CreateConnection().prepareStatement(
	            		"update account set name=?, birthday=?, mail=?, phonenumber=?, sex=?"
	                    + "where account_id=?");
	            // Parameters start with 1
	            preparedStatement.setString(1, user.getName());
	            preparedStatement.setString(2, user.getBirthday());
	            preparedStatement.setString(3, user.getMail());
	            preparedStatement.setString(4, user.getPhonenumber());
	            preparedStatement.setString(5, user.getSex());
	            preparedStatement.setInt(6, user.getAccount_id());
	           
	            preparedStatement.executeUpdate();
	 
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	    }
	  
	  public static void updatePass(user user) {
	        try {
	            PreparedStatement preparedStatement = DBConnection.CreateConnection().prepareStatement("update account set password=?"
	                    + "where account_id=? ");
	            // Parameters start with 1
	            preparedStatement.setString(1, user.getPassword());
	            preparedStatement.setInt(2, user.getAccount_id());
	           
	            preparedStatement.executeUpdate();
	 
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	    }
	 

	public static boolean Update_User(String name,String birthday,String mail, String sdt,int account_id) {
		String sql="update account set name=N'"+name+"', birthday=N'"+birthday+"', mail=N'"+mail+"', sdt=N'"+sdt+"' where account_id='"+account_id+"'";
		boolean bl=false;
		Connection conn = DBConnection.CreateConnection();
		try {
			PreparedStatement ps= conn.prepareCall(sql);
			bl =ps.execute();
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		return bl;
	}
	public static boolean Update_Password(String newpass,int account_id) {
		String sql="update account set pass=N'"+newpass+"' where account_id='"+account_id+"'";
		boolean bl=false;
		Connection conn = DBConnection.CreateConnection();
		try {
			PreparedStatement ps= conn.prepareCall(sql);
			bl =ps.execute();
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		return bl;
	}
	public static boolean UpdateAvatar(int account_id, String avatar, Connection conn)
	{
		String sql = "update account set  Avatar=? where account_id='"+account_id+"';";
		
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
	 public static void DeleteStudentClass(int sc_id) {
	        try {
	            PreparedStatement preparedStatement = DBConnection.CreateConnection().prepareStatement("Delete From student_class Where sc_id =?");
	            // Parameters start with 1
	            preparedStatement.setInt(1, sc_id);
	            preparedStatement.execute();
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	    }
}
