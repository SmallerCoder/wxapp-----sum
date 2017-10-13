package club.wokao666.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSON;

import club.wokao666.dao.ClassRoomDao;
import club.wokao666.dao.SchoolDao;
import club.wokao666.dao.UserDao;
import club.wokao666.dto.MineHeaderDto;
import club.wokao666.dto.RegisterDto;
import club.wokao666.pojo.ClassRoom;
import club.wokao666.pojo.School;
import club.wokao666.pojo.User;
import club.wokao666.utils.GenerageCode;
import club.wokao666.utils.RedisUtil;

/**
 * 登录服务类
 */
@Service
public class LoginService {

	@Autowired
	private UserDao dao;
	@Autowired
	private SchoolDao schoolDao;
	@Autowired
	private ClassRoomDao classRoomDao;
	
	/**
	 * 获取一条用户信息
	 */
	public MineHeaderDto getUserDtoByOpenId(String openId) {
		User user = dao.getUserByOpenID(openId);
		String className = "";
		String token = "";
		if(user!=null){
			token = GenerageCode.getRandomString(32);
			RedisUtil.set(token,JSON.toJSONString(user));
			ClassRoom  classRoom = classRoomDao.getClassRoomBycId(user.getCid());
			if(classRoom!=null){
				className = classRoom.getClass_name();
			}
			return new MineHeaderDto(user.getAvatarUrl(), user.getGender(), user.getName(),className, user.getNumber(),token,user.getType());
		}
		return null;
	}

	
	/**
	 * 获取所有学校的名字列表
	 */
	public RegisterDto listAllSchool(){
		List<String> nameList = new ArrayList<String>();
		List<Integer> idList = new ArrayList<Integer>();
		List<School> schoolList = schoolDao.listAllSchool();
		for (School school : schoolList) {
			idList.add(school.getSid());
			nameList.add(school.getSchool_name());
		}
		return new RegisterDto(nameList, idList);
	}
	
	/**
	 * 根据学校id获取所有的班级
	 */
	public RegisterDto listAllClassBySchoolName(int sid){
		List<ClassRoom> classList = classRoomDao.listAllClassNameBySchoolName(sid);
		List<String> nameList = new ArrayList<String>();
		List<Integer> idList = new ArrayList<Integer>();
		for (ClassRoom classRoom : classList) {
			idList.add(classRoom.getCid());
			nameList.add(classRoom.getClass_name());
		}
		return new RegisterDto(nameList, idList);
	}
	
}
