package club.wokao666.common;

import java.io.Serializable;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.annotations.ApiParam;

/**
 * 返回的消息结构
 */
@ApiModel
public class ReturnMsg<T> implements Serializable {
	@ApiModelProperty("返回的信息")
	private String msg;
	@ApiModelProperty("返回的数据")
	private T data;
	@ApiModelProperty("返回的状态码,1:OK  2:fail  -2:没有登录   3:系统错误  4:参数错误   5:太频繁调用  6:发生异常")
	private int code;
	protected ReturnMsg(String msg, T data, int code) {
		super();
		this.msg = msg;
		this.data = data;
		this.code = code;
	}

	protected ReturnMsg(int code, T data) {
		super();
		this.data = data;
		this.code = code;
	}

	public static ReturnMsg succ() {
		return new ReturnMsg(ReturnCode.SUCCESS.getCode(), null);
	}

	public static ReturnMsg succ(Object data) {
		return new ReturnMsg(ReturnCode.SUCCESS.getCode(), data);
	}

	public static ReturnMsg error(String msg) {
		return new ReturnMsg(msg, null, ReturnCode.FAIL.getCode());
	}

	public static ReturnMsg error() {
		return new ReturnMsg(ReturnCode.FAIL.getMsg(), null, ReturnCode.FAIL.getCode());
	}

	public static ReturnMsg notLogin() {
		return new ReturnMsg("not login", null, ReturnCode.UNLOGIN.getCode());
	}

	public static ReturnMsg errorParam() {
		return new ReturnMsg("param error", null, ReturnCode.PARAMS_ERROR.getCode());
	}

	public static ReturnMsg systemParam() {
		return new ReturnMsg("system error", null, ReturnCode.SERVER_ERROR.getCode());
	}

	private ReturnMsg() {
		super();

	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}
}
