package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Bean.user;

public class loadUserDAO {
	public static List<user> LoadAllUsers(String username, Connection conn){
		List<user> list= new ArrayList<user>();
		
		String sql= "SELECT account_id, accountname, password, name, birthday, sex, mail, phonenumber, avatar, rolename"
				+ " FROM account join role on account.role_id = role.role_id"
				+ " where accountname <> '"+username+"';";
		
		try {
			PreparedStatement ptmt= conn.prepareStatement(sql);
			
			ResultSet rs= ptmt.executeQuery();
			
			while(rs.next()){
				int account_id = rs.getInt("account_id");
				String accountname= rs.getString("accountname");
				String password=rs.getString("password");
				String name=rs.getString("name");
				String birthday=rs.getString("birthday");
				String sex=rs.getString("sex");
				String mail=rs.getString("mail");
				String phonenumber=rs.getString("phonenumber");
				String avatar=rs.getString("avatar");
				String rolename= rs.getString("rolename");
				
				
				user r= new user();
				
				r.setAccount_id(account_id);
				r.setAccountname(accountname);
				r.setPassword(password);
				r.setName(name);
				r.setBirthday(birthday);
				r.setSex(sex);
				r.setMail(mail);
				r.setPhonenumber(phonenumber);
				r.setAvatar(avatar);
				r.setRolename(rolename);
				
				list.add(r);
				
			}
		
		} catch (SQLException e) {
			e.printStackTrace();
		}
			
		return list;
	}
	public static List<user> LoadAccountBasedonRole(String username, int roleID, Connection conn){
		List<user> list= new ArrayList<user>();
		String sql="";
		if(roleID == 4) {
			sql= "SELECT account_id, accountname, password, name, birthday, sex, mail, phonenumber, avatar, rolename"
					+ " FROM account join role on account.role_id = role.role_id"
					+ " where accountname <> '"+username+"';";
		}
		else {
			sql= "SELECT account_id, accountname, password, name, birthday, sex, mail, phonenumber, avatar, rolename"
					+ " FROM account join role on account.role_id = role.role_id"
					+ " where account.role_id = '"+roleID+"' and accountname <> '"+username+"';";
		}
		try {
			PreparedStatement ptmt= conn.prepareStatement(sql);
			
			ResultSet rs= ptmt.executeQuery();
			
			while(rs.next()){
				int account_id = rs.getInt("account_id");
				String accountname= rs.getString("accountname");
				String password=rs.getString("password");
				String name=rs.getString("name");
				String birthday=rs.getString("birthday");
				String sex=rs.getString("sex");
				String mail=rs.getString("mail");
				String phonenumber=rs.getString("phonenumber");
				String avatar=rs.getString("avatar");
				String rolename= rs.getString("rolename");
				
				
				user r= new user();
				
				r.setAccount_id(account_id);
				r.setAccountname(accountname);
				r.setPassword(password);
				r.setName(name);
				r.setBirthday(birthday);
				r.setSex(sex);
				r.setMail(mail);
				r.setPhonenumber(phonenumber);
				r.setAvatar(avatar);
				r.setRolename(rolename);
				
				list.add(r);
				
			}
		
		} catch (SQLException e) {
			e.printStackTrace();
		}
			
		return list;
	}
	public static List<user> SearchAccount(String username, String search, Connection conn){
		List<user> list= new ArrayList<user>();
		
		String sql="";
		if(search == null) {
			sql= "SELECT account_id, accountname, password, name, birthday, sex, mail, phonenumber, avatar, rolename"
				+ " FROM account join role on account.role_id = role.role_id"
				+ " where accountname <> '"+username+"';";
		}
		else {
			sql= "SELECT account_id, accountname, password, name, birthday, sex, mail, phonenumber, avatar, rolename"
					+ " FROM account join role on account.role_id = role.role_id"
					+ " where accountname <> '"+username+"' and "
					+ "( accountname LIKE N'%"+search+"%' or name LIKE N'%"+search+"%' or rolename LIKE N'%"+search+"%' )";
		}
		try {
			PreparedStatement ptmt= conn.prepareStatement(sql);
			
			ResultSet rs= ptmt.executeQuery();
			
			while(rs.next()){
				int account_id = rs.getInt("account_id");
				String accountname= rs.getString("accountname");
				String password=rs.getString("password");
				String name=rs.getString("name");
				String birthday=rs.getString("birthday");
				String sex=rs.getString("sex");
				String mail=rs.getString("mail");
				String phonenumber=rs.getString("phonenumber");
				String avatar=rs.getString("avatar");
				String rolename= rs.getString("rolename");
				
				
				user r= new user();
				
				r.setAccount_id(account_id);
				r.setAccountname(accountname);
				r.setPassword(password);
				r.setName(name);
				r.setBirthday(birthday);
				r.setSex(sex);
				r.setMail(mail);
				r.setPhonenumber(phonenumber);
				r.setAvatar(avatar);
				r.setRolename(rolename);
				
				list.add(r);
				
			}
		
		} catch (SQLException e) {
			e.printStackTrace();
		}
			
		return list;
	}
	public static user LoadAccountInfo(String accountID, Connection conn){
		
		user r= new user();
		String sql = null;
		sql= "SELECT * FROM account" + 
				" WHERE account_id = '"+accountID+"'";
		try {
			PreparedStatement ptmt= conn.prepareStatement(sql);
			
			ResultSet rs= ptmt.executeQuery();
			
			while(rs.next()){
				int account_id= rs.getInt("account_id");
				String accountname= rs.getString("accountname");
				String name=rs.getString("name");
				String birthday=rs.getString("birthday");
				String sex=rs.getString("sex");
				String mail=rs.getString("mail");
				String phonenumber=rs.getString("phonenumber");
				String avatar=rs.getString("avatar");
				int role_id= rs.getInt("role_id");
				
				r.setAccount_id(account_id);
				r.setAccountname(accountname);
				r.setName(name);
				r.setBirthday(birthday);
				r.setSex(sex);
				r.setMail(mail);
				r.setPhonenumber(phonenumber);
				r.setAvatar(avatar);
				r.setRole_id(role_id);
			}
		
		} catch (SQLException e) {
			e.printStackTrace();
		}
			
		return r;
	}
}
