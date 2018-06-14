package DAO;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import Bean.Account;
import DBConnection.DBConnection;

public class AccountDAO {
	public static Boolean Insert_Account(Account account){
		Boolean flag=false;
		try {
			
            PreparedStatement preparedStatement = DBConnection.CreateConnection().prepareStatement(
            		"insert into account(accountname,role_id,password,name,birthday,sex,mail,phonenumber) value(?,?,?,?,?,?,?,?)");
            // Parameters start with 1
            preparedStatement.setString(1, account.getAccountname());
            preparedStatement.setInt(2, 3);
            preparedStatement.setString(3, account.getPassword());
            preparedStatement.setString(4, account.getName());
            preparedStatement.setString(5, account.getBirthday());
            preparedStatement.setString(6, account.getSex());
            preparedStatement.setString(7, account.getMail());
            preparedStatement.setString(8, account.getPhonenumber());
            preparedStatement.executeUpdate();
            flag=true;
 
        } catch (SQLException e) {
            e.printStackTrace();
            flag=false;
        }
		return flag;
	}
	

}
