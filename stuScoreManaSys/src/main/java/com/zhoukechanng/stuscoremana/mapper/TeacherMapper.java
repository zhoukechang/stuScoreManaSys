package com.zhoukechanng.stuscoremana.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import com.zhoukechanng.stuscoremana.entity.Teacher;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

@Mapper
public interface TeacherMapper {
    @Select("select * from teacher where teachno=#{0} and psw = #{1}")
	public List<Teacher> findTeacher(String teachno, String psw);
    
    @Insert("insert into teacher(teachno,name,gra_class,course,psw,sex,phone)\n" +
            "\t\tvalues(#{teachno},#{name},#{gra_class},#{course},#{psw},#{sex},#{phone})")
	public int addTeacher(Map map);
    
    @Select("select teachno,name,gra_class\n" +
            "\t\t,c.coursename course,sex,phone\n" +
            "\t\tfrom teacher\n" +
            "\t\tinner join course c\n" +
            "\t\ton c.courseid=teacher.course\n" +
            "\t\tlimit #{start},#{pagesize}")
	public List<Teacher> findAllTeacher(Map<String, Object> map);

    @Select("select teachno,name,gra_class\n" +
            "\t\t,c.coursename course,sex,phone\n" +
            "\t\tfrom teacher\n" +
            "\t\tinner join course c\n" +
            "\t\ton c.courseid=teacher.course\n" +
            "\t\twhere name like CONCAT(CONCAT('%',#{0}),'%') limit #{1},#{2}")
	public List<Teacher> findTeacherByName(String name, int start, int pagesize);

    @Select("select count(id) from teacher")
	public int teacherCount();
	
    @Select("select teachno,psw,name,gra_class\n" +
            "\t\t,c.coursename course,sex,phone\n" +
            "\t\tfrom teacher\n" +
            "\t\tinner join course c\n" +
            "\t\ton c.courseid=teacher.course\n" +
            "\t\twhere teachno =#{0} ")
	public List<Teacher> findTeacherByNum(String num);
    
    @Update("update teacher set teachno=#{teacher.teachno},name=#{teacher.name},psw=#{teacher.psw},sex=#{teacher.sex},gra_class=#{teacher.gra_class},course=#{teacher.course},phone=#{teacher.phone} where id=#{teacher.id}")
	public int updateTea(Map map);
}
