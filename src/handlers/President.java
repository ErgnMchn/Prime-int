package handlers;

import modals.Limits;
import modals.ManagerLimits;
import modals.Purchase;

/**
 * //TODO - Implement approval implementation for President level
 */
public class President extends Approver{

    private final Limits managerLimits;

    public President() {
        this.managerLimits = new ManagerLimits(1000, 2000, 3000, 5000, 8000);
    }

    @Override
    public void approve(Purchase purchase) {
        if (canApprove(purchase)) {
            System.out.println("President approved purchase with id " + purchase.getId() + " that costs "
                    + purchase.getCost());
            return;
        }

        System.out.println(
                "Purchase with id " + purchase.getId() + " needs approval from higher position than President.");
        next.approve(purchase);
    }

    @Override
    protected boolean canApprove(Purchase purchase) {
        return purchase.canApprove(this.managerLimits);
    }
}
