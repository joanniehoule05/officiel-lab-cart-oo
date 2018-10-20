package ca.ulaval.glo4002.cart.context;


public class ApplicationContext {
    //private ShopRepository shopRepository;

    /*public ApplicationContext(ShopRepository shopRepository) {
        this.shopRepository = shopRepository;
    }*/

    public void apply() {
    	
    	if(System.getProperty("store").equalsIgnoreCase("xml")) {
    		new XmlPersistanceContext().apply();
    	} else {
    		new InMemmoryPersistanceContext().apply();
    	}
    	
        if (System.getProperty("promo").equalsIgnoreCase("true")) {
            new PromoContext().apply();
        } else {
            new NoPromoContext().apply();
        }
    	
        if (System.getProperty("mode").equalsIgnoreCase("demo")) {
            new DemoPrefillContext().apply();
        }
    }
}
