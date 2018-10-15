package lyons.control;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import lyons.db.DbClose;
import lyons.db.DbConn;
import lyons.entity.Register;


/**
 * 注册处理
 * @author Lyons(tzh)
 *
 */

public class HandleRegister extends HttpServlet
{
	private static final long serialVersionUID = 1L;
	/**
	 * Constructor of the object.
	 */
	public HandleRegister()
	{
		super();
	}

	/**
	 * Destruction of the servlet. <br>
	 */
	public void destroy()
	{
		super.destroy(); 
	}

/**
 * 调用了doPost(request,response)
 */
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException
	{
		doPost(request, response);
	}
/**
 * 处理注册，逻辑判断和正则匹配check，返回提示信息到Register对象
 */
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException
	{

		response.setContentType("text/html;charset=UTF-8");
		request.setCharacterEncoding("UTF-8");
		
		Register userBean = new Register();
		request.setAttribute("userBean", userBean);
		//在register.jsp中有个BUG，即value的赋值不加"<jsp:***>"，会出现自增字符/
		String username = userBean.getUsername();
		String userpass = userBean.getUserpass();
		String again_userpass = userBean.getUserpass();
		String phone = userBean.getPhone();
		String address = userBean.getAddress();
		String realname = userBean.getRealname();
		if(request.getParameter("username")!="")
		username = request.getParameter("username").trim();
		if(request.getParameter("userpass")!="")
		userpass = request.getParameter("userpass").trim();
		if(request.getParameter("again_userpass")!="")
		again_userpass = request.getParameter("again_userpass").trim();
		if(request.getParameter("phone")!="")
		phone = request.getParameter("phone").trim();
		if(request.getParameter("address")!="")
		address = request.getParameter("address").trim();
		if(request.getParameter("realname")!="")
		realname = request.getParameter("realname").trim();
		userBean.setAddress(address);
		userBean.setPhone(phone);
		userBean.setRealname(realname);
		userBean.setUsername(username);
		userBean.setUserpass(userpass);
		System.out.println(username);
		if (username==null)
		{
			username = "";
		}
		if (userpass==""|userpass==null)
		{
			userpass = "error";
		}

		String regex = "[\\d]{11}";
		if (!(again_userpass.equals(userpass)))
		{
			userBean.setBackNews("两次密码不一致,注册失败");
			request.getRequestDispatcher("/jsp/join/register.jsp").forward(request, response);
		}else if (phone!=null&&phone.length()>0&&!phone.matches(regex)) 
				{
						userBean.setBackNews("请正确填写11位手机号");
						request.getRequestDispatcher("/jsp/join/register.jsp").forward(request, response);
						return;
				}else 
					{
						String backNews = ""; 
						boolean userFlag = userpass.length()>5;
						if (userFlag)
						{
							Connection        conn  = null;
							PreparedStatement pstmt = null;
							
							conn = DbConn.getConn();
							String sql = "INSERT INTO vip(username,userpass,phone,address,realname) VALUES(?,?,?,?,?)";
							
							try
							{
								pstmt = conn.prepareStatement(sql);
								pstmt.setString(1,username);
								pstmt.setString(2,userpass); 
								pstmt.setString(3,phone);
								pstmt.setString(4,address);
								pstmt.setString(5,realname);
								
								int rs = pstmt.executeUpdate();
								if (rs > 0)
								{
									backNews = "注册成功";
									userBean.setBackNews(backNews);
									request.getRequestDispatcher("/jsp/join/registerSuccess.jsp").forward(request, response);
								}
							} catch (SQLException e)
							{
							    System.out.println(e);
								backNews = "该用户名已被注册"+"<br>";
								userBean.setBackNews(backNews);
								request.getRequestDispatcher("/jsp/join/register.jsp").forward(request, response);
							}finally
							{
								DbClose.close(pstmt, conn);
							}
						}else 
						{
							userBean.setBackNews("密码不合法");
							request.getRequestDispatcher("/jsp/join/register.jsp").forward(request, response);
						}
					}
	}

	public void init() throws ServletException
	{
	}

}
