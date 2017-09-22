package frame.exception;

public class BaseRuntimeException extends RuntimeException {
	/** serialVersionUID */
	private static final long serialVersionUID = 0L;

	/** 严重级别 */
	protected Severity severity = Severity.NORMAL;

	/**
	 * 空构造器。
	 */
	public BaseRuntimeException() {
		super();
	}

	/**
	 * 构造器。
	 * 
	 * @param severity
	 *            严重级别
	 */
	public BaseRuntimeException(Severity severity) {
		super();

		this.severity = severity;
	}

	/**
	 * 构造器。
	 * 
	 * @param message
	 *            消息
	 */
	public BaseRuntimeException(String message) {
		super(message);
	}

	/**
	 * 构造器。
	 * 
	 * @param message
	 *            消息
	 * @param severity
	 *            严重级别
	 */
	public BaseRuntimeException(String message, Severity severity) {
		super(message);

		this.severity = severity;
	}

	/**
	 * 构造器。
	 * 
	 * @param cause
	 *            原因
	 */
	public BaseRuntimeException(Throwable cause) {
		super(cause);
	}

	/**
	 * 构造器。
	 * 
	 * @param cause
	 *            原因
	 * @param severity
	 *            严重级别
	 */
	public BaseRuntimeException(Throwable cause, Severity severity) {
		super(cause);

		this.severity = severity;
	}

	/**
	 * 构造器。
	 * 
	 * @param message
	 *            消息
	 * @param cause
	 *            原因
	 */
	public BaseRuntimeException(String message, Throwable cause) {
		super(message, cause);
	}

	/**
	 * 构造器。
	 * 
	 * @param message
	 *            消息
	 * @param cause
	 *            原因
	 * @param severity
	 *            严重级别
	 */
	public BaseRuntimeException(String message, Throwable cause, Severity severity) {
		super(message, cause);

		this.severity = severity;
	}

	/**
	 * @return Returns the severity.
	 */
	public Severity getSeverity() {
		return severity;
	}

	/**
	 * @see java.lang.Throwable#toString()
	 */
	public String toString() {
		StringBuffer buffer = new StringBuffer();

		buffer.append(super.toString()).append(" - severity: ");

		buffer.append(severity.toString());
		buffer.append("(").append(severity).append(")");

		return buffer.toString();
	}
}