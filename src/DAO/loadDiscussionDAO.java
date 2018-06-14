package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Bean.comment;
import Bean.discussion;
import Bean.topicDiscussion;
import Bean.user;

public class loadDiscussionDAO {
	public static List<discussion> LoadListDiscussion(int topicID ,Connection conn){
		List<discussion> list= new ArrayList<discussion>();
		
		String sql= "select discussion_id, SUBSTRING(title, 1, 35) as title, SUBSTRING(content, 1, 35) as content, name, postdate, reply, avatar, discussion.account_id from discussion join account on discussion.account_id = account.account_id\r\n" + 
				"where discussiontopic_id = '"+topicID+"' order by postdate desc limit 50;";
		
		try {
			PreparedStatement ptmt= conn.prepareStatement(sql);
			
			ResultSet rs= ptmt.executeQuery();
			
			while(rs.next()){
				int discussion_id= rs.getInt("discussion_id");
				String title= rs.getString("title");
				String postedby=rs.getString("name");
				String postdate=rs.getString("postdate");
				int reply=rs.getInt("reply");
				String avatar=rs.getString("avatar");
				String content=rs.getString("content");
				int account_id = rs.getInt("account_id");

				discussion r= new discussion();
				
				r.setDiscussion_id(discussion_id);
				r.setTitle(title);
				r.setPostedby(postedby);
				r.setPostdate(postdate);
				r.setReply(reply);
				r.setAvatar(avatar);
				r.setAccount_id(account_id);
				r.setContent(content);
				
				list.add(r);
				
			}
		
		} catch (SQLException e) {
			e.printStackTrace();
		}
			
		return list;
	}
	public static List<topicDiscussion> LoadListTopic(int threadID ,Connection conn){
		List<topicDiscussion> list= new ArrayList<topicDiscussion>();
		
		String sql= "select * from discussion_topic" + 
				" where discussionthread_id = '"+threadID+"';";
		
		try {
			PreparedStatement ptmt= conn.prepareStatement(sql);
			
			ResultSet rs= ptmt.executeQuery();
			
			while(rs.next()){
				int discussiontopic_id= rs.getInt("discussiontopic_id");
				String discussiontopic_name= rs.getString("discussiontopic_name");
				int discussionthread_id=rs.getInt("discussionthread_id");

				topicDiscussion r= new topicDiscussion();
				
				r.setDiscussiontopic_id(discussiontopic_id);
				r.setDiscussiontopic_name(discussiontopic_name);
				r.setDiscussionthread_id(discussionthread_id);
				
				list.add(r);
				
			}
		
		} catch (SQLException e) {
			e.printStackTrace();
		}
			
		return list;
	}
	public static List<user> LoadListAccountDiscussion(int topicID ,Connection conn){
		List<user> list= new ArrayList<user>();
		
		String sql= "select account.account_id, name, birthday, sex, mail, phonenumber, avatar from discussion join account on discussion.account_id = account.account_id\r\n" + 
				"where discussiontopic_id = '"+topicID+"' order by postdate desc limit 50;";
		
		try {
			PreparedStatement ptmt= conn.prepareStatement(sql);
			
			ResultSet rs= ptmt.executeQuery();
			
			while(rs.next()){
				int account_id = rs.getInt("account_id");
				String name= rs.getString("name");
				String birthday=rs.getString("birthday");
				String sex=rs.getString("sex");
				String mail=rs.getString("mail");
				String phonenumber=rs.getString("phonenumber");
				String avatar=rs.getString("avatar");

				user r= new user();
				
				r.setAccount_id(account_id);
				r.setName(name);
				r.setBirthday(birthday);
				r.setSex(sex);
				r.setMail(mail);
				r.setPhonenumber(phonenumber);
				r.setAvatar(avatar);
				
				list.add(r);
				
			}
		
		} catch (SQLException e) {
			e.printStackTrace();
		}
			
		return list;
	}
	public static discussion LoadDiscussionInfo(String discussionID, Connection conn){
		
		discussion r= new discussion();
		String sql = null;
		sql= "select discussion_id, title, content, name, postdate, reply, avatar, account.account_id, sex, birthday, mail, phonenumber from discussion join account on discussion.account_id = account.account_id" 
				+ " where discussion_id = '"+discussionID+"'";
		try {
			PreparedStatement ptmt= conn.prepareStatement(sql);
			
			ResultSet rs= ptmt.executeQuery();
			
			while(rs.next()){
				int discussion_id= rs.getInt("discussion_id");
				String title= rs.getString("title");
				String content= rs.getString("content");
				String postedby=rs.getString("name");
				String postdate=rs.getString("postdate");
				String avatar=rs.getString("avatar");
				int account_id = rs.getInt("account_id");
				int reply = rs.getInt("reply");
				String sex = rs.getString("sex");
				String birthday = rs.getString("birthday");
				String mail = rs.getString("mail");
				String phonenumber = rs.getString("phonenumber");
				
				r.setDiscussion_id(discussion_id);
				r.setTitle(title);
				r.setContent(content);
				r.setReply(reply);
				r.setPostedby(postedby);
				r.setPostdate(postdate);
				r.setAvatar(avatar);
				r.setAccount_id(account_id);
				r.setSex(sex);
				r.setBirthday(birthday);
				r.setMail(mail);
				r.setPhonenumber(phonenumber);
				
			}
		
		} catch (SQLException e) {
			e.printStackTrace();
		}
			
		return r;
	}
	public static List<comment> LoadListComments(String discussionID ,Connection conn){
		List<comment> list= new ArrayList<comment>();
		
		String sql= "select comment_id, account_comment.account_id, name, avatar, discussion_id, time, comment, sex, birthday, mail, phonenumber from account_comment join account on account_comment.account_id = account.account_id\r\n" + 
				"where discussion_id = '"+discussionID+"' order by time desc limit 40;";
		
		try {
			PreparedStatement ptmt= conn.prepareStatement(sql);
			
			ResultSet rs= ptmt.executeQuery();
			
			while(rs.next()){
				int comment_id= rs.getInt("comment_id");
				int account_id= rs.getInt("account_id");
				String name=rs.getString("name");
				String avatar=rs.getString("avatar");
				int discussion_id=rs.getInt("discussion_id");
				String time=rs.getString("time");
				String comment=rs.getString("comment");
				String sex = rs.getString("sex");
				String birthday = rs.getString("birthday");
				String mail = rs.getString("mail");
				String phonenumber = rs.getString("phonenumber");

				comment r= new comment();
				
				r.setComment_id(comment_id);
				r.setAccount_id(account_id);
				r.setName(name);
				r.setAvatar(avatar);
				r.setDiscussion_id(discussion_id);
				r.setTime(time);
				r.setComment(comment);
				r.setSex(sex);
				r.setBirthday(birthday);
				r.setMail(mail);
				r.setPhonenumber(phonenumber);
				
				list.add(r);
				
			}
		
		} catch (SQLException e) {
			e.printStackTrace();
		}
			
		return list;
	}
}
