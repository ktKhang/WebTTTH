package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import DBConnection.DBConnection;

public class ListClass {

	public static boolean Update_Point(int account_id,int class_id,String point) {
		String sql="update student_class set point=N'"+point+"' where account_id='"+account_id+"' and class_id='"+class_id+"'";
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
}
