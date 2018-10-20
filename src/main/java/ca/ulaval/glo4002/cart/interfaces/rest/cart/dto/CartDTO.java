package ca.ulaval.glo4002.cart.interfaces.rest.cart.dto;

import java.util.List;

public class CartDTO {
	
	public final List<CartItemDTO> items;
	
	public CartDTO(List<CartItemDTO> items) {
		this.items = items;
	}
}
