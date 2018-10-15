package test;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import com.bjsxt.sorm.core.DBManager;
import com.bjsxt.sorm.core.Query;
import com.bjsxt.sorm.core.QueryFactory;
import com.bjsxt.test.po.Emp;
import com.bjsxt.test.vo.EmpVo;

public class Test {
	/**
	 * 测试增添数据
	 */
	public static void testAdd() {
		Emp e = new Emp();
		e.setAge(18);
		e.setBonus(2300.0);
		e.setEmpname("谭智恒恒");
		
		Query q =QueryFactory.createQuery();
		q.insert(e);
	}
	/**
	 * 测试查数
	 */
	public static void testSelect01(){
		Query q = QueryFactory.createQuery();
		Number n = q.queryNumber("select count(*) from emp where salary>?", new Object[] {100});
		System.out.println(n);
	}
	/**
	 * 测试查一行
	 */
	public static void testSelect02() {
		Query q =QueryFactory.createQuery();
		Emp e = (Emp) q.queryUniqueRow("select * from emp where id=?", Emp.class, new Object[] {1});
		System.out.println(e.getEmpname());
	}
	/**
	 * 测试查多行多列
	 */
	public static void testSelect03() {
		Query q =QueryFactory.createQuery();
		List<Emp> list = (List) q.queryRows("select * from emp where id>?", Emp.class, new Object[] {1});
		System.out.println(list);
		for(Emp e:list) {
			System.out.println(e.getEmpname()+"-----"+e.getBirthday());
		}
	}
/**
 * 测试复杂查询
 */
	public static void testSelect04() {
		Query q =QueryFactory.createQuery();
		String sql ="select e.id,e.empname,salary+bonus 'xinshui',age,"
				+ "d.dname 'deptName',d.address 'deptAddr' from emp e join dept d on e.deptId=d.Id";
		List<EmpVo> list = (List) q.queryRows(sql, EmpVo.class, null);
		System.out.println(list);
		for(EmpVo e:list) {
			System.out.println(e.getEmpname()+"---"+e.getDeptAddr()+"---"+e.getXinshui());
		}
	}
	/**
	 * 测试删除
	 */
	public static void testDelete() {
		Emp e = new Emp();
		e.setId(4);
		
		Query q =QueryFactory.createQuery();
		q.delete(e);
	}
	/**
	 * 测试更新
	 */
	public static void testUpdate() {
		Emp e = new Emp();
		e.setAge(18);
		e.setBonus(2300.0);
		e.setEmpname("谭智恒恒");
		e.setId(1);
		Query q =QueryFactory.createQuery();
		q.update(e, new String[] {"age","bonus"});
	}
	/**
	 * 测试由主键获得对象
	 */
	public static void testQueryId() {
		Query q =QueryFactory.createQuery();
		Emp e =(Emp)q.queryById(Emp.class, 2);
		System.out.println(e.getEmpname());
	}
	
	public static void main(String[] args) {
		
//		//通过这个方法可以生成po类
//		TableContext.updateJavaPOFile();
//		testDelete();
////		testUpdate();
//		testSelect01();
//		testSelect02();
//		testSelect03();
//		testSelect04();
		//testQueryId();
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
				sqlRst.next();//移动记录指针指向下一条记录
				i++;//统计当前页已显示多少条记录
        }
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
        }
	}
}
