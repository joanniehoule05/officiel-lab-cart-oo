package ca.ulaval.glo4002.cart.context;

import ca.ulaval.glo4002.cart.domain.shop.ShopRepository;

public class ApplicationContext {
    private ShopRepository shopRepository;

    //public ApplicationContext(ShopRepository shopRepository) {
    public ApplicationContext() {
        this.shopRepository = shopRepository;
    }

    public void apply() {
        if (System.getProperty("mode").equalsIgnoreCase("demo")) {
            new DemoPrefillContext(shopRepository).apply();
        }
    }
}
