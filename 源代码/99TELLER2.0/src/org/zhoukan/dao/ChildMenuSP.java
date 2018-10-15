package org.zhoukan.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.zhoukan.bean.MenuBean;
import org.zhoukan.util.ConnectionPool;

public class ChildMenuSP {

public List<MenuBean> getMenu(String name,String id){
		
		List<MenuBean> beans = new ArrayList<MenuBean>();
		Connection conn =  ConnectionPool.getOneConn();
		CallableStatement cs = null;
		ResultSet rs = null;
		try {
			cs = conn.prepareCall("{call sp_child_menu(?,?,?)}");
			cs.setString(1, name);
			cs.setString(2, id);
			cs.registerOutParameter(3, oracle.jdbc.OracleTypes.CURSOR);
			cs.execute();
			rs = (ResultSet)cs.getObject(3);
			while(rs.next()){
				MenuBean bean = new MenuBean();
				bean.setPOWER_ID(rs.getString("POWER_ID"));
				bean.setPOWER_NAME(rs.getString("POWER_NAME"));
				bean.setPOWER_PATH(rs.getString("PAGE_PATH"));
				bean.setPOWER_FATHER(rs.getString("POWER_FATHER"));
				beans.add(bean);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally{
			try {
				if(rs != null){
					rs.close();
				}
				if(cs != null){
					cs.close();
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			if(conn != null){
				ConnectionPool.backOneConn(conn);
			}
		}
		
		return beans;
	}
public static void main(String[] args) {
	ChildMenuSP mainMenu = new ChildMenuSP();
	List<MenuBean> list = mainMenu.getMenu("zhangwenjia","02");
	for(int i = 0; i < list.size(); i++){
		String id = list.get(i).getPOWER_ID();
		String name = list.get(i).getPOWER_NAME();
		String path = list.get(i).getPOWER_PATH();
		System.out.println(id+"  "+name+"  "+path);
	}
}
}
