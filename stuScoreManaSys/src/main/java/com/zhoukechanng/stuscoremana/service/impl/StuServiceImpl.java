package com.zhoukechanng.stuscoremana.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zhoukechanng.stuscoremana.entity.Scores;
import com.zhoukechanng.stuscoremana.entity.Stu;
import com.zhoukechanng.stuscoremana.mapper.StuMapper;
import com.zhoukechanng.stuscoremana.service.StuService;

@Service
public class StuServiceImpl implements StuService{

	@Autowired
	StuMapper stuMapper;
	
	@Override
	public List<Stu> findStu(String stuno, String psw) {
		
		return stuMapper.findStu(stuno, psw);
	}

	@Override
	public int addStu(Map map) {
		return stuMapper.addStu(map);
	}
	
	
	@Override
	public List<Stu> findAllStu(Map<String, Object> map) {
		
		return stuMapper.findAllStu(map);
	}

	@Override
	public List<Stu> findStuByName(String name, int start, int pagesize) {
		
		return stuMapper.findStuByName(name, start, pagesize);
	}

	@Override
	public int stuCount() {
		
		return stuMapper.stuCount();
	}
 
	@Override
	public int deleteByForeach(List<String> stuNO) {
		
		return stuMapper.deleteByForeach(stuNO);
	}

	@Override
	public int deleteStu(String stuNo) {
		
		return stuMapper.deleteStu(stuNo);
	}

	@Override
	public List<Stu> getStuByNum(String num) {
		
		return stuMapper.getStuByNum(num);
	}

	@Override
	public int updateStu(Map map) {
		
		return stuMapper.updateStu(map);
	}

	@Override
	public List<Stu> findAll() {
		
		return stuMapper.findAll();
	}

	@Override
	public List<Scores> getScoreByStuName(String name) {
		
		return stuMapper.getScoreByStuName(name);
	}

}
