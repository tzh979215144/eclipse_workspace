package org.zhoukan.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.zhoukan.bean.MenuBean;
import org.zhoukan.util.ConnectionPool;

public class MainMenuSP {

	public List<MenuBean> getMenu(String name){
		
		List<MenuBean> beans = new ArrayList<MenuBean>();
		Connection conn =  ConnectionPool.getOneConn();
		CallableStatement cs = null;
		ResultSet rs = null;
		try {
			cs = conn.prepareCall("{call sp_Main_menu(?,?)}");
			cs.setString(1, name);
			cs.registerOutParameter(2, oracle.jdbc.OracleTypes.CURSOR);
			cs.execute();
			rs = (ResultSet)cs.getObject(2);
			while(rs.next()){
				MenuBean bean = new MenuBean();
				bean.setPOWER_ID(rs.getString("POWER_ID"));
				bean.setPOWER_NAME(rs.getString("POWER_NAME"));
				bean.setPOWER_PATH("POWER_PATH");
				bean.setPOWER_FATHER("POWER_FATHER");
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
		MainMenuSP mainMenu = new MainMenuSP();
		List<MenuBean> list = mainMenu.getMenu("zhangwenjia");
		for(int i = 0; i < list.size(); i++){
			String id = list.get(i).getPOWER_ID();
			String name = list.get(i).getPOWER_NAME();
			System.out.println(id+"  "+name);
		}
	}
}
