package frame.util.map;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ConfigMap {
	private static PropConfiger config;

	private static Logger logger = LoggerFactory.getLogger(ConfigMap.class);
	protected static Map<String, List<String>> map = new ConcurrentHashMap<String, List<String>>();

	protected static void initail(List<String> list, String path) {
		config = (PropConfiger) ConfigRegister.getValue(path);
		init(list);

	}

	protected static void init(List<String> list) {
		for (String key : list) {
			initailMap(key);
		}
	}

	protected static void initailMap(String key) {
		try {

			String[] values = config.getArrayValue(key);
			List<String> list = new ArrayList<String>();
			for (int i = 0; i < values.length; i++) {
				list.add(values[i]);
			}
			map.put(key, list);
		} catch (Exception e) {

			logger.error("中的static块执行出错：" + e.getMessage());
		}
	}

}
