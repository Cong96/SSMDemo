package frame.util.map;

import java.util.List;

import org.apache.commons.configuration.AbstractConfiguration;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class BaseConfig {
	private static Logger logger = LoggerFactory.getLogger(BaseConfig.class);
	public AbstractConfiguration cfg = null;

	// 读String
	public String getStringValue(String key) {
		return cfg.getString(key);
	}

	// 读int
	public int getIntValue(String key) {
		return cfg.getInt(key);
	}

	// 读boolean
	public boolean getBooleanValue(String key) {
		return cfg.getBoolean(key);
	}

	// 读List
	public List<Object> getListValue(String key) {
		return cfg.getList(key);
	}

	// 读数�?
	public String[] getArrayValue(String key) {
		return cfg.getStringArray(key);
	}
}
