package com.bjsxt.tanpang;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * 测试JDBCUtil的用法，看看有多简化
 * @author tzh
 *
 */
public class TestUseUtil {
		public static void main(String[] args) {
			Connection conn= null;
			PreparedStatement ps = null;
			ResultSet rs = null;
			
			conn = JDBCUtil.getMysqlConn();
			try {
				ps = conn.prepareStatement("select * from testsql where name=?");
				ps.setString(1, "高琪1");
				
				rs = ps.executeQuery();
				while(rs.next()) {
					System.out.println(rs.getString(1)+"----"+rs.getString(2));
				}
				
			} catch (SQLException e) {
				e.printStackTrace();
			}finally {
				//这里bjsxt的代码不用将JDBCUtil的close方法重载为PreparedStatement类型的ps参数，但我这不行，怪
				//上面错误原因是因为导入了错误的包，应该要导入java.sql.Statement而不是com.bjsxt.tanpang.Statement
				JDBCUtil.close(rs, ps, conn);
			}
	}
}
