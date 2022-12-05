package com.zhoukechanng.stuscoremana.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zhoukechanng.stuscoremana.entity.Admin;
import com.zhoukechanng.stuscoremana.mapper.AdminMapper;
import com.zhoukechanng.stuscoremana.service.AdminService;


@Service
public class AdminServiceImpl implements AdminService {
	@Autowired
	AdminMapper adminMapper;

	@Override
	public List<Admin> findAdmin(String account, String psw) {
		// TODO Auto-generated method stub
		return adminMapper.findAdmin(account, psw);
	}

}
