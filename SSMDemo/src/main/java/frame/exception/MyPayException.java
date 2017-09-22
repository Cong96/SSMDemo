package frame.exception;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

public class MyPayException extends BaseRuntimeException {

	/** serialVersionUID */
	private static final long serialVersionUID = 0L;

	/** 返回码 */
	private MyPayResultCodeEnum resultCode;

	/**
	 * 构造函数
	 * 
	 * @param resultCode
	 *            返回码
	 */
	public MyPayException(MyPayResultCodeEnum resultCode) {
		super();
		this.resultCode = resultCode;
	}

	/**
	 * 构造函数
	 * 
	 * @param resultCode
	 *            返回码
	 * @param e
	 *            需要传递的异常
	 */
	public MyPayException(MyPayResultCodeEnum resultCode, Throwable e) {
		super(e);
		this.resultCode = resultCode;
	}

	/**
	 * 构造函数
	 * 
	 * @param resultCode
	 *            返回码
	 * @param message
	 *            错误信息
	 */
	public MyPayException(MyPayResultCodeEnum resultCode, String message) {
		super(message);
		this.resultCode = resultCode;
	}

	@Override
	public String toString() {// ToStringBuilder ToStringStyle所属于commons-lang jar包
		return ToStringBuilder.reflectionToString(this, ToStringStyle.SHORT_PREFIX_STYLE);
	}

	/*
	 * getter and setter
	 */
	public MyPayResultCodeEnum getResultCode() {
		return resultCode;
	}

	public void setResultCode(MyPayResultCodeEnum resultCode) {
		this.resultCode = resultCode;
	}

}