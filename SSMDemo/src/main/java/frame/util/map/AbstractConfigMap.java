package frame.util.map;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public abstract class AbstractConfigMap {
	private PropConfiger config;
	private static Logger logger = LoggerFactory.getLogger(AbstractConfigMap.class);
	protected Map<String, List<String>> map = new HashMap<String, List<String>>();

	public abstract String getPath();

	public PropConfiger getPropConfiger() {
		return (PropConfiger) ConfigRegister.getValue(getPath());
	}

	protected void initail(List<String> list) {
		config = getPropConfiger();
		init(list);

	}

	protected void init(List<String> list) {
		for (String key : list) {
			initailMap(key);
		}
	}

	protected void initailMap(String key) {
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

	public Map<String, List<String>> getMap() {
		return map;
	};
}
