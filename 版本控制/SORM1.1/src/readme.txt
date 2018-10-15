配置信息（数据）--->		配置信息的读取 	    --->  封装到javabean类里
	db.properties	  --->		Properties类加载	--->	Configuration.java
/---------------到此已经可以连接数据库了------------------------

两个接口：Query和TypeConvertor 类，是想到了MySQL和其他数据库之间的差异性和统一性

						Query											TypeConvertor	:数据库类型和Java类型之间的转换
					/			\
				  /			select()
			DML	-----executeDML()
			  |			
	--------|------------------------------------					
		/					|					\						
	insert()			update()		delete()
	
	ColumnInfo.java:表中一个字段（键）的信息，例如username：键名，是否为主键，数据类型
	
	TableInfo.java：存储表结构信息，例如emp：表名，表的所有字段（columns：map<ColumnInfo>）,主键信息（columnInfo）	
/----------------有了以上类，就基本可以将数据库的表和Java类一一对应了------------------------------------------

TableContext.java：负责获取管理数据库所有表结构和类结构的关系，并可以根据表结构生成类结构
JavaFileUtils.java：封装了生成Java文件(源代码)常用的操作



 版本2：
 采用模板方法模式将JDBC操作封装成模板，便于重用
 原来的查询操作是：A------B------或者A---------C，不同的地方在于A之后的操作
 模板方法模式：将A封装为一个方法，将B、C这类抽象为一个接口的方法，具体自己实现；A再调用实现类
 
 类似的举例子：洗澡：肯定是要准备好换洗的衣服再加上用沐浴露洗澡的动作，至于用什么沐浴露，就封装在篮子里，
 
 
 
 
 
 

