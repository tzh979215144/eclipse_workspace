package bank.action;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.zhoukan.bean.user_info;
import org.zhoukan.util.JDBCUtil;

/**
 * Servlet implementation class dropAcc
 */
@WebServlet("/dropAcc")
public class dropAcc extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=UTF-8");
		Connection conn=JDBCUtil.getMysqlConn();
		System.out.println(conn);
		Statement ps =null;
		ResultSet rs= null;
		user_info user=new user_info();
		String CLIENT_NO = request.getParameter("CLIENT_NO");
		String flag=(String)request.getParameter("flag");
		try {
				if(flag.equals("1")) {
					
					String sql = "select * from user_info where CLIENT_NO = '"+CLIENT_NO+"' ";
					ps=conn.createStatement();
					rs = ps.executeQuery(sql);
					while(rs.next()) {
						user.setCLIENT_NO(rs.getString(1));
						user.setGLOBAL_ID_TYPE(rs.getString(2));
						user.setGLOBAL_ID(rs.getString(3));
						user.setCountry(rs.getString(4));
						user.setCLIENT_TYPE(rs.getString(5));
						user.setFM_CLIENT_TYPE(rs.getString(6));
						user.setName(rs.getString(7));
						user.setSex(rs.getString(8));
						user.setCLIENT_TEL(rs.getString(9));
						user.setLOCATION(rs.getString(10));
						}
					HttpSession session = request.getSession();
					session.setAttribute("user", user);
					response.sendRedirect("/TELLER2.0/bank/showAcc.jsp");
				}
				else if(flag.equals("2")) {
					String sql = "delete from user_info where CLIENT_NO = '"+CLIENT_NO+"' ";
					ps=conn.createStatement();
					ps.executeUpdate(sql);
				}
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("执行错误！");
		}finally {
			JDBCUtil.close(null, ps, conn);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
