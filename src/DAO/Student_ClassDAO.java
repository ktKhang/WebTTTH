package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Student_ClassDAO {

	public static boolean InsertStudent_Class(Connection conn, int Account_id, int Class_id)
	{
		String sql = "insert into student_class(account_id, class_id) value(?,?)";

		try {
			PreparedStatement ptmt = conn.prepareStatement(sql);
			
			ptmt.setInt(1, Account_id);
			ptmt.setInt(2, Class_id);

			int kt = ptmt.executeUpdate();
			if (kt != 0) {
				return true;
			} else {
				return false;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
}
