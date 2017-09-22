package frame.util.map;

import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class ConfigRegister {
	public static Map<String, Object> configMap = new ConcurrentHashMap<String, Object>();
	public static XmlParseConfiger config = new XmlParseConfiger("config/ConfigMap.xml");
	static {
		List<Object> propList = config.getListValue("props.prop");
		List<String> strs = (List<String>) (List) propList;
		for (String str : strs) {
			configMap.put(str.substring(str.lastIndexOf("/") + 1), new PropConfiger(str));

		}
		List<Object> xmlList = config.getListValue("xmlConfig.xml");
		List<String> xmls = (List<String>) (List) xmlList;

		for (String str : xmls) {
			configMap.put(str.substring(str.lastIndexOf("/") + 1), new XmlParseConfiger(str));

		}
	}

	public static Object getValue(String key) {
		return configMap.get(key);
	}

	public static Map<String, Object> getMap() {
		return configMap;
	};
}
