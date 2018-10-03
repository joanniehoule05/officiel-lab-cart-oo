package ca.ulaval.glo4002.cart.interfaces.rest;

import ca.ulaval.glo4002.cart.domain.cart.CartRepository;
import ca.ulaval.glo4002.cart.domain.shop.ShopRepository;
import ca.ulaval.glo4002.cart.infrastructure.persistence.memory.InMemoryCartRepository;
import ca.ulaval.glo4002.cart.infrastructure.persistence.memory.InMemoryShopRepository;
import ca.ulaval.glo4002.cart.infrastructure.persistence.xml.XmlCartRepository;
import ca.ulaval.glo4002.cart.infrastructure.persistence.xml.XmlShopRepository;

public class PersistenceProvider {
    public static CartRepository getCartRepository() {
        if (System.getProperty("store").equalsIgnoreCase("xml")) {
            return new XmlCartRepository();
        } else {
            return new InMemoryCartRepository();
        }
    }

    public static ShopRepository getShopRepository() {
        if (System.getProperty("store").equalsIgnoreCase("xml")) {
            return new XmlShopRepository();
        } else {
            return new InMemoryShopRepository();
        }
    }
}