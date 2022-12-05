package com.zhoukechanng.stuscoremana.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.*;

import com.zhoukechanng.stuscoremana.entity.Scores;
import com.zhoukechanng.stuscoremana.entity.Stu;

@Mapper
public interface StuMapper {
    @Select("select * from stu where stuno=#{0} and psw=#{1}")
	public List<Stu> findStu(String stuno, String psw);
    
    @Insert("insert into stu(stuno,name,psw,sex,phone)values (#{stuno},#{name},#{psw},#{sex},#{phone})")
	public int addStu(Map map);
    
    @Select("select * from Stu order by stuno limit #{start},#{pagesize}")
	public List<Stu> findAllStu(Map<String, Object> map);
    
    @Select("select * from Stu ")
	public List<Stu> findAll();
    
    @Select("select * from stu where name like CONCAT(CONCAT('%',#{0}),'%') limit #{1},#{2}")
	public List<Stu> findStuByName(String name, int start, int pagesize);
    
    @Select("select count(id) from stu")
	public int stuCount();
    
    @Delete("delete from stu where stuno in\n" +
            "\t\t<foreach collection=\"list\" item=\"num\" open=\"(\" close=\")\" separator=\",\">\n" +
            "\t\t\t#{num}\n" +
            "\t\t</foreach>")
	public int deleteByForeach(List<String> stuno);
 
    @Delete("delete  from stu where stuno = #{0}")
	public int deleteStu(String stuno);

    @Select("select * from stu where stuno= #{stuno}")
	public List<Stu> getStuByNum(String stuno);

    @Update("update stu set stuno=#{stu.stuno},name=#{stu.name},psw=#{stu.psw},sex=#{stu.sex},phone=#{stu.phone} where id=#{stu.id}")
	public int updateStu(Map map);
	
    @Select("select ss.stuno,s.name,c.coursename,ss.score,ss.type  from stu_sco ss\n" +
            "inner JOIN course c\n" +
            "on c.courseid = ss.courseid\n" +
            "inner join stu s\n" +
            "on s.stuno = ss.stuno\n" +
            "where s.name = #{0}")
	public List<Scores> getScoreByStuName(String name);
	
	
}
