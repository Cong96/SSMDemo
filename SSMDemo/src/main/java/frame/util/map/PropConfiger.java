package frame.util.map;

import org.apache.commons.configuration.AbstractFileConfiguration;
import org.apache.commons.configuration.PropertiesConfiguration;
import org.apache.commons.configuration.reloading.FileChangedReloadingStrategy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import frame.exception.ConfigException;

public class PropConfiger extends BaseConfig {
	private static Logger logger = LoggerFactory.getLogger(PropConfiger.class);

	public PropConfiger(String path) {
		try {
			cfg = new PropertiesConfiguration(path);
		} catch (Exception e) {
			logger.error("ConfigExceptionDetail{}", e);
			throw new ConfigException(e);
		}

		((AbstractFileConfiguration) cfg).setReloadingStrategy(new FileChangedReloadingStrategy());
	}

}
