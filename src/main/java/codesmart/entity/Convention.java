package codesmart.entity;

/**
 * 一些约定的配置
 * @author fkxuexi
 */
public enum Convention {

	DAO("dao","DAO",".java","JavaMapperTemplate.ftl",true),
	
	XML_MAPPER("mappers","DAO",".xml","XmlMapperTemplate.ftl",true),
	
	/*SERVICE_INTERFACE("service","ServiceInterface.java","ServiceInterfaceTemplate.ftl",true),
	SERVICE_IMPL("service.impl","ServiceImpl.java","ServiceImplTemplate.ftl",true),*/
	
	SERVICE("service","Service",".java","ServiceTemplate.ftl",true),
	
	ENTITY("entity","",".java","EntityTemplate.ftl",true),
	
	CONTROLLER("controller","Controller",".java","ControllerTemplate.ftl",true),
	VUE("vue","",".vue","VueView.ftl",true);
	
	private String packageName;
	private String suffix;
	private String fileType;
	private String templateName;
	private boolean isGener;
	
	private Convention(String packageName, String suffix, String fileType ,String templateName, boolean isGener) {
		this.packageName = packageName;
		this.suffix = suffix;
		this.fileType = fileType;
		this.templateName = templateName;
		this.isGener = isGener;
	}

	public String getPackageName() {
		return packageName;
	}

	public String getSuffix() {
		return suffix;
	}

	public String getTemplateName() {
		return templateName;
	}

	public boolean isGener() {
		return isGener;
	}

	public String getFileType() {
		return fileType;
	}

	public void setFileType(String fileType) {
		this.fileType = fileType;
	}

	
}
