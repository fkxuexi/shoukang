package codesmart.db.impl;

import codesmart.db.DBParse;
import codesmart.entity.TableMeta;
import codesmart.tools.ParseSql;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class DBParseImpl implements DBParse {
	
	private Connection conn;
	
	public DBParseImpl(Connection connection) {
		this.conn = connection;
	}

	public List<TableMeta> getAllTaleMeta(String dbName) throws SQLException {
		
		if (conn == null) {
			throw new NullPointerException("数据库连接connection 不可以为空");
		}
		
		String sql = ParseSql.GET_ALL_TABLE_META;
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, dbName);
		ResultSet rst = pstmt.executeQuery();
		
		List<TableMeta> tableMetaList = DbParseTools.assembleTableMeta(dbName,rst,conn);
		
		return tableMetaList;
	}

	public List<TableMeta> getTableMeta(String dbName, String[] tableNames) throws SQLException {
		
		if(conn == null){
			throw new NullPointerException("数据库连接connection 不可以为空");
		}
		String sql = ParseSql.GET_PRESET_TABLE_META + "(";
		if(tableNames != null && tableNames.length > 0){
			for(int i = 0 ; i < tableNames.length ; i++){
				if(i + 1 == tableNames.length){
					sql += "?)";
				}else{
					sql += "?,";
				}
			}
		}else{
			return this.getAllTaleMeta(dbName);
		}
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, dbName);
		for(int k = 0 ; k < tableNames.length ; k++){
			pstmt.setString(k+2, tableNames[k]);
		}
		
		ResultSet rst = pstmt.executeQuery();
		List<TableMeta> tableMetaList = DbParseTools.assembleTableMeta(dbName,rst,conn);
		return tableMetaList;
	}

}
