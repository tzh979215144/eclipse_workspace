package lyons.entity;

import java.io.Serializable;

/**
 * 用户注册实体类
 * @author Lyons(tzh)
 *
 */
public class Register implements Serializable
{
	private static final long serialVersionUID = -1465928336863533909L;
	
	private String username="*必填 ";
	private String userpass="*必填 ";
	private String phone="*必填 ";
	private String address="选填 ";
	private String realname="选填 ";
	private String backNews = "请注册 ";
/**
 * 继承父类方法
 */
	public Register()
	{
		super();
	}
	
	public String getUsername()
	{
		return username;
	}
	public void setUsername(String username)
	{
		this.username = username;
	}
	public String getUserpass()
	{
		return userpass;
	}
	public void setUserpass(String userpass)
	{
		this.userpass = userpass;
	}
	public String getPhone()
	{
		return phone;
	}
	public void setPhone(String phone)
	{
		this.phone = phone;
	}
	public String getAddress()
	{
		return address;
	}
	public void setAddress(String address)
	{
		this.address = address;
	}
	public String getRealname()
	{
		return realname;
	}
	public void setRealname(String realname)
	{
		this.realname = realname;
	}
/**
 * 获取提示信息
 * @return
 */
	public String getBackNews()
	{
		return backNews;
	}
/**
 * 设置回馈提示信息
 * @param backNews
 */
	public void setBackNews(String backNews)
	{
		this.backNews = backNews;
	}
	
	
}
