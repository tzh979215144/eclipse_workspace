package bank.action;

import java.io.IOException;
import java.sql.Connection;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.zhoukan.util.JDBCUtil;

/**
 * Servlet implementation class OpenAcc
 */
@WebServlet("/OpenAcc")
public class openacc extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			
			request.setCharacterEncoding("utf-8");
			response.setContentType("text/html;charset=UTF-8");
			Connection conn=JDBCUtil.getMysqlConn();
			Statement ps =null;
			String CLIENT_NO = request.getParameter("CLIENT_NO");
			String GLOBAL_ID_TYPE =request.getParameter("GLOBAL_ID_TYPE");
			String GLOBAL_ID =request.getParameter("GLOBAL_ID");
			String country = request.getParameter("country");
			String CLIENT_TYPE =request.getParameter("CLIENT_TYPE");
			String FM_CLIENT_TYPE = request.getParameter("FM_CLIENT_TYPE");
			String name =request.getParameter("name");
			String sex =request.getParameter("sex");
			String CLIENT_TEL =request.getParameter("CLIENT_TEL");
			String LOCATION =request.getParameter("LOCATION");
			
			try {
				String sql = "insert into user_info values('"+CLIENT_NO+"','"+GLOBAL_ID_TYPE+"','"+GLOBAL_ID+"','"+country+"','"+CLIENT_TYPE+"','"+FM_CLIENT_TYPE+"','"+name+"','"+sex+"','"+CLIENT_TEL+"','"+LOCATION+"')";
				ps=conn.createStatement();
				ps.executeUpdate(sql);
			} catch (Exception e) {
				// TODO: handle exception
				System.out.println("执行错误！");
			}finally {
				JDBCUtil.close(null, ps, conn);
			}
	
	
	
	
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
