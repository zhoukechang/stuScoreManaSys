package com.zhoukechanng.stuscoremana.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zhoukechanng.stuscoremana.entity.Scores;
import com.zhoukechanng.stuscoremana.mapper.GcCourseMapper;
import com.zhoukechanng.stuscoremana.service.GcCourseService;

@Service
public class GcCourseServiceImpl implements GcCourseService{

	@Autowired
	GcCourseMapper gcCourseMapper;
	
	
	@Override
	public List<Scores>findScores(String coursename,String type,String gcg,String gcc,int start, int pagesize ) {
		
		return gcCourseMapper.findScores(coursename,type,gcg, gcc,start, pagesize );
	}


	@Override
	public List<Scores> findAllScores(String coursename, String type, String gcg, String gcc) {
		
		return gcCourseMapper.findAllScores(coursename,type,gcg, gcc);
	}
    
    @Override
    public List<Scores> compClaScores(String coursename, String gcg) {
        // TODO Auto-generated method stub
        return gcCourseMapper.compClaScores(coursename, gcg);
    }
    
	@Override
	public int updateScores(Map map) {
		
		return gcCourseMapper.updateScores(map);
	}


	@Override
	public List<Scores> findPersonScore(String coursename, String num) {
		
		return gcCourseMapper.findPersonScore(coursename, num);
	}

}
