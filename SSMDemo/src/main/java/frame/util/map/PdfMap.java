package frame.util.map;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class PdfMap extends AbstractConfigMap {
	private String path = "PDF.properties";
	private Logger logger = LoggerFactory.getLogger(PdfMap.class);

	public PdfMap() {
		List<String> list = new ArrayList<String>();
		list.add("14062.pdf");
		list.add("14056.pdf");
		list.add("14047.pdf");
		list.add("14003");
		initail(list);
	}

	public String getPath() {
		return path;
	}
}
