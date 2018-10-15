package lyons.entity;

import java.io.Serializable;
import java.util.LinkedList;

/**
 * 用户登陆实体类
 * @author Lyons(tzh)
 *
 */

public class Login implements Serializable
{
	private static final long serialVersionUID = -69203680249861342L;
	private String username = "";
	/**
	 * 未登录提示信息
	 */
	private String backNews = "未登录";
	private LinkedList<String> car = null;      //购物车、定单
	
	/**
	 * 构造器
	 * 为特定用户创建一个购物车car
	 * 
	 */
	public Login()
	{
		car = new LinkedList<String>();
	}
	/**
	 * 获得购物车链表容器<string>
	 * @return car
	 */
	public LinkedList<String> getCar()
	{
		return car;
	}
	/**
	 * 设置购物车（外部-->内部）
	 * @param car
	 */
	public void setCar(LinkedList<String> car)
	{
		this.car = car;
	}
	/**
	 * 获得用户名
	 * 如果用户名没有值，即username.trim()==""，返回字符串"userNull"
	 * <h5> ""在内存中开辟空间,但空间中没有值(""也是一个字符串) </h5>
	 * @return "userNull"||username
	 */
	public String getUsername()
	{
	    if (username.trim()=="")
        {
            return "userNull";
        }
		return username;
	}
	/**
	 * 传入用户名参数
	 * @param username
	 */
	public void setUsername(String username)
	{
		this.username = username;
	}
	/**
	 * 返回未登录提示信息
	 * @return
	 */
	public String getBackNews()
	{
		return backNews;
	}
	/**
	 * 设置未登录提示信息
	 * @param backNews
	 */
	public void setBackNews(String backNews)
	{
		this.backNews = backNews;
	}

}
