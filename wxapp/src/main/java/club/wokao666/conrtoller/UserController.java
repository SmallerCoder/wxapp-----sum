package club.wokao666.conrtoller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSON;

import club.wokao666.common.ReturnMsg;
import club.wokao666.common.WxMsg;
import club.wokao666.pojo.User;
import club.wokao666.service.UserService;
import club.wokao666.utils.GenerageCode;
import club.wokao666.utils.HttpHelper;
import io.swagger.annotations.Api;

@Api
@RequestMapping(value="/user")
@RestController
public class UserController {
	@Autowired
	private UserService userService;
	
	/**
	 * 注册操作
	 */
	@RequestMapping(value="register.do",method=RequestMethod.POST)
	public ReturnMsg register(User user,@RequestParam String code,@RequestParam String schoolName){
		/**
		 * 向微信服务器换取openId,session_key
		 */
		String wx_msg = HttpHelper.post("https://api.weixin.qq.com/sns/jscode2session", code);
		WxMsg wx = null;
		/**
		 * 获取成功,200
		 */
		if (wx_msg != null && !wx_msg.equals("")) {
			// 统一处理
			wx = JSON.parseObject(wx_msg, WxMsg.class);
			if(wx.getOpenId()!=""){
				user.setOpenId(wx.getOpenId());
			}else {
				return ReturnMsg.error();
			}
		}
		int result = userService.insert(user,schoolName);
		if(result > 0){
			String token = GenerageCode.getRandomString(32);
			userService.getUserByOpenId(wx.getOpenId(),token);
			return ReturnMsg.succ(token);
		}
		return ReturnMsg.error();
	}
	
}
