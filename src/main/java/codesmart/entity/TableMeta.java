package codesmart.entity;

import java.util.List;

/**
 * Auth fkxuexi
 * Date 2017/9/25
 * QQ群：fkxuexi.top   570980002
 * 表元 信息 java的描述
 */
public class TableMeta {

    private String javaDbName;
    private String dbName;

    private List<ColMeta> pkList; // 主键描述列

    private List<ColMeta> colList;// 除开主键列的所有的列的描述
    
    private List<ColMeta> allColList;// 所有列的描述
    
    private String remark;//注释

    private List<String> importStr;//数据类型不为基本类型时 ，需要导入的类

	public String getJavaDbName() {
		return javaDbName;
	}

	public void setJavaDbName(String javaDbName) {
		this.javaDbName = javaDbName;
	}

	public String getDbName() {
		return dbName;
	}

	public void setDbName(String dbName) {
		this.dbName = dbName;
	}

	public List<ColMeta> getPkList() {
		return pkList;
	}

	public void setPkList(List<ColMeta> pkList) {
		this.pkList = pkList;
	}

	public List<ColMeta> getColMetaList() {
		return colList;
	}

	public void setColMetaList(List<ColMeta> colMetaList) {
		this.colList = colMetaList;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public List<String> getImportStr() {
		return importStr;
	}

	public void setImportStr(List<String> importStr) {
		this.importStr = importStr;
	}

	
	
	public List<ColMeta> getColList() {
		return colList;
	}

	public void setColList(List<ColMeta> colList) {
		this.colList = colList;
	}

	public List<ColMeta> getAllColList() {
		return allColList;
	}

	public void setAllColList(List<ColMeta> allColList) {
		this.allColList = allColList;
	}

	@Override
	public String toString() {
		return "TableMeta ["
				+ "javaDbName=" + javaDbName 
				+ ", dbName=" + dbName 
				+ ", pkList=" + pkList 
				+ ", colList="+ colList 
				+ ", allColList=" + allColList 
				+ ", remark=" + remark 
				+ ", importStr=" + importStr
				+ "]";
	}

}
