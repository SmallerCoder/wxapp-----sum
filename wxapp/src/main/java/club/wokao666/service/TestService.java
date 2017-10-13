package club.wokao666.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import club.wokao666.dao.ScoreDao;
import club.wokao666.pojo.User;
import club.wokao666.utils.TimeUtils;

@Service
public class TestService {

	@Autowired
	private ScoreDao scoreDao;
	@Autowired
	private UserService userService;

	/**
	 * 
	 */
	public int saveRecord(int kind, int score, int type, String token) {

		User user = userService.getUserByToken(token);
		int result = 0;
		if (user != null) {
			switch (kind) {
			case 0:// 101测试
				result = scoreDao.insert(101,type, "水平等级测试", TimeUtils.timestamp(), user.getUid(), 0, "", 0);
				break;
			case 1:// 202测试
				String name = "";
				switch (type) {
				case 1:
					name = "5内减法";
					break;
				case 2:
					name = "10内加法";
					break;
				case 3:
					name = "10内加减法";
					break;
				case 4:
					name = "20内加法";
					break;
				case 5:
					name = "20内加减法";
					break;
				case 6:
					name = "20内减法";
					break;
				}
				result = scoreDao.insert(202,0, "3分钟测试", TimeUtils.timestamp(), user.getUid(), type,name, score);
				break;
			}
		}
		return result;
	}
	
	
	
	
}
