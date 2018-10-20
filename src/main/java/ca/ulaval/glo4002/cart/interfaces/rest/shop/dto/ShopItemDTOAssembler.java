package ca.ulaval.glo4002.cart.interfaces.rest.shop.dto;

import java.util.List;

import ca.ulaval.glo4002.cart.domain.shop.ShopItem;

import static java.util.stream.Collectors.toList;

public class ShopItemDTOAssembler {
	
	public List<ShopItemDTO> toDTO(List<ShopItem> items){
		return items.stream().map(this::toDTO).collect(toList());
	}
	
	public ShopItemDTO toDTO(ShopItem item) {
		return new ShopItemDTO(item.getName(), item.getSku());
	}

}
