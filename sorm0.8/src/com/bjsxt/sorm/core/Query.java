package com.bjsxt.sorm.core;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.bjsxt.sorm.bean.ColumnInfo;
import com.bjsxt.sorm.bean.TableInfo;
import com.bjsxt.sorm.util.JDBCUtils;
import com.bjsxt.sorm.util.ReflectUtils;
import com.bjsxt.sorm.util.StringUtils;

import som.bjsxt.sorm.pool.DBConnPool;

/**
 * 
 * 负责查询（对外提供服务的核心类）
 * @author tzh
 *
 */
@SuppressWarnings("all")//压制警告
public abstract class Query  implements Cloneable{
	//增删改一类，查询一类
	
	
	/**
	 * 采用模板方法模式将JDBC操作封装成模板，便于重用
	 * @param sql sql语句
	 * @param params sql参数
	 * @param clazz 记录要封装的Java类
	 * @param back 回调方法（匿名实现类）--
	 * @return
	 */
	public Object executeQueryTemplate(String sql,Object[] params,Class clazz,CallBack back) {
		Connection conn = DBManager.getConn();
		List list = null; //存储查询结果的容器
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			ps = conn.prepareStatement(sql);
			//给sql设参
			JDBCUtils.handleParams(ps, params);
			System.out.println(ps);
			rs = ps.executeQuery();
			
			return back.doExecute(conn, ps, rs);
		}catch (Exception e) {
			return null;
		}finally {
			DBManager.close(rs, ps, conn);
		}
	}
	/**
	 * 直接执行一个DML语句
	 * @param sql　　sql 语句
	 * @param params 参数
	 * @return	执行sql语句后影响的记录行数
	 */
	//********************************执行DML语句****************************************************
	public int executeDML(String sql,Object[] params) {

		Connection conn = DBManager.getConn();
		int count = 0;
		PreparedStatement ps =null;
		try {
			ps = conn.prepareStatement(sql);
			//给sql设参
			JDBCUtils.handleParams(ps, params);
		
			count = ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			DBManager.close(null,ps, conn);
		}
		return count;
	
	}
	
	/**
	 * 讲一个对象存储到数据库中
	 * 把对象不为null的属性往数据库中储存，如果数字为null则放0；
	 * @param obj　要存储的对象
	 */
	public void insert (Object obj) {

		//obj-->表中,	insert into 表名 (id,uname.pwd) values (?,?,?)
		Class c = obj.getClass();
		List<Object> params = new ArrayList<Object>();//存储sql的参数对象
		TableInfo tableInfo = TableContext.poClassTableMap.get(c);
		StringBuilder sql = new StringBuilder("insert into "+tableInfo.getTname()+" (");
		int countNotNullField = 0; //计算不为null的属性值
		Field[] fs = c.getDeclaredFields();//通过反射获取对象的属性列表
		for(Field f:fs) {
			String fieldName = f.getName();
			Object fieldValue = ReflectUtils.invokeGet(fieldName, obj);
			
			if(fieldValue!=null) {
				countNotNullField++;
				sql.append(fieldName+",");
				params.add(fieldValue);
			}
		}
		sql.setCharAt(sql.length()-1, ')');
		sql.append(" values (");
		for(int i=0;i<countNotNullField;i++) {
			sql.append("?,");
		}
		sql.setCharAt(sql.length()-1, ')');
		executeDML(sql.toString(),params.toArray());
	
	}
	/**
	 * 删除clazz表示类对应的表中的记录（指定主键值id的记录）
	 * @param clazz　跟表对应的类的Class对象
	 * @param id　主键的值
	 * @return
	 */
	public void delete(Class clazz, Object id) {

		//Emp.class,2--->delete from emp where id=2
	
		//通过class对象找TableInfo
		TableInfo tableInfo = TableContext.poClassTableMap.get(clazz);
		//获得主键
		ColumnInfo onlyPrikey = tableInfo.getOnlyPriKey();
		
		String sql = "delete from "+tableInfo.getTname()+" where "+onlyPrikey.getName()+"=?";
		
		executeDML(sql,new Object[] {id});

	}
	/**
	 * 删除对象在数据库中对应的记录（对象所在的类对应到表，对象的主键的值对应到记录）
	 * @param obj
	 */
	public void delete(Object obj) {


		Class c = obj.getClass();
		//通过class对象找TableInfo
		TableInfo tableInfo = TableContext.poClassTableMap.get(c);
		ColumnInfo onlyPrikey = tableInfo.getOnlyPriKey();		//获得主键
		
		//通过反射机制，调用属性对应的get和set方法
		try {
			Method m = c.getMethod("get"+StringUtils.firstChar2UpperCase(onlyPrikey.getName()), null);
			Object priKeyValue = m.invoke(obj, null);
			delete(c,priKeyValue);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
	
	}
	
	/**
	 * 根系对象对应的记录，并且只更新指定的字段的值
	 * @param obj　所要更新的对象
	 * @param fieldNames	　所要更新的属性列表
	 * @return	执行Ｓｑｌ语句后更新记录的行数
	 */
	public int update(Object obj,String[] fieldNames) {

		//obj{"uname","pwd"} --> update 表名 set uname=?,pwd=? where id=?;
		Class c = obj.getClass();
		List<Object> params = new ArrayList<Object>();
		TableInfo tableInfo = TableContext.poClassTableMap.get(c);
		ColumnInfo  priKey = tableInfo.getOnlyPriKey();
		StringBuilder sql = new StringBuilder("update "+tableInfo.getTname()+" set ");
		
		for(String fname:fieldNames) {
			Object fvalue = ReflectUtils.invokeGet(fname, obj);
			params.add(fvalue);
			sql.append(fname+"=?,");
		}
		sql.setCharAt(sql.length()-1,' ');
		sql.append(" where "+priKey.getName()+"=?");
		
		params.add(ReflectUtils.invokeGet(priKey.getName(), obj));
		
		return executeDML(sql.toString(),params.toArray());
	
	}
	

	/**
	 * 查询返回多行对象，并将每行记录到ｃｌａｚｚ指定的类的对象中
	 * @param sql　查询语句
	 * @param clazz 封装数据的javabean类的Class对象
	 * @param params ｓｑｌ的参数
	 * @return　查询到的结果Ｌｉｓｔ
	 */
	public List queryRows(String sql,Class clazz,Object[] params) {

		return (List)executeQueryTemplate(sql,params,clazz,new CallBack() {
			@Override
			public Object doExecute(Connection conn, PreparedStatement ps, ResultSet rs) {
				List list =null;
				
				ResultSetMetaData metaData;
				try {
					metaData = rs.getMetaData();
					//多行
					while(rs.next()) {
						if(list ==null) {
							list = new ArrayList();
						}
						Object rowObj = clazz.newInstance();		//调用Javabean的无参构造器
						
						//多列 select usename,pwd,age from user where id>? and age>18
						for(int i =0;i<metaData.getColumnCount();i++) {
							String columnName = metaData.getColumnLabel(i+1);
							Object columnValue = rs.getObject(1+i);
							
							//调用rowObj对象的set方法，讲columnValue的值设置进去
							ReflectUtils.invokeSet(rowObj, columnName, columnValue);
						}
						list.add(rowObj);
					}
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				return list;
			}
		});
	}
	
	/**
	 * 查询返回一行对象，并将每行记录到ｃｌａｚｚ指定的类的对象中
	 * @param sql　查询语句
	 * @param clazz 封装数据的javabean类的Class对象
	 * @param params ｓｑｌ的参数
	 * @return　查询到的结果.一行:Object
	 */
	public Object queryUniqueRow(String sql,Class clazz,Object[] params) {

		//select count*) from emp where id>1;
		List list = queryRows(sql,clazz,params);
		return (list!=null&&list.size()>0)?list.get(0):null;
	}
	
	/**
	 * 根据主键的值直接查找对应的对象
	 * @param clazz
	 * @param id
	 * @return
	 */
	public Object queryById(Class clazz,Object id) {
		//select * from emp where id=?
		//通过class对象找TableInfo
		TableInfo tableInfo = TableContext.poClassTableMap.get(clazz);
		ColumnInfo onlyPrikey = tableInfo.getOnlyPriKey();		//获得主键
		
		String sql = "select * from "+tableInfo.getTname()+" where "+onlyPrikey.getName()+"=?";
		return queryUniqueRow(sql, clazz, new Object[] {id});
		
	}
	
	/**
	 * 查询返回一个值（一行一列），并将该值返回
	 * @param sql　查询语句
	 * @param params ｓｑｌ的参数
	 * @return　查询到的结果
	 */
	public Object queryValue(String sql,Object[] params) {
		
		return executeQueryTemplate(sql,params,null,new CallBack() {
			@Override
			public Object doExecute(Connection conn, PreparedStatement ps, ResultSet rs) {
				Object value = null;
				try {
					while(rs.next()) {
						value = rs.getObject(1);
					}
				} catch (SQLException e) {
					e.printStackTrace();
				}
				return value;
			}
		});
	}
	
	/**
	 * 查询返回一个Number（一行一列），并将该Number返回
	 * @param sql　查询语句
	 * @param params ｓｑｌ的参数
	 * @return　查询到的结果
	 */
	public Number queryNumber(String sql,Object[] params) {
		//Number 就包含了 byte, double, float, int, long, and short
		return (Number)queryValue(sql,params);
	
	}
	/**
	 * 分页查询
	 * @param pageNum 第几页
	 * @param size 每页显示多少记录
	 * @return
	 */
	public abstract Object queryPagenate(int pageNum,int size);
	
	@Override
	protected Object clone() throws CloneNotSupportedException {
		return super.clone();
	}
}
