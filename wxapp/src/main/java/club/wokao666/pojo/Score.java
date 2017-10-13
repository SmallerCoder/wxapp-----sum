package club.wokao666.pojo;

public class Score {

	private int id;
	private int uid;
	private String createTime;
	private int test_type;
	private String test_type_name;
	private int level;
	private int question_type;
	private String question_type_name;
	private int count;
	public Score(int id, int uid, String createTime, int test_type, String test_type_name, int level,
			int question_type, String question_type_name, int count) {
		super();
		this.id = id;
		this.uid = uid;
		this.createTime = createTime;
		this.test_type = test_type;
		this.test_type_name = test_type_name;
		this.level = level;
		this.question_type = question_type;
		this.question_type_name = question_type_name;
		this.count = count;
	}
	public Score() {
		super();
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getUid() {
		return uid;
	}
	public void setUid(int uid) {
		this.uid = uid;
	}
	public String getCreateTime() {
		return createTime;
	}
	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}
	public int getTest_type() {
		return test_type;
	}
	public void setTest_type(int test_type) {
		this.test_type = test_type;
	}
	public String getTest_type_name() {
		return test_type_name;
	}
	public void setTest_type_name(String test_type_name) {
		this.test_type_name = test_type_name;
	}
	public int getLevel() {
		return level;
	}
	public void setLevel(int level) {
		this.level = level;
	}
	public int getQuestion_type() {
		return question_type;
	}
	public void setQuestion_type(int question_type) {
		this.question_type = question_type;
	}
	public String getQuestion_type_name() {
		return question_type_name;
	}
	public void setQuestion_type_name(String question_type_name) {
		this.question_type_name = question_type_name;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
}
