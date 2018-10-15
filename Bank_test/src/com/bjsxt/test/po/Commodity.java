package com.bjsxt.test.po;

import java.sql.*;
import java.util.*;

public class Commodity {

	private Integer commodity_number;
	private Integer commodity_id;
	private Integer commodity_price;
	private String commodity_made;
	private String commodity_pic;
	private Integer commodity_balance;
	private String commodity_name;


	public Integer getCommodity_number(){
		return commodity_number;
	}
	public Integer getCommodity_id(){
		return commodity_id;
	}
	public Integer getCommodity_price(){
		return commodity_price;
	}
	public String getCommodity_made(){
		return commodity_made;
	}
	public String getCommodity_pic(){
		return commodity_pic;
	}
	public Integer getCommodity_balance(){
		return commodity_balance;
	}
	public String getCommodity_name(){
		return commodity_name;
	}


	public void setCommodity_number(Integer commodity_number){
		this.commodity_number=commodity_number;
	}
	public void setCommodity_id(Integer commodity_id){
		this.commodity_id=commodity_id;
	}
	public void setCommodity_price(Integer commodity_price){
		this.commodity_price=commodity_price;
	}
	public void setCommodity_made(String commodity_made){
		this.commodity_made=commodity_made;
	}
	public void setCommodity_pic(String commodity_pic){
		this.commodity_pic=commodity_pic;
	}
	public void setCommodity_balance(Integer commodity_balance){
		this.commodity_balance=commodity_balance;
	}
	public void setCommodity_name(String commodity_name){
		this.commodity_name=commodity_name;
	}


}
