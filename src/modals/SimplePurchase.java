package modals;

import common.PurchaseType;

public class SimplePurchase implements Purchase {

    private final long id;
    private final long cost;
    private final PurchaseType purchaseType;

    public SimplePurchase(long id, long cost, PurchaseType purchaseType) {
        this.id = id;
        this.cost = cost;
        this.purchaseType = purchaseType;
    }

    @Override
    public boolean canApprove(Limits limits) {

        if (purchaseType == PurchaseType.CONSUMABLES) {
            return this.cost <= limits.getConsumables();
        } else if (purchaseType == PurchaseType.CLERICAL) {
            return this.cost <= limits.getClerical();
        } else if (purchaseType == PurchaseType.GADGETS) {
            return this.cost <= limits.getGadgets();
        } else if (purchaseType == PurchaseType.GAMING) {
            return  this.cost <= limits.getGaming();
        } else if (purchaseType == PurchaseType.PC) {
            return  this.cost <= limits.getPc();
        } else {
            return false;
        }

    }

    public long getId() {
        return id;
    }

    public long getCost() {
        return cost;
    }
}
