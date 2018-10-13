package ca.ulaval.glo4002.cart.application.cart;

public class ServiceAlreadyRegisteredException extends RuntimeException {
    public <T> ServiceAlreadyRegisteredException(Class<T> contract) {
        super("A service implementation was already provided for " + contract.getSimpleName());
    }
}
