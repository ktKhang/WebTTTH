package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import Bean.comment;
import Bean.discussion;

public class editDiscussionDAO {
	public static boolean InsertDiscussion(discussion r, Connection conn) {
		String sql = "INSERT INTO discussion (title, content, postdate, discussiontopic_id, account_id) "
				+ " VALUES (?, ?, CURDATE(), ?, ?);";
		
			try {
			
			PreparedStatement ptmt = conn.prepareStatement(sql);
			
			ptmt.setString(1, r.getTitle());
			ptmt.setString(2, r.getContent());
			ptmt.setInt(3, r.getDiscussiontopic_id());
			ptmt.setInt(4, r.getAccount_id());
			
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
	public static boolean InsertComment(comment r, Connection conn) {
		String sql = "INSERT INTO account_comment (account_id, discussion_id, time, comment) "
				+ " VALUES (?, ?, NOW(), ?);";
		
			try {
			
			PreparedStatement ptmt = conn.prepareStatement(sql);
			
			ptmt.setInt(1, r.getAccount_id());
			ptmt.setInt(2, r.getDiscussion_id());
			ptmt.setString(3, r.getComment());
			
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
	public static boolean DeletePost (List<String> listDel, Connection conn) {
		
		boolean t = false;
		try {
			
			for(String acceptThem:listDel) {
				String sql = "Delete from discussion "+
						" WHERE discussion_id = '"+acceptThem+"'";
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
	public static boolean DeleteComments (List<String> listDel, Connection conn) {
		
		boolean t = false;
		try {
			
			for(String acceptThem:listDel) {
				String sql = "Delete from account_comment "+
						" WHERE comment_id = '"+acceptThem+"'";
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
}
