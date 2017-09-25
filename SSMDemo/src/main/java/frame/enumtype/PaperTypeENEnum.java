package frame.enumtype;

public enum PaperTypeENEnum {
	IDCARD(1, "ID Card"), MILTICARD(2, "Military ID"), PASSPORT(3, "Passport");

	private int key;
	private String value;

	private String getValue() {
		return value;
	}

	private int getKey() {
		return key;
	}

	private PaperTypeENEnum(int key, String value) {
		// TODO Auto-generated constructor stub
		this.key = key;
		this.value = value;
	}

	public static String getValueByKey(int key) {
		PaperTypeENEnum[] enums = PaperTypeENEnum.values();
		for (PaperTypeENEnum myenum : enums) {
			if (myenum.getKey() == key) {
				return myenum.getValue();
			}
		}
		return "Others";
	}
}
