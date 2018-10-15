package com.bjsxt.sorm.bean;
/**
 * 管理配置信息
 * @author tzh
 *
 */
public class Configuration {

		private String driver;//驱动类
		private 	String url;//	jdbc的URL
		private String user;//数据库的用户名
		private String pwd;//数据库的密码
		private String usingDB;//正在使用哪个数据库
		private String srcPath;//本项目的源码路径
		private String poPackage;//扫描生成Java类的包。存持久化的对象（也就是和表对应的对象）po:Persistence
		public Configuration() {
			super();
		}
		public Configuration(String driver, String url, String user, String pwd, String usingDB, String srcPath,
				String poPackage) {
			super();
			this.driver = driver;
			this.url = url;
			this.user = user;
			this.pwd = pwd;
			this.usingDB = usingDB;
			this.srcPath = srcPath;
			this.poPackage = poPackage;
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

		
}
