package com.zhoukechanng.stuscoremana.entity;

public class Stu {
	private String stuno;
	private String name;
	private String psw;
	private String sex;
	private String phone;
	public Stu() {
		super();
	}
	public Stu(String stuno, String name, String psw, String sex, String phone) {
		super();
		this.stuno = stuno;
		this.name = name;
		this.psw = psw;
		this.sex = sex;
		this.phone = phone;
	}
	public Stu(String stuno, String name, String sex) {
		super();
		this.stuno = stuno;
		this.name = name;
		this.sex = sex;
		
	}
	public String getStuno() {
		return stuno;
	}
	public void setStuno(String stuno) {
		this.stuno = stuno;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPsw() {
		return psw;
	}
	public void setPsw(String psw) {
		this.psw = psw;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	@Override
	public String toString() {
		return "Stu [stuno=" + stuno + ", name=" + name + ", psw=" + psw + ", sex=" + sex + ", phone=" + phone + "]";
	}
	
	
}
