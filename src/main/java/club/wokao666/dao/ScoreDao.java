package club.wokao666.dao;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;


public interface ScoreDao {

	
	public static final String TABLE = "Score";
	
	
	/**
	 * 插入
	 * @param kind
	 * @return
	 */
	@Insert("insert into " + TABLE + " (uid,createTime,test_type,test_type_name,level,question_type,question_type_name,count) values(#{uid},#{createTime},#{test_type},#{test_type_name},#{level},#{question_type},#{question_type_name},#{count})")
	public int insert(@Param("test_type")int kind,@Param("level")int type,@Param("test_type_name")String test_type_name,@Param("createTime")int createTime,@Param("uid")int uid,@Param("question_type")int question_type,@Param("question_type_name")String question_type_name,@Param("count")int count);
	
	
	
}
