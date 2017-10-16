package club.wokao666.dao;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import club.wokao666.pojo.School;

public interface SchoolDao {

	
	public static final String TABLE = "School";
	
	
	/**
	 * 获取所有学校的名字列表
	 */
	@Select("Select * from " + TABLE)
	public List<School> listAllSchool();
	
	
	@Insert("Insert into " + TABLE + " (school_name) values (#{schoolName})")
	public int insert(@Param("schoolName")String schoolName);
	
	@Select("Select * from " + TABLE + " where school_name = #{schoolName}")
	public School getSchoolByName(@Param("schoolName")String schoolName);
	

	
}
