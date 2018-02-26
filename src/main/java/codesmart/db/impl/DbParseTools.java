package codesmart.db.impl;

import codesmart.entity.ColMeta;
import codesmart.entity.TableMeta;
import codesmart.entity.TypeEnum;
import codesmart.tools.ParseSql;
import codesmart.tools.TypeCovert;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DbParseTools {

	
	public static List<TableMeta> assembleTableMeta(String dbName, ResultSet rst, Connection connection) throws SQLException {
		
		if (rst == null || connection == null) {
			throw new NullPointerException("结果集rst 或者 数据库链接 connection 不可以为空");
		}
		List<TableMeta> tableMetas = new ArrayList<TableMeta>();
		TableMeta tableMeta = null;
		while(rst.next()){
			tableMeta = new TableMeta();
			tableMeta.setDbName(rst.getString("TABLE_NAME"));
			tableMeta.setJavaDbName(TypeCovert.underline2hump(rst.getString("TABLE_NAME"), true));
			tableMeta.setRemark(rst.getString("TABLE_COMMENT"));
			tableMetas.add(tableMeta);
		}
		
		tableMetas = parseColMeta(dbName,tableMetas,connection);
		return tableMetas;
	}

	private static List<TableMeta> parseColMeta(String dbName,List<TableMeta> tableMetas, Connection connection) throws SQLException {
		
		if(tableMetas == null){
			throw new NullPointerException(" 要解析的 tableMetas 为空");
		}
		
		PreparedStatement pstmt = null ;
		ResultSet rst = null ;
		List<ColMeta> pkList = null;
		List<ColMeta> colList = null;
		List<ColMeta> allColList = null;
		List<String> importList = null;
		ColMeta colMeta = null;
		for(TableMeta tableMeta : tableMetas){
			String sql = ParseSql.PARSE_TABLE_META;
			pstmt = connection.prepareStatement(sql);
			pstmt.setString(1, dbName);
			pstmt.setString(2, tableMeta.getDbName());
			rst = pstmt.executeQuery();
			
			importList = new ArrayList<String>();
			colList = new ArrayList<ColMeta>();
			pkList = new ArrayList<ColMeta>();
			allColList = new ArrayList<ColMeta>();
			while(rst.next()){
				String colName = rst.getString("COLUMN_NAME");
				String colType = rst.getString("DATA_TYPE");
				String colKey = rst.getString("COLUMN_KEY");
				String colDefault = rst.getString("COLUMN_DEFAULT");
				String colRemark = rst.getString("COLUMN_COMMENT");
				String colJavaType = TypeEnum.valueof(colType).getJavaType();
				String importStr = TypeEnum.valueof(colType).getImportStr();
				
				colMeta = new ColMeta();
				colMeta.setDbAttrName(colName);
				colMeta.setJavaAttrName(TypeCovert.underline2hump(colName));
				colMeta.setDbAttrType(colType);
				colMeta.setJavaAttrType(colJavaType);
				// 注意 list是可以存入null值的
				if(importStr != null && !importList.contains(importStr)){
					importList.add(importStr);
				}
				
				colMeta.setDefaultValue(colDefault);
				colMeta.setRemark(colRemark);
				if("PRI".equals(colKey)){
					pkList.add(colMeta);
				}else{
					colList.add(colMeta);
				}
			}
			
			tableMeta.setPkList(pkList);
			tableMeta.setColMetaList(colList);
			allColList.addAll(pkList);
			allColList.addAll(colList);
			tableMeta.setAllColList(allColList);
			tableMeta.setImportStr(importList);
		}
		
		return tableMetas;
	}
}
