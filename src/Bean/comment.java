package Bean;

public class comment {
	private int comment_id;
	private int account_id;
	private String name;
	private String avatar;
	private int discussion_id;
	private String time;
	private String comment;
	private String sex;
	private String birthday;
	private String mail;
	private String phonenumber;
	
	public comment() {}
	public comment(int comment_id, int account_id, String name, String avatar, int discussion_id, String time,
			 String comment, String sex, String birthday, String mail, String phonenumber) {
		this.comment_id = comment_id;
		this.account_id = account_id;
		this.name = name;
		this.avatar = avatar;
		this.discussion_id = discussion_id;
		this.time = time;
		this.comment = comment;
		this.sex = sex;
		this.birthday = birthday;
		this.mail = mail;
		this.phonenumber = phonenumber;
	}
	public comment(int account_id, int discussion_id, String time,
			 String comment) {
		this.account_id = account_id;
		this.discussion_id = discussion_id;
		this.time = time;
		this.comment = comment;
	}
	
	public int getComment_id() {
		return comment_id;
	}
	public void setComment_id(int comment_id) {
		this.comment_id = comment_id;
	}
	public int getAccount_id() {
		return account_id;
	}
	public void setAccount_id(int account_id) {
		this.account_id = account_id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAvatar() {
		return avatar;
	}
	public void setAvatar(String avatar) {
		this.avatar = avatar;
	}
	public int getDiscussion_id() {
		return discussion_id;
	}
	public void setDiscussion_id(int discussion_id) {
		this.discussion_id = discussion_id;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public String getBirthday() {
		return birthday;
	}
	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}
	public String getMail() {
		return mail;
	}
	public void setMail(String mail) {
		this.mail = mail;
	}
	public String getPhonenumber() {
		return phonenumber;
	}
	public void setPhonenumber(String phonenumber) {
		this.phonenumber = phonenumber;
	}
}
