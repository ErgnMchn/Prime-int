package handlers;

import common.PurchaseType;
import modals.Limits;
import modals.ManagerLimits;
import modals.Purchase;

/**
 * //TODO - Implement approval implementation for VicePresident level
 */
public class VicePresident extends Approver {

    private final Limits managerLimits;

    public VicePresident() {
        this.managerLimits = new ManagerLimits(700, 1500, 2000, 4500, 6500);
    }

    @Override
    public void approve(Purchase purchase) {
        if (canApprove(purchase)) {
            System.out.println("VicePresident approved purchase with id " + purchase.getId() + " that costs "
                    + purchase.getCost());
            return;
        }

        System.out.println(
                "Purchase with id " + purchase.getId() + " needs approval from higher position than VicePresident.");
        next.approve(purchase);
    }

    @Override
    protected boolean canApprove(Purchase purchase) {
        return purchase.canApprove(this.managerLimits);
    }
}
