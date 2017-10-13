package club.wokao666.dao;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import club.wokao666.pojo.User;

/**
 * 登录数据库访问层
 */
public interface UserDao {

	public static final String TABLE = "User";

	/**
	 * 学生系列操作
	 */

	/**
	 * 查找一个学生
	 */
	@Select("Select * from " + TABLE + " where openId = #{openId}")
	public User getUserByOpenID(@Param("openId") String openId);

	/**
	 * 插入一个用户
	 */
	@Insert("Insert into " + TABLE
			+ " (nickName,openId,cid,sid,age,gender,number,avatarUrl,name,province,city,country,type) values(#{user.nickName},#{user.openId},#{user.cid},#{user.sid},#{user.age},#{user.gender},#{user.number},#{user.avatarUrl},#{user.name},#{user.province},#{user.city},#{user.country},#{user.type})")
	public int insert(@Param("user")User user);

}
