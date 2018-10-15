package lyons.db;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;
/**
 * 连接数据库
 * @author Lyons(tzh)
 *
 */
public class DbConn
{
	/*public static void main(String[] args) {
		System.out.println(DbConn.getConn());
		System.out.println("****");
	}*/
	
	static Properties pros = null;//可以帮助读取和处理资源文件中的信息
	
	//只会类被的时候执行一次
		static {		//加载JDBCUtil类的时候调用，只需要一次
			pros = new Properties();
			try {
				pros.load(Thread.currentThread().getContextClassLoader().getResourceAsStream("db.properties"));
				System.out.println("111111111111");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				System.out.println("22222222222");
				e.printStackTrace();
			}
		}
	/**
	 * 返回一个MySQL连接
	 * @return
	 */
	public static Connection getConn()
	{		
		try {
			Class.forName(pros.getProperty("mysqlDriver"));
			//Class.forName("com.mysql.jdbc.Driver");
			return DriverManager.getConnection(pros.getProperty("mysqlURL"), pros.getProperty("mysqlUser"),
					pros.getProperty("mysqlPwd"));
			//return DriverManager.getConnection("jdbc:mysql://localhost:3306/gouwu", "root", "19961026");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("here");
			return null;
		} 
		

	}

}
