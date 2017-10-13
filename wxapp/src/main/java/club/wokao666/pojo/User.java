package club.wokao666.pojo;

/**
 * 学生对象
 */
public class User {
	private String name;//姓名
	private int uid;//uid，主键，自动增长
	private String openId;//微信登录id
	private int cid;//班级id
	private int sid;//学校id
	private int age;//年龄
	private int gender;//性别 0：未知、1：男、2：女
	private long number;//学号
	private String nickName;//微信昵称
	private String province;//省份
	private String city;//城市
	private String avatarUrl;//头像地址
	private String country;//国家
	private int type;//类型，1：老师，2：学生 3:访客
	public User() {
	}
	public User(String name, int uid, String openId, int cid, int sid, int age, int gender, long number, String nickName,
			String province, String city, String avatarUrl, String country, int type) {
		super();
		this.name = name;
		this.uid = uid;
		this.openId = openId;
		this.cid = cid;
		this.sid = sid;
		this.age = age;
		this.gender = gender;
		this.number = number;
		this.nickName = nickName;
		this.province = province;
		this.city = city;
		this.avatarUrl = avatarUrl;
		this.country = country;
		this.type = type;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getUid() {
		return uid;
	}
	public void setUid(int uid) {
		this.uid = uid;
	}
	public String getOpenId() {
		return openId;
	}
	public void setOpenId(String openId) {
		this.openId = openId;
	}
	public int getCid() {
		return cid;
	}
	public void setCid(int cid) {
		this.cid = cid;
	}
	public int getSid() {
		return sid;
	}
	public void setSid(int sid) {
		this.sid = sid;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public int getGender() {
		return gender;
	}
	public void setGender(int gender) {
		this.gender = gender;
	}
	public long getNumber() {
		return number;
	}
	public void setNumber(long number) {
		this.number = number;
	}
	public String getNickName() {
		return nickName;
	}
	public void setNickName(String nickName) {
		this.nickName = nickName;
	}
	public String getProvince() {
		return province;
	}
	public void setProvince(String province) {
		this.province = province;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getAvatarUrl() {
		return avatarUrl;
	}
	public void setAvatarUrl(String avatarUrl) {
		this.avatarUrl = avatarUrl;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public int getType() {
		return type;
	}
	public void setType(int type) {
		this.type = type;
	}
}
