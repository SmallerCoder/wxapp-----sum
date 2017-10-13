package club.wokao666.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSON;

import club.wokao666.common.WxMsg;
import club.wokao666.dao.SchoolDao;
import club.wokao666.dao.UserDao;
import club.wokao666.pojo.School;
import club.wokao666.pojo.User;
import club.wokao666.utils.HttpHelper;
import club.wokao666.utils.RedisUtil;

@Service
public class UserService {

	@Autowired
	private UserDao userDao;
	@Autowired
	private SchoolDao schoolDao;
	
	
	
	/**
	 * 注册
	 */
	public int insert(User user,String schoolName){
		if(user.getType() == 1) {
			School school = schoolDao.getSchoolByName(schoolName);
			if(school!=null) {
				user.setSid(school.getSid());
			}else {
				int result = schoolDao.insert(schoolName);
				if(result > 0) {
					School school_ = schoolDao.getSchoolByName(schoolName);
					user.setSid(school_.getSid());
				}
			}
		}
		int result = userDao.insert(user);
		return result;
	}
	
	
	public User getUserByOpenId(String openId,String token) {
		User user = userDao.getUserByOpenID(openId);
		if(user!=null) {
			RedisUtil.set(token, JSON.toJSONString(user));
		}
		return user;
	}
	
	public User getUserByToken(String token) {
		//获取用户
		User user = JSON.parseObject(RedisUtil.get(token), User.class);
		return user;
	}
	
}
