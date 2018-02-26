package codesmart;

import codesmart.entity.ConfigAbstract;
import codesmart.entity.Convention;
import codesmart.gener.GenerTools;

public class MainController{

	private static String dbName = "shoukang";
	private static String url = "jdbc:mysql://119.23.36.35:3306/"+dbName+"?useUnicode=true&characterEncoding=utf-8";
	private static String user = "ybmysqluser01";
	private static String pwd = "ybMS#u,001";
	/*
	private static String url = "jdbc:mysql://192.168.1.28:3306/"+dbName+"?useUnicode=true&characterEncoding=utf-8";
	private static String user = "root";
	private static String pwd = "123456";*/
	private static String basePackage = "activity.top.fkxuexi.activity";
	
	
	public static void main(String[] args) {
		
		// 配置生成 service 、dao 、mapper、entity、controller 的一个或者多个
		Convention[] generPackages = {
//				Convention.DAO,
//				Convention.XML_MAPPER,
//				Convention.SERVICE,
				Convention.ENTITY,
//				Convention.CONTROLLER,
//				Convention.VUE,
			};
		
		/**
		 *  配置要生成的表 如果为空则默认的生成全部，否则则按照指定的表来生成，如果已经有了原来的代码文件，
		 *  	将会把以前的文件 + .HH-mm-ss 时间戳的形式保留
		 */
		String[] generTables = new String[]{""};
		
		ConfigAbstract config = new ConfigAbstract(dbName, url, user, pwd, basePackage,
				generPackages, null);
		try {
			GenerTools.gener(config);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	
}
