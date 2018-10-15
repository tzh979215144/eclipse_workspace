package com.dcfs.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


import com.dcfs.util.DbUtil;

public class UserLogin {

	public boolean login(String username,String password) throws SQLException, Exception{
		String sql = "select * from ysuser where yname=? and ypassword=?";
		DbUtil conn=new DbUtil();
		PreparedStatement pstmt = conn.getCon().prepareStatement(sql);
		pstmt.setString(1,username);
		pstmt.setString(2,password);
		ResultSet rs = pstmt.executeQuery();
		if(rs.next()) {

			return true;
	
	}else{
		return false;
	}
		
}
	
}
