package club.wokao666.dao;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import club.wokao666.pojo.ClassRoom;

/**
 * 班级
 */
public interface ClassRoomDao {

	public static final String TABLE = "ClassRoom";
	
	/**
	 * 创建班级
	 */
	@Insert("Insert into " + TABLE + "(class_name,tId,count,sId) values (#{classRoom.class_name},#{classRoom.tId},#{classRoom.count},#{classRoom.sId})")
	public int insert(ClassRoom classRoom);
	
	/**
	 * 获取班级
	 */
	@Select("Select * from " + TABLE + " where cId=#{cId}")
	public ClassRoom getClassRoomBycId(@Param("cId")int cId);
	
	/**
	 * 根据学校获取所有的班级
	 */
	@Select("Select * from " + TABLE + " where sid = #{sid}")
	public List<ClassRoom> listAllClassNameBySchoolName(@Param("sid")int sid);
	
	/**
	 * 
	 */
	
}
