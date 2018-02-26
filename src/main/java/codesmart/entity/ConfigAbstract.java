package codesmart.entity;

import codesmart.tools.FileUtils;

/**
 * 写这个的目的是为了让用户可以定制化一些东西
 * @author fkxuexi
 */
public class ConfigAbstract {
	
	private String path = FileUtils.getJarSrcPath();
	private String templateLocation = path+"codesmart/template/";
	
	private String dbName;
	private String url;
	private String user;
	private String pwd;
	private String basePackage;
	private Convention[] generPackages;
	private String[] generTables;
	
	
	
	
	
	
	public ConfigAbstract(String dbName, String url, String user, String pwd, String basePackage,
			Convention[] generPackages, String[] generTables) {
		this.dbName = dbName;
		this.url = url;
		this.user = user;
		this.pwd = pwd;
		this.basePackage = basePackage;
		this.generPackages = generPackages;
		this.generTables = generTables;
	}
	public String getDBName(){
		return this.dbName;
	}
	public String getUrl(){
		return this.url;
	}
	public String getUser(){
		return this.user;
	}
	public String getPwd(){
		return this.pwd;
	}
	
	
	public  String getBasePackage(){
		return this.basePackage;
	}
	public  String[] generTables(){
		return this.generTables;
	}
	
	public  Convention[] generPackages(){
		return this.generPackages;
	}
	
	/*目前这个只支持mysql*/
	public final String getDriverName(){
		return "com.mysql.jdbc.Driver";
	}
	
	/**
	 * @return 需要注意的是这个地方是要返回模板存放的目录
	 */
	public String getTemplatePath(){
		return templateLocation;
	}
	
}
