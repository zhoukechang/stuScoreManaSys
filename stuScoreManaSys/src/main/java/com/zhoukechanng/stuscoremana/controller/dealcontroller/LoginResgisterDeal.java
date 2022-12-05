package com.zhoukechanng.stuscoremana.controller.dealcontroller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import com.alibaba.fastjson.JSON;
import com.zhoukechanng.stuscoremana.entity.Admin;
import com.zhoukechanng.stuscoremana.entity.Stu;
import com.zhoukechanng.stuscoremana.entity.Teacher;
import com.zhoukechanng.stuscoremana.service.AdminService;
import com.zhoukechanng.stuscoremana.service.StuService;
import com.zhoukechanng.stuscoremana.service.TeacherService;
import com.zhoukechanng.stuscoremana.tools.MyTool;

import cn.hutool.crypto.SecureUtil;

@Controller
@RequestMapping("/Sys")
public class LoginResgisterDeal {

	@Autowired
	AdminService adminService;

	@Autowired
	StuService stuService;

	@Autowired
	TeacherService teacherService;
	
	


	
    @ResponseBody
	@RequestMapping(value = "/dealLogin")
	public String getInfo(@RequestParam(value = "num") String num, @RequestParam(value = "psw") String psw,
			@RequestParam(value = "identify") String identify, HttpSession httpSession) {

		String dataJson = "fail";
		if (Integer.parseInt(identify) == 0) {
			List<Admin> adminList = new ArrayList<>();
			adminList = adminService.findAdmin(num, SecureUtil.md5(psw));
			if (adminList.size() > 0) {
				String account = adminList.get(0).getAccount();
				String name = adminList.get(0).getName();
				httpSession.setAttribute("account", account);
				httpSession.setAttribute("name", name);
				httpSession.setAttribute("role", "admin");
				dataJson = JSON.toJSONString(adminList);
				return dataJson;
			}
		} else if (Integer.parseInt(identify) == 1) {
			List<Teacher> teaList = new ArrayList<>();
			teaList = teacherService.findTeacher(num, SecureUtil.md5(psw));
			if (teaList.size() > 0) {
				String name = teaList.get(0).getName();
				String account = teaList.get(0).getTeachno();
				httpSession.setAttribute("account", account);
				httpSession.setAttribute("name", name);
				httpSession.setAttribute("role", "teacher");
				dataJson = JSON.toJSONString(teaList);
				return dataJson;
			}
		} else if (Integer.parseInt(identify) == 2) {
			List<Stu> stuList = new ArrayList<>();
			stuList = stuService.findStu(num, SecureUtil.md5(psw));
			if (stuList.size() > 0) {
				String name = stuList.get(0).getName();
				String account = stuList.get(0).getStuno();
				httpSession.setAttribute("account", account);
				httpSession.setAttribute("name", name);
				httpSession.setAttribute("role", "stu");
				dataJson = JSON.toJSONString(stuList);
				return dataJson;
			}
		}
		return "fail";
	}
	
	
	@RequestMapping(value = "/registerStuDeal")
	@ResponseBody
	public String registerDeal(@RequestBody Map map) {
		System.out.println("stu psw:"+map.get("psw"));
		map.put("psw", SecureUtil.md5(map.get("psw").toString()));
		if (stuService.addStu(map) > 0) {
			return "success";
		}

		return "failure";
	}
 
	
	@RequestMapping(value = "/registerTeaDeal")
	@ResponseBody
	public String registerTeaDeal(@RequestBody Map map) {
		System.out.println("teacher psw:"+map.get("psw"));
		map.put("psw", SecureUtil.md5(map.get("psw").toString()));
		
		if (teacherService.addTeacher(map) > 0) {
			return "success";
		}

		return "failure";
	}

}
