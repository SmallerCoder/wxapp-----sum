package club.wokao666.pojo;

public class School {
	private int sid;
	private String school_name;
	public School(int sid, String school_name) {
		super();
		this.sid = sid;
		this.school_name = school_name;
	}
	public School() {
		super();
	}
	public int getSid() {
		return sid;
	}
	public void setSid(int sid) {
		this.sid = sid;
	}
	public String getSchool_name() {
		return school_name;
	}
	public void setSchool_name(String school_name) {
		this.school_name = school_name;
	}
}
