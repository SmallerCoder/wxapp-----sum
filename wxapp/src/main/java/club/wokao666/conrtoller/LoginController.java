package club.wokao666.conrtoller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSON;

import club.wokao666.common.ReturnMsg;
import club.wokao666.common.WxMsg;
import club.wokao666.dto.MineHeaderDto;
import club.wokao666.dto.RegisterDto;
import club.wokao666.pojo.User;
import club.wokao666.service.LoginService;
import club.wokao666.utils.GenerageCode;
import club.wokao666.utils.HttpHelper;
import club.wokao666.utils.RedisUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;

@RestController
@Api
@RequestMapping("login")
public class LoginController {

	@Autowired
	private LoginService loginService;

	/**
	 * (微信登录)生成服务器session，并将之传送给微信小程序,将从微信获取的openid，key存放到redis数据库中
	 */
	@ApiOperation(notes = "生成服务器session，并将之传送给微信小程序", value = "生成服务器session，并将之传送给微信小程序")
	@ApiImplicitParams({
			@ApiImplicitParam(name = "code", value = "小程序用户登录时微信给的code,有效时间为5分钟，用过一次不可再用", dataType = "string", paramType = "form", required = true),
			@ApiImplicitParam(name = "session", value = "判断第一次登录", dataType = "string", paramType = "form", required = true),
			@ApiImplicitParam(name = "gender", value = "性别 0：未知、1：男、2：女", dataType = "int", paramType = "form", required = true),
			@ApiImplicitParam(name = "country", value = "国家", dataType = "string", paramType = "form", required = true), 
			@ApiImplicitParam(name = "nickname", value = "微信昵称", dataType = "string", paramType = "form", required = true) ,
			@ApiImplicitParam(name = "province", value = "省份", dataType = "string", paramType = "form", required = true) ,
			@ApiImplicitParam(name = "city", value = "城市", dataType = "string", paramType = "form", required = true) ,
			@ApiImplicitParam(name = "avatarUrl", value = "微信头像地址", dataType = "string", paramType = "form", required = true) ,
			@ApiImplicitParam(name = "type", value = "类型，1：老师，2：学生 3:访客", dataType = "int", paramType = "form", required = true) 
	})
	@RequestMapping(value = "/getToken.do", method = RequestMethod.POST)
	public ReturnMsg getToken(@RequestParam int gender,@RequestParam String country,@RequestParam String nickname,@RequestParam String province,@RequestParam String city,@RequestParam String avatarUrl,@RequestParam String code, @RequestParam String session, @RequestParam int type) {
//		
//		if (session.equals("undefined")) {
//			/**
//			 * 如果小程序默认发送不为空""，则生成随机字符串
//			 */
//			if (code != null && !code.equals("")) {
//				/**
//				 * 向微信服务器换取openId,session_key
//				 */
//				String wx_msg = HttpHelper.post("https://api.weixin.qq.com/sns/jscode2session", code);
//				/**
//				 * 获取成功,200
//				 */
//				if (wx_msg != null && !wx_msg.equals("")) {
//					// 统一处理
//					WxMsg wx = JSON.parseObject(wx_msg, WxMsg.class);
//					/**
//					 * 如果不是错误消息，openid会为null，，，{"errcode":40163,"errmsg":"code been used, hints: [
//					 * req_id: X4lOsa0430th50 ]"}
//					 */
//					if (wx.getOpenId() != null) {
//						// 生成32位随机字符串j
//						session = GenerageCode.getRandomString(32);
//						/**
//						 * 从数据库中拿一条记录，openId是唯一的
//						 */
//							User user = loginService.getUserByOpenId(wx.getOpenId());
							//如果记录存在，则返回生成的字符串
//							if (user != null) {
								//记录在redis中
//								RedisUtil.set(session,JSON.toJSONString(user), 600);
//								return ReturnMsg.succ(session);
//							}else {
								//构造一个新用户
//								User newUser = new User(wx.getOpenId(), gender, nickname, province, city, avatarUrl, country, type);
//								int result = service.stuInsert(newUser);
//							}
//					}
//					return ReturnMsg.succ(session);
//				}
//			}
//		}
		return ReturnMsg.error();
	}

	/**
	 * 检查该用户是否注册过
	 */
	@RequestMapping(value="checkLogined.do",method=RequestMethod.POST)
	public ReturnMsg checkLogin(@RequestParam String code) {
		/**
		 * 向微信服务器换取openId,session_key
		 */
		String wx_msg = HttpHelper.post("https://api.weixin.qq.com/sns/jscode2session", code);
		if (wx_msg != null && !wx_msg.equals("")) {
			// 统一处理
			WxMsg wx = JSON.parseObject(wx_msg, WxMsg.class);
			if(wx.getOpenId()!=null){
				String openId = wx.getOpenId();
				MineHeaderDto dto = loginService.getUserDtoByOpenId(openId);
				if(dto!=null){
					return ReturnMsg.succ(dto);
				}
			}
		}
		return ReturnMsg.error();
	}
	
	/**
	 * 获取所有可选的学校
	 */
	@RequestMapping(value="listAllSchool.do",method=RequestMethod.POST)
	public ReturnMsg listAllSchool(){
		RegisterDto dto = loginService.listAllSchool();
		return ReturnMsg.succ(dto);
	}
	
	/**
	 * 根据学校获取所有的班级名称
	 */
	@RequestMapping(value = "listAllClassBySid.do", method = RequestMethod.POST)
	public ReturnMsg listAllClassNameBySchoolName(@RequestParam int sid) {
		RegisterDto dto = loginService.listAllClassBySchoolName(sid);
		return ReturnMsg.succ(dto);
	}	
		
	
	
	
	
//	public static void main(String[] args) throws IOException {
//		String wx_msg = HttpHelper.post("https://api.weixin.qq.com/sns/jscode2session","013QzKYa0FCSjt1be7Xa02TGYa0QzKYy");
//		if(wx_msg!=null&&!wx_msg.equals("")) {
//			//统一处理
//			WxMsg wx = JSON.parseObject(wx_msg, WxMsg.class);
//			if(wx.getOpenId()!=null) {
//				System.err.println("not null");
//			}
//			System.err.println(wx.getErrcode());
//		}
//		System.err.println(wx_msg);
//	}
}
