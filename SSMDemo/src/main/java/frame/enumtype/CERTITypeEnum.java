package frame.enumtype;

public enum CERTITypeEnum {
	IDCARD(1, "身份证"), MILTICARD(2, "军人证"), PASSPORT(3, "护照"), BIRTHCARD(4, "出生证"), UNUSUALIDCARD(5,
			"异常身份证"), RETURNCARD(6, "回乡证"), OTHER(9, "其他"), TEMPIDCARD(10, "临时身份证"), RESIDENCEBOOKLET(11,
					"户口薄"), POLICYCARD(12, "武警证"), HKPASS(13,
							"港澳通行证"), TAIWANPASS(14, "台湾通行证"), BUSINESSLICENSE(15, "法人营业执照"), ACCOUNTNAME(16, "户名");
	private int key;
	private String value;

	// 应该用private修饰
	private String getValue() {
		return value;
	}

	private int getKey() {
		return key;
	}

	CERTITypeEnum(int key, String value) {
		this.value = value;
		this.key = key;
	}

	public static String getValueByKey(int key) {
		CERTITypeEnum[] enums = CERTITypeEnum.values();
		for (CERTITypeEnum myenum : enums) {
			if (myenum.getKey() == key) {
				return myenum.getValue();
			}
		}

		return "";
	}
}
