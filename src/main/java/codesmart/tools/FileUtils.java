package codesmart.tools;

import codesmart.entity.Config;
import codesmart.entity.Convention;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class FileUtils {

	private static SimpleDateFormat sdf = new SimpleDateFormat("HH-ss-mm");
	
	/**
	 * 这个里面获取的是jar包里面的路径，
	 */
	public static String getJarPath(){

		String rootPath = FileUtils.class.getClassLoader().getResource("").
				getPath().split("target")[0];
		return rootPath;
	}
	/**
	 * @return 获取的是jar包里面的src的路径
	 */
	public static String getJarSrcPath(){
		return 	getJarPath() + "src/main/java/";
	}
	
	/**
	 * @return 获取jar包所在项目的根路径
	 */
	public static String getRootPath(){
		String rootPath = System.getProperty("user.dir");
		return rootPath;
	}
	
	/**
	 * @return 获取jar包所在的项目的src的路径
	 */
	public static String getRootSrcPath(){
		
		return isMaven()?
				getRootPath()+"\\src\\main\\java\\":
					getRootPath()+"\\src\\";
	}
	
	public static String getRootResourcePath(){
		return getRootPath() + "\\src\\main\\resources\\";
	}
	
	/**
	 * @return 判断是否为maven项目 只能简单一句maven的结构目录来判断
	 */
	public static boolean isMaven(){
		File file = new File(getRootPath()+"\\src\\main\\java");
		if(file.exists()){
			return true;
		}else{
			return false;
		}
	}
	private static void isExistPackage(String packagePath) {
		
		packagePath = packagePath.replace(".", "\\");
		File file = new File(packagePath);
		if(!file.exists()){
			// 如果父级目录不存在的话，也会创建父级目录
			boolean mkdirs = file.mkdirs();
			System.err.println(mkdirs);
		}
	}
	
	
	public static FileWriter getFileWriter(Convention convention, Config config, String fileName) throws IOException {
		
		FileWriter fileWriter = null;
		File codeFile = null ;
		
		String packagePath = (getRootSrcPath()+config.getBasePackage() + "." 
				+convention.getPackageName()+"\\").replace(".", "\\");
		
		String xmlSourcePath = ( getRootResourcePath() + 
				convention.getPackageName()+"\\").replace(".", "\\");
		
		String codeFilePath = (packagePath + fileName ).replace(".", "\\") + convention.getSuffix() + convention.getFileType();
		String xmlFilePath = (xmlSourcePath + fileName ).replace(".", "\\") + convention.getSuffix() + convention.getFileType();
		
		if(convention.equals(Convention.XML_MAPPER)){
			isExistPackage(xmlSourcePath);
			codeFile = new File(xmlFilePath);
			if(codeFile.exists()){
				codeFile.renameTo(new File(xmlFilePath+sdf.format(new Date())));
			}
		}else{
			isExistPackage(packagePath);
			codeFile = new File(codeFilePath);
			if(codeFile.exists()){
				codeFile.renameTo(new File(codeFilePath+"."+sdf.format(new Date())));
			}
		}
		
		fileWriter = new FileWriter(codeFile);
		return fileWriter;
	}
	
}
