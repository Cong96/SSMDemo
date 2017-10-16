package com.wangcc.test.enumTest;

import org.junit.Test;

import frame.enumtype.CERTITypeEnum;
import frame.enumtype.PaperTypeENEnum;
import frame.enumtype.RelationShipEnum;

public class EnumTest {
	@Test
	public void testgetValue() {
		System.out.println(RelationShipEnum.getEnameByOrdinal(0));
		System.out.println(RelationShipEnum.getNameByOrdinal(0));

	}

	@Test
	public void test() {
		System.out.println(CERTITypeEnum.getValueByKey(1));
		System.out.println(PaperTypeENEnum.getValueByKey(1));
	}
}
