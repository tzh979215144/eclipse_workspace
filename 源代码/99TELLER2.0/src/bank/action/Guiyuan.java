package bank.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.json.JSONException;
import org.json.JSONObject;
import org.zhoukan.util.ConnectionPool;
import org.zhoukan.util.JDBCUtil;

/**
 * Servlet implementation class Guiyuan
 */
@WebServlet("/bank/Guiyuan")
public class Guiyuan extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Guiyuan() {
        super();
        // TODO Auto-generated constructor stub
    }
    
    public static void setPower_User_Role(Connection conn, String ROLE_ID,String USER_ID) {
		Statement ps =null;
		int rs =0;
		try {
			conn.setAutoCommit(false);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}//事物开始
		String sql = "Insert into POWER_USER_ROLE(ROLE_ID, USER_ID)Values('"+ROLE_ID+"', '"+USER_ID+"')";
		try {
			ps=conn.createStatement();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(ps);
		try {
			rs=ps.executeUpdate(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(rs < 0){               //插入失败
			try {
				conn.rollback();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}      //回滚
			try {
				ps.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return;
		}
		try {
			conn.commit();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}            //插入正常
		try {
			ps.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	
    }
    public static String getMaxId(Connection conn) {
		Statement ps =null;
		ResultSet rs =null;
		System.out.println(conn);
		
			try {
				conn.setAutoCommit(false);
			} catch (SQLException e) {
				e.printStackTrace();
			}//事物开始
			String sql1="select max(USER_ID) from POWER_USER_ROLE ";
			try {
				ps=conn.createStatement();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println(ps);
			try {
				rs=ps.executeQuery(sql1);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				if(rs.next()){               
					System.out.println(1+Integer.parseInt(rs.getString(1)));
					StringBuilder sb=new StringBuilder();
					sb.append("0");
					int i=1+Integer.parseInt(rs.getString(1));
					sb.append(""+i);
					
					
					return sb.toString();
					
				}
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
				return null;
			}finally {
			try {
				ps.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			}
			return null;
	}
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=UTF-8");
		Connection conn = ConnectionPool.getOneConn();
		Statement ps =null;
		int rs =0;
		String ROLE_ID=request.getParameter("USER_ID");
		String USER_NAME=request.getParameter("USER_NAME");
		String USER_SEX=request.getParameter("USER_SEX");
		String USER_AGE=request.getParameter("USER_AGE");
		String USER_IDCARD=request.getParameter("USER_IDCARD");
		String USER_PHONE=request.getParameter("USER_PHONE");
		String USER_PASSWORD=request.getParameter("USER_PASSWORD");
		String USER_CITY=request.getParameter("USER_CITY");
		String USER_ADDRESS=request.getParameter("USER_ADDRESS");
		String USER_STATUS=request.getParameter("USER_STATUS"); 
		String NET=request.getParameter("NET");
		System.out.println(conn);
		String USER_ID=getMaxId(conn);
		System.out.println(ROLE_ID);
		PrintWriter print=response.getWriter();
		try {
			conn.setAutoCommit(false);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}//事物开始
		String sql = "Insert into POWER_USER_INFO  (USER_ID, USER_NAME, USER_SEX, USER_AGE, USER_IDCARD, USER_PHONE, USER_PASSWORD, USER_CITY, USER_ADDRESS, USER_STATUS,  NET) "
				+ "Values('"+USER_ID+"','"+USER_NAME+"','"+USER_SEX+"','"+USER_AGE+"','"+USER_IDCARD+"','"+USER_PHONE+"','"+USER_PASSWORD+"','"+USER_CITY+"','"+USER_ADDRESS+"','"+USER_STATUS+"','"+NET+"')";
		try {
			ps=conn.createStatement();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(ps);
		try {
			rs=ps.executeUpdate(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(rs < 0){               //插入失败
			try {
				conn.rollback();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}      //回滚
			try {
				ps.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return;
		}
		try {
			conn.commit();
			setPower_User_Role(conn,ROLE_ID,USER_ID);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}            //插入正常
		try {
			ps.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try{

		    JSONObject jsonObj = new JSONObject();
		    
			response.setContentType("application/json");
			response.setCharacterEncoding("UTF-8");
			int userid=(int)(Math.random()*100000);

		    try {
				jsonObj.put("userid",String.valueOf(userid));
				
		        jsonObj.put("msg","1");
			} catch (JSONException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		    HttpSession session = request.getSession();
		    print.print(jsonObj.toString());

			print.flush();
		    print.close();
			}
			catch (Exception e) 
				{ 
				e.printStackTrace();
				
				} 
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
