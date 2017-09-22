package frame.util.map;

import org.apache.commons.configuration.AbstractHierarchicalFileConfiguration;
import org.apache.commons.configuration.XMLConfiguration;
import org.apache.commons.configuration.reloading.FileChangedReloadingStrategy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import frame.exception.ConfigException;

public class XmlParseConfiger extends BaseConfig {
	private static Logger logger = LoggerFactory.getLogger(PropConfiger.class);

	public XmlParseConfiger(String path) {
		try {
			cfg = new XMLConfiguration(path);
		} catch (Exception e) {
			logger.error("ConfigExceptionDetail{}", e);
			throw new ConfigException(e);
		}

		((AbstractHierarchicalFileConfiguration) cfg).setReloadingStrategy(new FileChangedReloadingStrategy());
	}

}
