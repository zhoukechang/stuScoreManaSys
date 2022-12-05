package com.zhoukechanng.stuscoremana.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zhoukechanng.stuscoremana.entity.Teacher;
import com.zhoukechanng.stuscoremana.mapper.TeacherMapper;
import com.zhoukechanng.stuscoremana.service.TeacherService;

@Service
public class TeacherServiceImpl implements TeacherService{

	
	@Autowired
	TeacherMapper teacherMapper;
	
	@Override
	public List<Teacher> findTeacher(String teachno, String psw) {
		
		return teacherMapper.findTeacher(teachno, psw);
	}

	@Override
	public int addTeacher(Map map) {
		
		return teacherMapper.addTeacher(map);
	}
	
	@Override
	public List<Teacher> findAllTeacher(Map<String, Object> map) {
		
		return teacherMapper.findAllTeacher(map);
	}

	@Override
	public List<Teacher> findTeacherByName(String name, int start, int pagesize) {
		
		return teacherMapper.findTeacherByName(name, start, pagesize);
	}

	@Override
	public int teacherCount() {
		
		return teacherMapper.teacherCount();
	}

	@Override
	public List<Teacher> findTeacherByNum(String num) {
		
		return teacherMapper.findTeacherByNum(num);
	}

	@Override
	public int updateTea(Map map) {
		
		return teacherMapper.updateTea(map);
	}

}
