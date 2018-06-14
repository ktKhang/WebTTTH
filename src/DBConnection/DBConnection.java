package DBConnection;
import java.sql.*;
public class DBConnection {
	public static Connection CreateConnection(){
		Connection conn = null;
		try{
			Class.forName("com.mysql.jdbc.Driver");
			//conn = DriverManager.getConnection("jdbc:mysql://node6037-ttthweb.ocs.opusinteractive.io/web_ttth?useUnicode=true&characterEncoding=UTF-8","root","QEFskb64114");
			conn = DriverManager.getConnection("jdbc:mysql://localhost/web_ttth","root","123");
		}
		catch (Exception ex){
			System.out.println("Error connection " + ex);
		}
		return conn;
	}
}