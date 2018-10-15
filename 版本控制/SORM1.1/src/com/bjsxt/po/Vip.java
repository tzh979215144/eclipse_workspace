package com.bjsxt.po;

import java.sql.*;
import java.util.*;

public class Vip {

	private String address;
	private String phone;
	private String userpass;
	private String username;
	private String realname;


	public String getAddress(){
		return address;
	}
	public String getPhone(){
		return phone;
	}
	public String getUserpass(){
		return userpass;
	}
	public String getUsername(){
		return username;
	}
	public String getRealname(){
		return realname;
	}


	public void setAddress(String address){
		this.address=address;
	}
	public void setPhone(String phone){
		this.phone=phone;
	}
	public void setUserpass(String userpass){
		this.userpass=userpass;
	}
	public void setUsername(String username){
		this.username=username;
	}
	public void setRealname(String realname){
		this.realname=realname;
	}


}
