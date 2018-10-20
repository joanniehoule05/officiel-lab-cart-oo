package ca.ulaval.glo4002.cart.interfaces.rest.shop.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ShopItemDTO {
	
	@JsonProperty
	public final String name;
	
	@JsonProperty
	public final String itemSku;
	
	public ShopItemDTO(String name, String itemSku) {
		this.name = name;
		this.itemSku = itemSku;
	}
}
