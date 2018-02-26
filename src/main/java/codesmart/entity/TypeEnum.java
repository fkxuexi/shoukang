package codesmart.entity;


/**
 * Auth fkxuexi
 * Date 2017/9/25
 * QQ群：fkxuexi.top   570980002
 * 
 * 所有的类型全部采用 包装类
 */
public enum TypeEnum {

    INT("int", "Integer",null),
    BIGINT("bigint", "Long",null),
    TINYINT("tinyint", "Short",null),
    SMALLINT("smallint", "Short",null),
    INTEGER("integer", "Integer",null),
    FLOAT("float", "Float",null),
    DOUBLE("double", "Double",null),
    DECIMAL("decimal", "BigDecimal","java.math.BigDecimal"),
    NUMERIC("numeric", "BigDecimal","java.math.BigDecimal"),
    CAHR("char", "String",null),
    VARCHAR("varchar", "String",null),
    TINYBLOB("tinyblob", "byte[]",null),
    MEDIUMBLOB("mediumblob", "byte[]",null),
    BLOG("blob", "byte[]",null),
    TEXT("text", "String",null),
    MEDIUMTEXT("mediumtext", "String",null),
    LONGTEXT("longtext", "String",null),
    TIME("time", "Date","java.util.Date"),
    DATE("date", "Date","java.util.Date"),
    YEAR("year", "Date","java.util.Date"),
    DATETIME("datetime", "Date","java.util.Date"),
    TIMESTAMP("timestamp", "Date","java.util.Date");

    private String dbType;
    private String javaType;
    private String importStr;

    TypeEnum(String dbType, String javaType, String importStr) {
        this.dbType = dbType;
        this.javaType = javaType;
        this.importStr = importStr;
    }

    public String getJavaType() {
        return javaType;
    }

    public String getImportStr(){
        return importStr;
    }

    
    
    
    public static TypeEnum valueof(String dbType) {
    	if(dbType == null){
    		throw new NullPointerException("dbType 不可以为空");
    	}
    	dbType = dbType.toLowerCase();
        for (TypeEnum typeEnum : values()) {
            if (typeEnum.dbType.equals(dbType)) {
                return typeEnum;
            }
        }
        throw new RuntimeException("你所给定的数据类型：" + dbType + " 暂不支持，如有需要请联系群管理员更新代码");
    }
}
