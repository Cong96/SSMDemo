package frame.exception;

/**
 * @ClassName: ExceptionSeverity
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author wangcc
 * @date 2017年9月18日 下午5:48:23 轻微 一般 重要 严重
 * 
 * 
 *       枚举也是一种类，不能像你代码中那样把它理解成一个数组， 一个类该怎么写枚举类也该咋写。
 *       “1，2，3”是一种数据类型，它不是对象也不是变量，肯定报错。
 */

public enum Severity {
	MINOR, // 轻微
	NORMAL, // 一般
	MAJOR, // 严重
	// 非常严重
	CRITICAL
}
