package frame.exception;

public class InitialException extends BaseRuntimeException {
	protected Severity severity = Severity.MAJOR;

	public InitialException(Throwable cause) {
		super(cause);
	}

	public InitialException(String message, Severity severity) {
		super(message);

		this.severity = severity;
	}

	public InitialException(String message, Throwable cause) {
		super(message, cause);
	}

}
