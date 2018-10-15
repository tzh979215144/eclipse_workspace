package com.dcfs.model;

public class User {
 public int userid;
 public String username;
 public String password;
public int getUserid() {
	return userid;
}
public void setUserid(int userid) {
	this.userid = userid;
}
public String getUsername() {
	return username;
}
public void setUsername(String username) {
	this.username = username;
}
public String getPassword() {
	return password;
}
public void setPassword(String password) {
	this.password = password;
}
public User(int userid, String username, String password) {
	super();
	this.userid = userid;
	this.username = username;
	this.password = password;
}
public User() {
	super();
}
@Override
public String toString() {
	return "User [userid=" + userid + ", username=" + username + ", password=" + password + "]";
}
}
