package com.zhoukechanng.stuscoremana.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.zhoukechanng.stuscoremana.entity.Scores;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

@Mapper
public interface GcCourseMapper {
    @Select("select\n" +
            "\t\ts.stuno,s.name,c.coursename,ss.score,ss.type from stu s\n" +
            "\t\tinner join stu_sco ss\n" +
            "\t\ton ss.stuno=s.stuno\n" +
            "\t\tinner join course c\n" +
            "\t\ton c.courseid = ss.courseid\n" +
            "\t\twhere c.coursename = #{0} and ss.type=#{1} and s.stuno like CONCAT(CONCAT('%',#{2},#{3}),'%')\n" +
            "\t\tlimit #{4},#{5}")
	public List<Scores>findScores(String coursename,String type,String gcg,String gcc,int start, int pagesize );
    
    @Select("select\n" +
            "\t\ts.stuno,s.name,c.coursename,ss.score,ss.type from stu s\n" +
            "\t\tinner join stu_sco ss\n" +
            "\t\ton ss.stuno=s.stuno\n" +
            "\t\tinner join course c\n" +
            "\t\ton c.courseid = ss.courseid\n" +
            "\t\twhere c.coursename = #{0} and ss.type=#{1} and s.stuno like CONCAT(CONCAT('%',#{2},#{3}),'%')")
	public List<Scores>findAllScores(String coursename,String type,String gcg,String gcc);
    
    @Select("select\n" +
            "\t\ts.stuno,s.name,c.coursename,ss.score,ss.type from stu s\n" +
            "\t\tinner join stu_sco ss\n" +
            "\t\ton ss.stuno=s.stuno\n" +
            "\t\tinner join course c\n" +
            "\t\ton c.courseid = ss.courseid\n" +
            "\t\twhere c.coursename = #{0} and ss.type='已批改' and s.stuno like CONCAT(CONCAT('%',#{1}),'%')")
	public List<Scores>compClaScores(String coursename,String gcg);
    @Update("update stu_sco set score=#{stu_sco.score},type=#{stu_sco.type} where stuno=#{stu.stuno} and courseid=(select courseid from course where coursename = #{course.coursename})")
	public int updateScores(Map map);
    
    @Select("select\n" +
            "\t\ts.stuno,s.name,c.coursename,ss.score,ss.type from stu s\n" +
            "\t\tinner join stu_sco ss\n" +
            "\t\ton ss.stuno=s.stuno\n" +
            "\t\tinner join course c\n" +
            "\t\ton c.courseid = ss.courseid\n" +
            "\t\twhere c.coursename = #{0}  and s.stuno =#{1}")
	public List<Scores> findPersonScore(String coursename,String num);
}
