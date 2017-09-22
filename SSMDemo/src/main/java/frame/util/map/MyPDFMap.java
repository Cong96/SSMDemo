package frame.util.map;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class MyPDFMap extends ConfigMap {
	static {
		List<String> list = new ArrayList<String>();
		list.add("14062.pdf");
		list.add("14056.pdf");
		list.add("14047.pdf");
		list.add("14003");
		initail(list, "PDF.properties");
	}

	public static Map<String, List<String>> getMap() {
		return map;
	}
}
