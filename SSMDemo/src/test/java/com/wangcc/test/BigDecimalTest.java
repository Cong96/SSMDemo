package com.wangcc.test;

import java.math.BigDecimal;

/** 
* @ClassName: BigDecimalTest 
* @Description: TODO(这里用一句话描述这个类的作用) 
* @author wangcc
* @date 2017年9月13日 下午2:30:05 
*  add javadoc comment
*  
*  http://blog.csdn.net/jixinhuluwa/article/details/72626598
*  http://blog.csdn.net/jackiehff/article/details/8582449
*       JDK的描述：1、参数类型为double的构造方法的结果有一定的不可预知性。有人可能认为在Java中写入newBigDecimal(0.1)所创建的BigDecimal正好等于 0.1（非标度值 1，其标度为 1），但是它实际上等于0.1000000000000000055511151231257827021181583404541015625。这是因为0.1无法准确地表示为 double（或者说对于该情况，不能表示为任何有限长度的二进制小数）。这样，传入到构造方法的值不会正好等于 0.1（虽然表面上等于该值）。
        2、另一方面，String 构造方法是完全可预知的：写入 newBigDecimal("0.1") 将创建一个 BigDecimal，它正好等于预期的 0.1。因此，比较而言，通常建议优先使用String构造方法。
        3、当double必须用作BigDecimal的源时，请注意，此构造方法提供了一个准确转换；它不提供与以下操作相同的结果：先使用Double.toString(double)方法，然后使用BigDecimal(String)构造方法，将double转换为String。要获取该结果，请使用static valueOf(double)方法。
*/
public class BigDecimalTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		BigDecimal big=new BigDecimal(0.0);
		System.out.println(big);
	}

}
