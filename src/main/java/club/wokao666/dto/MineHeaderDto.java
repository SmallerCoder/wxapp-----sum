package club.wokao666.dto;

public class MineHeaderDto {

	private String image;//头像
	private int sex;//性别
	private String name;//姓名
	private String className;//班级名称
	private long number;//学号
	private String token;
	private int type;//老师、学生
	public MineHeaderDto(String image, int sex, String name, String className, long number,String token,int type) {
		super();
		this.image = image;
		this.sex = sex;
		this.name = name;
		this.className = className;
		this.number = number;
		this.token = token;
		this.type = type;
	}
	public MineHeaderDto() {
		super();
	}
	
	public int getType() {
		return type;
	}
	public void setType(int type) {
		this.type = type;
	}
	public String getToken() {
		return token;
	}
	public void setToken(String token) {
		this.token = token;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public int getSex() {
		return sex;
	}
	public void setSex(int sex) {
		this.sex = sex;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getClassName() {
		return className;
	}
	public void setClassName(String className) {
		this.className = className;
	}
	public long getNumber() {
		return number;
	}
	public void setNumber(long number) {
		this.number = number;
	}
}
