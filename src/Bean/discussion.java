package Bean;

public class discussion {
	private int discussion_id;
	private String title;
	private String content;
	private String postedby;
	private String postdate;
	private int reply;
	private int discussiontopic_id;
	private int account_id;
	private String avatar;
	private String sex;
	private String birthday;
	private String mail;
	private String phonenumber;
	
	public discussion() {}
	public discussion(int discussion_id, String title, String postedby, String postdate, int reply, String avatar, String content, int account_id) {
		this.discussion_id = discussion_id;
		this.title = title;
		this.postedby = postedby;
		this.postdate = postdate;
		this.reply = reply;
		this.avatar = avatar;
		this.content = content;
		this.account_id = account_id;
	}
	public discussion(int discussion_id, String title, String content, String postedby, String postdate,
			String avatar, int account_id, String sex, String birthday, String mail, String phonenumber, int reply) {
		this.discussion_id = discussion_id;
		this.title = title;
		this.content = content;
		this.postedby = postedby;
		this.postdate = postdate;
		this.reply = reply;
		this.avatar = avatar;
		this.account_id = account_id;
		this.sex = sex;
		this.birthday = birthday;
		this.mail = mail;
		this.phonenumber = phonenumber;
	}
	
	public int getDiscussion_id() {
		return discussion_id;
	}
	public void setDiscussion_id(int discussion_id) {
		this.discussion_id = discussion_id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getPostedby() {
		return postedby;
	}
	public void setPostedby(String postedby) {
		this.postedby = postedby;
	}
	public String getPostdate() {
		return postdate;
	}
	public void setPostdate(String postdate) {
		this.postdate = postdate;
	}
	public int getReply() {
		return reply;
	}
	public void setReply(int reply) {
		this.reply = reply;
	}
	public int getDiscussiontopic_id() {
		return discussiontopic_id;
	}
	public void setDiscussiontopic_id(int discussiontopic_id) {
		this.discussiontopic_id = discussiontopic_id;
	}
	public int getAccount_id() {
		return account_id;
	}
	public void setAccount_id(int account_id) {
		this.account_id = account_id;
	}
	public String getAvatar() {
		return avatar;
	}
	public void setAvatar(String avatar) {
		this.avatar = avatar;
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
