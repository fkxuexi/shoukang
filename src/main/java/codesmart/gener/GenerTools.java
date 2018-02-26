package codesmart.gener;

import codesmart.db.DBParse;
import codesmart.db.impl.DBParseImpl;
import codesmart.entity.Config;
import codesmart.entity.ConfigAbstract;
import codesmart.entity.Convention;
import codesmart.entity.TableMeta;
import codesmart.tools.ConnTools;
import codesmart.tools.FileUtils;
import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GenerTools {

	private static Configuration cfg;
	private static Connection conn;

	public static void gener(ConfigAbstract configAbstract)
			throws SQLException, ClassNotFoundException, TemplateException, IOException {

		Config config = init(configAbstract);

		DBParse dbParse = new DBParseImpl(conn);
		List<TableMeta> tableMetaList = dbParse.getTableMeta(config.getDbName(), config.getTables());
		Template template = null;
		if (tableMetaList != null) {
			for (TableMeta tableMeta : tableMetaList) {
				for(Convention convention:config.getGenerPackage()){
					FileWriter fileWriter =
							FileUtils.getFileWriter(convention, config, tableMeta.getJavaDbName());
					template = geTemplate(convention, config);
					Map<String, Object> map = new HashMap<String, Object>();
					map.put("data", tableMeta);
					map.put("config", config);
					map.put("convention", convention);
					map.put("entityConvention", Convention.ENTITY);
					map.put("serviceConvention", Convention.SERVICE);
					map.put("daoConvention", Convention.DAO);
					template.process(map, fileWriter);
					fileWriter.flush();
				}
			}
		}
	}

	private static Config init(ConfigAbstract configAbstract)
			throws ClassNotFoundException, SQLException, IOException {
		Config config = new Config(configAbstract);

		cfg = new Configuration();
		cfg.setDirectoryForTemplateLoading(new File(config.getTemplateLocation()));
		conn = ConnTools.getConnection(config.getDriverName(), config.getUser(), config.getUrl(), config.getPwd());
		return config;
	}

	private static Template geTemplate(Convention convention, Config config) throws FileNotFoundException {
		String templatePath = null;
		try {
			templatePath = convention.getTemplateName();
			return cfg.getTemplate(templatePath, "UTF-8");
		} catch (IOException e) {
			e.printStackTrace();
			throw new FileNotFoundException("模板文件：" + templatePath + "  无法找到");
		}
	}

}
