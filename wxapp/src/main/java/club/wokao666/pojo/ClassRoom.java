package club.wokao666.pojo;

public class ClassRoom {
	private int cid;
	private String class_name;
	private int uid;//教师id，一个班级对应一个老师？
	private int count;
	private int sid;
	public ClassRoom() {
	}
	public ClassRoom(int cid, String class_name, int uid, int count, int sid) {
		super();
		this.cid = cid;
		this.class_name = class_name;
		this.uid = uid;
		this.count = count;
		this.sid = sid;
	}
	public int getCid() {
		return cid;
	}
	public void setCid(int cid) {
		this.cid = cid;
	}
	public String getClass_name() {
		return class_name;
	}
	public void setClass_name(String class_name) {
		this.class_name = class_name;
	}
	public int getUid() {
		return uid;
	}
	public void setUid(int uid) {
		this.uid = uid;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	public int getSid() {
		return sid;
	}
	public void setSid(int sid) {
		this.sid = sid;
	}
}
