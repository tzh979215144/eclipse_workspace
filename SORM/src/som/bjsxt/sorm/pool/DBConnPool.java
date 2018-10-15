package som.bjsxt.sorm.pool;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.bjsxt.sorm.core.DBManager;

/**
 * 连接池类
 * @author tanpang
 *
 */
public class DBConnPool {
	/**
	 * 	连接池对象
	 */
	private static List<Connection> pool;
	/**
	 * 最大连接数
	 */
	private static final int POOL_MAX_SIZE = DBManager.getConf().getPoolMaxSize();
	/**
	 * 最小连接数
	 */
	private static final int POOL_MIN_SIZE = DBManager.getConf().getPoolMinSize();
	
	public static List<Connection> getPool() {
		return pool;
	}
	public static void setPool(List<Connection> pool) {
		DBConnPool.pool = pool;
	}
	/**
	 * 初始化连接池，使池中连接数达到最小连接值
	 */
	public void initPool() {
		if(pool==null) {
			pool = new ArrayList<Connection>();
		}
		
		while(pool.size()<DBConnPool.POOL_MIN_SIZE) {
			pool.add(DBManager.createConn());
			System.out.println("初始化连接池，池中连接数："+pool.size());
		}
	}
/**
 * 从连接池中取出一个连接
 * @return
 */
	public synchronized Connection getConnection() {
		int last_index = pool.size()-1;			//取最后一个
		Connection conn = pool.get(last_index);
		pool.remove(last_index);			//得到之后要移除
		return conn;
		
	}
	/**
	 * 关闭conn---->将连接放回池中
	 * @param conn
	 */
	public synchronized void close(Connection conn) {
		if(pool.size()<DBConnPool.POOL_MAX_SIZE) {
			pool.add(conn);
		}else {
			try {
				conn.close();		//如果池达到最大值，则真的关闭
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	
	
	public DBConnPool() {
		initPool();
	}
	
	
}
