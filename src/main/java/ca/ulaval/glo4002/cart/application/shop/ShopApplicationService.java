package ca.ulaval.glo4002.cart.application.shop;

import java.util.List;
import java.util.logging.Logger;
import java.util.stream.Collectors;

import ca.ulaval.glo4002.cart.domain.shop.ShopItem;

public class ShopApplicationService {
    private final ShopRepository shopRepository;

    public ShopApplicationService() {
        this.shopRepository = new ShopRepository();
    }

    public List<ShopItem> listAvailableItems() {
        List<ShopItem> items = shopRepository.readShopFromFile();
        if (items.isEmpty()) {
            Logger.getGlobal().info("Prefilling data in the shop for the demo");
            prefillDemoData();
            items = shopRepository.readShopFromFile();
        }

        return items.stream().filter(ShopItem::isAvailable).collect(Collectors.toList());
    }

    public ShopItem findItemBySku(String sku) {
        return listAvailableItems().stream()
                .filter(x -> x.hasSku(sku))
                .findFirst()
                .orElseThrow(ItemNotFoundException::new);
    }

    private void prefillDemoData() {
        addItem("1251521", "Peanuts", 1.20, true);
        addItem("236637", "Clean Code", 0.50, false);
        addItem("235265", "Détendeur Mares Abyss Navy 22", 0.15, true);
        addItem("276101", "Imprimante 3D", 0.60, true);
        addItem("818113", "GoPro", 4.60, true);
        addItem("51-153", "Peinture à numéro", 1.40, true);
    }

    private void addItem(String sku, String name, double margin, boolean available) {
        List<ShopItem> items = shopRepository.readShopFromFile();
        items.add(new ShopItem(sku, name, margin, available));

        shopRepository.persistShop(items);
    }
}
