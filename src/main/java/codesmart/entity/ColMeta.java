package codesmart.entity;

/**
 * Auth fkxuexi
 * Date 2017/9/25
 * QQ群：fkxuexi.top   570980002
 * 数据库列元信息java的描述
 */
public class ColMeta {

    private String javaAttrName;//java风格的名称
    private String dbAttrName;//数据库风格的名称
    private String javaAttrType;//java的数据类型
    private String dbAttrType;//数据库的数据类型
    private String defaultValue ;//默认值

    private String remark;//表的注释

    public ColMeta() {
    }

    public ColMeta(String javaAttrName, String dbAttrName, String javaAttrType, String dbAttrType, String remark, String defaultValue) {
        this.javaAttrName = javaAttrName;
        this.dbAttrName = dbAttrName;
        this.javaAttrType = javaAttrType;
        this.dbAttrType = dbAttrType;
        this.remark = remark;
        this.defaultValue = defaultValue;
    }

    public String getJavaAttrName() {
        return javaAttrName;
    }

    public void setJavaAttrName(String javaAttrName) {
        this.javaAttrName = javaAttrName;
    }

    public String getDbAttrName() {
        return dbAttrName;
    }

    public void setDbAttrName(String dbAttrName) {
        this.dbAttrName = dbAttrName;
    }

    public String getJavaAttrType() {
        return javaAttrType;
    }

    public void setJavaAttrType(String javaAttrType) {
        this.javaAttrType = javaAttrType;
    }

    public String getDbAttrType() {
        return dbAttrType;
    }

    public void setDbAttrType(String dbAttrType) {
        this.dbAttrType = dbAttrType;
    }

    public String getDefaultValue() {
        return defaultValue;
    }

    public void setDefaultValue(String defaultValue) {
        this.defaultValue = defaultValue;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

	@Override
	public String toString() {
		return "ColMeta [javaAttrName=" + javaAttrName + ", dbAttrName=" + dbAttrName + ", javaAttrType=" + javaAttrType
				+ ", dbAttrType=" + dbAttrType + ", defaultValue=" + defaultValue + ", remark=" + remark + "]";
	}

   
}
