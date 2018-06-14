package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Bean.News;

public class NewsDAO {

	public static List<News> LoadTinTuc(Connection conn){
		
		List<News> list= new ArrayList<News>();
		
		String sql= "SELECT news_id, title, date, content_news, image, news.account_id, type_id, name from news join account on news.account_id = account.account_id"
				+ " ORDER BY date DESC";
		
		try {
			PreparedStatement ptmt= conn.prepareStatement(sql);
			
			ResultSet rs= ptmt.executeQuery();
			
			while(rs.next()){
				
				int news_id=rs.getInt("news_id");
				String title=rs.getString("title");
				String date=rs.getString("date");
				String content_news=rs.getString("content_news");
				String image=rs.getString("image");
				int account_id=rs.getInt("account_id");
				int type_id=rs.getInt("type_id");
				String name=rs.getString("name");
				
				News news= new News();
				news.setNews_id(news_id);
				news.setTitle(title);
				news.setDate(date);
				news.setContent_news(content_news);
				news.setImage(image);
				news.setAccount_id(account_id);
				news.setType_id(type_id);
				news.setName(name);
				
				list.add(news);
				
			}
		
		} catch (SQLException e) {
			e.printStackTrace();
		}
			
		return list;
	}
	public static List<News> LoadListNewsAdmin(Connection conn){
		
		List<News> list= new ArrayList<News>();
		
		String sql= "SELECT news_id, SUBSTRING(title, 1, 35) as title, date, SUBSTRING(content_news, 1, 35) as content_news , image, news.account_id, type_id, name from news join account on news.account_id = account.account_id"
				+ " ORDER BY date DESC";
		
		try {
			PreparedStatement ptmt= conn.prepareStatement(sql);
			
			ResultSet rs= ptmt.executeQuery();
			
			while(rs.next()){
				
				int news_id=rs.getInt("news_id");
				String title=rs.getString("title");
				String date=rs.getString("date");
				String content_news=rs.getString("content_news");
				String image=rs.getString("image");
				int account_id=rs.getInt("account_id");
				int type_id=rs.getInt("type_id");
				String name=rs.getString("name");
				
				News news= new News();
				news.setNews_id(news_id);
				news.setTitle(title);
				news.setDate(date);
				news.setContent_news(content_news);
				news.setImage(image);
				news.setAccount_id(account_id);
				news.setType_id(type_id);
				news.setName(name);
				
				list.add(news);
				
			}
		
		} catch (SQLException e) {
			e.printStackTrace();
		}
			
		return list;
	}
	public static List<News> LoadNewsBasedonType(int typeID, Connection conn){
		
		List<News> list= new ArrayList<News>();
		String sql ="";
		if(typeID == 0) {
			sql= "SELECT news_id, SUBSTRING(title, 1, 35) as title, date, SUBSTRING(content_news, 1, 35) as content_news , image, news.account_id, type_id, name from news join account on news.account_id = account.account_id"
					+ " ORDER BY date DESC";
		}
		else {
			sql= "SELECT news_id, SUBSTRING(title, 1, 35) as title, date, SUBSTRING(content_news, 1, 35) as content_news , image, news.account_id, type_id, name from news join account on news.account_id = account.account_id"
				+ " where type_id = '"+typeID+"' ORDER BY date DESC";
		}
		try {
			PreparedStatement ptmt= conn.prepareStatement(sql);
			
			ResultSet rs= ptmt.executeQuery();
			
			while(rs.next()){
				
				int news_id=rs.getInt("news_id");
				String title=rs.getString("title");
				String date=rs.getString("date");
				String content_news=rs.getString("content_news");
				String image=rs.getString("image");
				int account_id=rs.getInt("account_id");
				int type_id=rs.getInt("type_id");
				String name=rs.getString("name");
				
				News news= new News();
				news.setNews_id(news_id);
				news.setTitle(title);
				news.setDate(date);
				news.setContent_news(content_news);
				news.setImage(image);
				news.setAccount_id(account_id);
				news.setType_id(type_id);
				news.setName(name);
				
				list.add(news);
				
			}
		
		} catch (SQLException e) {
			e.printStackTrace();
		}
			
		return list;
	}
	public static List<News> LoadNewsbyTypeID(Connection conn, int typeid){
		
		List<News> list= new ArrayList<News>();
		
		String sql= "SELECT news_id, title, date, content_news, image, news.account_id, type_id, name from news join account on news.account_id = account.account_id"
				+ " WHERE type_id=? ORDER BY date DESC";
		
		try {
			
			PreparedStatement ptmt= conn.prepareStatement(sql);
			ptmt.setInt(1, typeid);
			ResultSet rs= ptmt.executeQuery();
			
			while(rs.next()){
				
				int news_id=rs.getInt("news_id");
				String title=rs.getString("title");
				String date=rs.getString("date");
				String content_news=rs.getString("content_news");
				String image=rs.getString("image");
				int account_id=rs.getInt("account_id");
				int type_id=rs.getInt("type_id");
				String name=rs.getString("name");
				
				News news= new News();
				news.setNews_id(news_id);
				news.setTitle(title);
				news.setDate(date);
				news.setContent_news(content_news);
				news.setImage(image);
				news.setAccount_id(account_id);
				news.setType_id(type_id);
				news.setName(name);
				
				list.add(news);
				
			}
		
		} catch (SQLException e) {
			e.printStackTrace();
		}
			
		return list;
	}
	public static News getNewsbyNewsID(Connection conn, int NewsID){
		
		News news= new News();
		
		String sql= "SELECT news_id, title, date, content_news, image, news.account_id, type_id, name from news join account on news.account_id = account.account_id"
				+ " WHERE news_id= ?";
		
		try {
			PreparedStatement ptmt= conn.prepareStatement(sql);
			ptmt.setInt(1, NewsID);
			
			ResultSet rs= ptmt.executeQuery();
			
			if(rs.next()){
				int news_id=rs.getInt("news_id");
				String title=rs.getString("title");
				String date=rs.getString("date");
				String content_news=rs.getString("content_news");
				String image=rs.getString("image");
				int account_id=rs.getInt("account_id");
				int type_id=rs.getInt("type_id");
				String name=rs.getString("name");
				
				news.setNews_id(news_id);
				news.setTitle(title);
				news.setDate(date);
				news.setContent_news(content_news);
				news.setImage(image);
				news.setAccount_id(account_id);
				news.setType_id(type_id);
				news.setName(name);
			}
		
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return news;
	}
	public static boolean InsertNews(News r, Connection conn) {
		String sql = "INSERT INTO news (title, date, content_news, account_id, type_id) "
				+ "VALUES (?, CURDATE(), ?, ?, ?);\r\n" + 
				"";
		
			try {
			
			PreparedStatement ptmt = conn.prepareStatement(sql);
			
			ptmt.setString(1, r.getTitle());
			ptmt.setString(2, r.getContent_news());
			ptmt.setInt(3, r.getAccount_id());
			ptmt.setInt(4, r.getType_id());
			
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
	public static boolean UpdateNews(News r, Connection conn) {
		String sql = "update news set  title=?, date=?, content_news=?, "
				+ " account_id=?, type_id=? where news_id='"+r.getNews_id()+"';";
		
			try {
			
			PreparedStatement ptmt = conn.prepareStatement(sql);
			
			ptmt.setString(1, r.getTitle());
			ptmt.setString(2, r.getDate());
			ptmt.setString(3, r.getContent_news());
			ptmt.setDouble(4, r.getAccount_id());
			ptmt.setInt(5, r.getType_id());
			
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
	public static boolean DeleteNews (List<String> listDel, Connection conn) {
		
		boolean t = false;
		try {
			
			for(String acceptThem:listDel) {
				String sql = "Delete from news "+
						" WHERE news_id = '"+acceptThem+"'";
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
	public static boolean UpdateImage(String news_id, String avatar, Connection conn)
	{
		String sql = "update news set image=? where news_id='"+news_id+"';";
		
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
}
