package com.bjsxt.sorm.bean;
/**
 * 管理配置信息
 * @author tzh
 *
 */
public class Configuration {

		/**
		 * 驱动类
		 */
		private String driver;//
		/**
		 * jdbc的URL
		 */
		private String url;//	
		/**
		 * 数据库的用户名
		 */
		private String user;//
		/**
		 * 数据库的密码
		 */
		private String pwd;//
		/**
		 * 正在使用哪个数据库
		 */
		private String usingDB;//
		/**
		 * 本项目的源码路径
		 */
		private String srcPath;//
		/**
		 * 扫描生成Java类的包。存持久化的对象（也就是和表对应的对象）po:Persistence
		 */
		private String poPackage;//
		/**
		 * 项目使用的查询类的是哪一个类（路径）
		 */
		private String queryClass;
		/**
		 * 连接池中最小的数
		 */
		private int poolMinSize;
		/**
		 * 连接池中最大的数
		 */
		private int poolMaxSize;
		public Configuration() {
			super();
		}
		public Configuration(String driver, String url, String user, String pwd, String usingDB, String srcPath,
				String poPackage,String queryClass,int poolMinSize,int poolMaxSize) {
			super();
			this.driver = driver;
			this.url = url;
			this.user = user;
			this.pwd = pwd;
			this.usingDB = usingDB;
			this.srcPath = srcPath;
			this.poPackage = poPackage;
			this.queryClass = queryClass;
			this.poolMinSize = poolMinSize;
			this.poolMaxSize =poolMaxSize;
		}
		public String getDriver() {
			return driver;
		}
		public void setDriver(String driver) {
			this.driver = driver;
		}
		public String getUrl() {
			return url;
		}
		public void setUrl(String url) {
			this.url = url;
		}
		public String getUser() {
			return user;
		}
		public void setUser(String user) {
			this.user = user;
		}
		public String getPwd() {
			return pwd;
		}
		public void setPwd(String pwd) {
			this.pwd = pwd;
		}
		public String getUsingDB() {
			return usingDB;
		}
		public void setUsingDB(String usingDB) {
			this.usingDB = usingDB;
		}
		public String getSrcPath() {
			return srcPath;
		}
		public void setSrcPath(String srcPath) {
			this.srcPath = srcPath;
		}
		public String getPoPackage() {
			return poPackage;
		}
		public void setPoPackage(String poPackage) {
			this.poPackage = poPackage;
		}
		public String getQueryClass() {
			return queryClass;
		}
		public void setQueryClass(String queryClass) {
			this.queryClass = queryClass;
		}
		public int getPoolMinSize() {
			return poolMinSize;
		}
		public void setPoolMinSize(int poolMinSize) {
			this.poolMinSize = poolMinSize;
		}
		public int getPoolMaxSize() {
			return poolMaxSize;
		}
		public void setPoolMaxSize(int poolMaxSize) {
			this.poolMaxSize = poolMaxSize;
		}

		
}
