package frame.exception;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Severity Server = Severity.CRITICAL;
		switch (Server) {
		case CRITICAL:
			System.out.println("CRITICAL");
			break;

		}
		System.out.println(Severity.CRITICAL.toString());
		Severity.CRITICAL.ordinal();

	}

}
