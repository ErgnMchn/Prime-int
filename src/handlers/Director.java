package handlers;

import common.PurchaseType;
import modals.Limits;
import modals.ManagerLimits;
import modals.Purchase;

/**
 * //TODO - If needed, validate logic and if possible optimize code.
 */
public class Director extends Approver {

    private final Limits managerLimits;

    public Director() {
        this.managerLimits = new ManagerLimits(500, 1000, 1500, 3500, 6000);
    }

    @Override
    public void approve(Purchase purchase) {
        if (canApprove(purchase)) {
            System.out.println("Director approved purchase with id " + purchase.getId() + " that costs " + purchase.getCost());
            return;
        }

        System.out.println("Purchase with id " + purchase.getId() + " needs approval from higher position than Director.");
        next.approve(purchase);
    }

    @Override
    protected boolean canApprove(Purchase purchase) {
        return purchase.canApprove(this.managerLimits);
    }
}
