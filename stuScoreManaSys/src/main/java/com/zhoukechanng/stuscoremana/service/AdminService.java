package com.zhoukechanng.stuscoremana.service;

import java.util.List;

import com.zhoukechanng.stuscoremana.entity.Admin;

public interface AdminService {
	public List<Admin> findAdmin(String account, String psw);
}
