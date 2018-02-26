package codesmart.entity;

import java.util.Arrays;

public class Config {

	private String dbName;
	
	private String url;
	private String user;
	private String pwd;
	private String driverName;
	
	private String basePackage;
	private String[] tables;
	private Convention[] generPackage;
	
	private ConfigAbstract configAbstract;
	
	private String templateLocation;
	
	public Config(ConfigAbstract configAbstract){
		this.configAbstract = configAbstract;
		
		this.dbName = configAbstract.getDBName();
		this.url = configAbstract.getUrl();
		this.pwd = configAbstract.getPwd();
		this.driverName = configAbstract.getDriverName();
		this.user = configAbstract.getUser();
		this.basePackage = configAbstract.getBasePackage();
		this.templateLocation = configAbstract.getTemplatePath();
		this.generPackage = configAbstract.generPackages();
		this.tables = configAbstract.generTables();
	}

	
	public String getDbName() {
		return dbName;
	}

	public void setDbName(String dbName) {
		this.dbName = configAbstract.getDBName();
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = configAbstract.getUrl();
	}

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = configAbstract.getUser();
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = configAbstract.getPwd();
	}

	public String getDriverName() {
		return driverName;
	}

	public void setDriverName(String driverName) {
		this.driverName = configAbstract.getDriverName();
	}

	public String getBasePackage() {
		return basePackage;
	}

	public void setBasePackage(String basePackage) {
		this.basePackage = configAbstract.getBasePackage();
	}

	public String[] getTables() {
		return tables;
	}

	public void setTables(String[] tables) {
		this.tables = configAbstract.generTables();
	}


	public String getTemplateLocation() {
		return templateLocation;
	}


	public void setTemplateLocation(String templateLocation) {
		this.templateLocation = templateLocation;
	}

	

	public Convention[] getGenerPackage() {
		return generPackage;
	}


	public void setGenerPackage(Convention[] generPackage) {
		this.generPackage = generPackage;
	}


	@Override
	public String toString() {
		return "Config [dbName=" + dbName + ", url=" + url + ", user=" + user + ", pwd=" + pwd + ", driverName="
				+ driverName + ", basePackage=" + basePackage + ", tables=" + Arrays.toString(tables)
				+ ", generPackage=" + Arrays.toString(generPackage) + ", configAbstract=" + configAbstract
				+ ", templateLocation=" + templateLocation + "]";
	}

	
}
