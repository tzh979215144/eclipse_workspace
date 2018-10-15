<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page language="java" import="java.sql.*" %>
<%@ page language="java" import="com.bjsxt.sorm.core.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>数据库操作</title>
</head>
<body>
<%    
				int intPageSize = 10;             //一页显示的记录数 
				int intRowCount=9;                 //记录总数 
				int intPageCount=9;                 //总页数 
				String strPage="9";                    //从表单或URL传送的待显示页码
				int intPage =5;                     //待显示页码 ，由strPage转换成的整数
				Connection conn = DBManager.getConn();
				Statement sqlStmt = null;
				ResultSet sqlRst =null;
				try {
				//---计算记录总数的第一种方法：查询出所有记录，移动结果集指针到最后一条，获取最后一条记录的行号
				//查询所有数据
					sqlStmt =conn.createStatement();
						sqlRst = sqlStmt.executeQuery("select * from student");
						 		//获取记录总数 
							sqlRst.last();                    //光标在最后一行
							intRowCount = sqlRst.getRow();    //获得当前行号，即总记录数
							//记算总页数
							intPageCount = (int)Math.ceil(intRowCount/(intPageSize*1.0));
				
				
				
				//将记录指针定位到待显示页的第一条记录上 
					sqlRst.absolute((intPage - 1) * intPageSize + 1);
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				//显示数据 
				int i=0;
				int stuno,age;
				String stuname, sex;
				try {
				while (i < intPageSize && !sqlRst.isAfterLast()) {
				    	stuno = sqlRst.getInt(1);
						stuname = sqlRst.getString(2);
						sex = sqlRst.getString(3);
						age = sqlRst.getInt(4);
						//System.out.println(stuno+"---"+stuname+"--"+sex+"----"+age);
            %>
            <tr>
                <td><%=stuno%></td>
                <td><%=stuname%></td>
                <td><%=sex%></td>
                <td><%=age%></td>
            </tr>
            <%
    		sqlRst.next();//移动记录指针指向下一条记录
			i++;//统计当前页已显示多少条记录
    }
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
    }
            %>
</body>
</html>