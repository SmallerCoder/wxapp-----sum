package club.wokao666.common;


public enum ReturnCode {

	SUCCESS(1, "ok"),
	FAIL(-1, "fail"),
	UNLOGIN(-2, "没有登录"),
	SERVER_ERROR(3, "系统错误"),
	PARAMS_ERROR(4, "参数错误 "),
	TOO_FREQUENT(5, "太频繁的调用"),
	UNKNOWN_ERROR(6, "发生异常")
	;


	private ReturnCode(int code, String msg) {
		this.code = code;
		this.msg = msg;
	}

	private int code;
	private String msg;

	public int getCode() {
		return code;
	}

	public String getMsg() {
		return msg;
	}

}
