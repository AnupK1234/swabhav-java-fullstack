package acc_app;

public class CustomExceptions {
	public static class NegativeAmountException extends RuntimeException {
		public NegativeAmountException(String message) {
			super(message);
		}
	}

	public static class InsufficientFundsException extends RuntimeException {
		public InsufficientFundsException(String message) {
			super(message);
		}
	}
}
