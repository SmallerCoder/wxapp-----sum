package club.wokao666.common;

/**
 * 微信消息结构体
 */
public class WxMsg {
	private String openId;//用户唯一标识
	private String session_key;//会话秘钥
	private int expires_in;//未知
	private String errmsg;//错误消息
	private String errcode;//错误消息
	public WxMsg() {
		super();
	}
	public WxMsg(String openId, String session_key, int expires_in, String errmsg, String errcode) {
		super();
		this.openId = openId;
		this.session_key = session_key;
		this.expires_in = expires_in;
		this.errmsg = errmsg;
		this.errcode = errcode;
	}
	public String getOpenId() {
		return openId;
	}
	public void setOpenId(String openId) {
		this.openId = openId;
	}
	public String getSession_key() {
		return session_key;
	}
	public void setSession_key(String session_key) {
		this.session_key = session_key;
	}
	public int getExpires_in() {
		return expires_in;
	}
	public void setExpires_in(int expires_in) {
		this.expires_in = expires_in;
	}
	public String getErrmsg() {
		return errmsg;
	}
	public void setErrmsg(String errmsg) {
		this.errmsg = errmsg;
	}
	public String getErrcode() {
		return errcode;
	}
	public void setErrcode(String errcode) {
		this.errcode = errcode;
	}
}
