package codesmart.db;

import codesmart.entity.TableMeta;

import java.sql.SQLException;
import java.util.List;

/**
 * @author fkxuexi
 *
 * 获取数据库信息的接口  以后无论是做idea的插件，还是做web版的界面或者是做gui类型的界面可以直接调用这个接口
 */

public interface DBParse {

	/***
	 * @param dbName 数据库名
	 * @return 返回指定数据库的所有的表描述
	 * @throws SQLException 
	 */
	abstract List<TableMeta> getAllTaleMeta(String dbName) throws SQLException;
	
	/**
	 * @param dbName 指定数据库名
	 * @param tableNames 指定表名
	 * @return 返回指定数据库指定表的描述
	 * @throws SQLException 
	 */
	abstract List<TableMeta> getTableMeta(String dbName, String[] tableNames) throws SQLException;
	
}
