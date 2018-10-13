package ca.ulaval.glo4002.cart.application.cart;

public class UnknownServiceResolved extends RuntimeException {
	public <T> UnknownServiceResolved(Class<T>contract) {
		super("No implementation was registered for contract " + contract.getSimpleName());
	}

	private static final long serialVersionUID = 1L;
}
