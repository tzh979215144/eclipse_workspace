package com.bjsxt.test.po;

import java.sql.*;
import java.util.*;

public class OrderForm {

	private Integer commodity_price;
	private Integer sum;
	private Integer id;
	private java.sql.Timestamp orderDate;
	private String username;
	private String commodity_name;


	public Integer getCommodity_price(){
		return commodity_price;
	}
	public Integer getSum(){
		return sum;
	}
	public Integer getId(){
		return id;
	}
	public java.sql.Timestamp getOrderDate(){
		return orderDate;
	}
	public String getUsername(){
		return username;
	}
	public String getCommodity_name(){
		return commodity_name;
	}


	public void setCommodity_price(Integer commodity_price){
		this.commodity_price=commodity_price;
	}
	public void setSum(Integer sum){
		this.sum=sum;
	}
	public void setId(Integer id){
		this.id=id;
	}
	public void setOrderDate(java.sql.Timestamp orderDate){
		this.orderDate=orderDate;
	}
	public void setUsername(String username){
		this.username=username;
	}
	public void setCommodity_name(String commodity_name){
		this.commodity_name=commodity_name;
	}


}
