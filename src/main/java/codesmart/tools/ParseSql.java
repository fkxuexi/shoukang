package codesmart.tools;

/**
 * Auth fkxuexi
 * Date 2017/9/25
 * QQ群：fkxuexi.top   570980002
 *
 * 不在使用java的DataBaseMeata来解析了，这个虽然可以通用，但是他的主键的解析和列的解析太分散，比较麻烦
 *
 * 注意这里面我们偷了个懒，也可以是说接住了mysql的特性，在Information_schema.columns里面获取列的属性
 * 但是需要注意的坑是，就如别的库有同样的表名，那么就会出现错误，所以我们要指定table_scheme即表所属的数据库
 *
 */
public class ParseSql {

    //获取指定数据库的所有的表的表名以及注释信息的sql
    public static String GET_ALL_TABLE_META =
            "SELECT TABLE_NAME,TABLE_COMMENT FROM information_schema.TABLES WHERE table_schema=?";

    //获取指定数据的的表名 以及  注释信息sql
    public static String GET_PRESET_TABLE_META =
            "SELECT TABLE_NAME ,TABLE_COMMENT FROM INFORMATION_SCHEMA.TABLES " +
                    " WHERE table_schema = ? AND table_name in";

    //获取指定表的表名 、数据类型、注释、是否为主键、默认值 的sql语句
    public static String PARSE_TABLE_META =
            "SELECT  COLUMN_NAME,COLUMN_KEY,DATA_TYPE,COLUMN_DEFAULT, COLUMN_COMMENT " +
                    "from Information_schema.columns " +
                    "where information_schema.columns.TABLE_SCHEMA=? and table_Name = ?";
}
