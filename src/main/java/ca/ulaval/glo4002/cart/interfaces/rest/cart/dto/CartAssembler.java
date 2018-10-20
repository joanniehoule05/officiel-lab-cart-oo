package ca.ulaval.glo4002.cart.interfaces.rest.cart.dto;

import ca.ulaval.glo4002.cart.domain.cart.Cart;
import ca.ulaval.glo4002.cart.domain.cart.CartItem;

import static java.util.stream.Collectors.toList;

public class CartAssembler {
	
	public CartDTO toDTO(Cart cart) {
		return new CartDTO(cart.listItems().stream().map(this::toDTO).collect(toList()));
	}

	public CartItemDTO toDTO(CartItem cartItem) {
		return new CartItemDTO(cartItem.getName(), cartItem.getQuantity(), cartItem.getTotalPrice());
	}
}
