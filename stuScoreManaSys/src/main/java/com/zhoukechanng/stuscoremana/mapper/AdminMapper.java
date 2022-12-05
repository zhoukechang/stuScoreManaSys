package com.zhoukechanng.stuscoremana.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.zhoukechanng.stuscoremana.entity.Admin;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface AdminMapper {
    @Select("select * from admin where account=#{0} and psw=#{1}")
	public List<Admin> findAdmin(String account, String psw);
}
