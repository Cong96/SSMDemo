package frame.enumtype;

public enum RelationShipEnum {

	UNCERTAINTY("无关或不确定", "N/A"), COUPLE("配偶", "Couple"), CHILDERN("子女", "Children"), PARENT("父母",
			"Parents"), RELATIVES("亲属", "Relatives"), SELF("本人", "Self"), OTHERS("其他", "Others"), EMPLOYMENT("雇佣",
					"Employment"), ATLAW("法定继承人", "At Law"), DEATHBENE("身故受益人", "Death beneficiary");

	private String name;
	private String ename;

	private String getName() {
		return name;
	}

	private String getEname() {
		return ename;
	}

	private RelationShipEnum(String name, String ename) {
		this.name = name;
		this.ename = ename;
	}

	public static String getNameByOrdinal(int key) {
		RelationShipEnum[] enums = RelationShipEnum.values();
		for (RelationShipEnum myenum : enums) {
			if (myenum.ordinal() == key) {
				return myenum.getName();
			}
		}
		return "";
	}

	public static String getEnameByOrdinal(int key) {
		RelationShipEnum[] enums = RelationShipEnum.values();
		for (RelationShipEnum myenum : enums) {
			if (myenum.ordinal() == key) {
				return myenum.getEname();
			}
		}
		return "";
	}
}
