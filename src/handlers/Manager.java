package handlers;

import modals.Limits;
import modals.ManagerLimits;
import modals.Purchase;

/**
 * //TODO - If needed, validate logic and if possible optimize code
 */
public class Manager extends Approver {

    private Limits managerLimits;

    public Manager() {
        this.managerLimits = new ManagerLimits(300, 500, 1000, 3000, 5000);
    }

    // TODO; validate input parameters; like cost cannot be negative, incorrect

    @Override
    public void approve(Purchase purchase) {

        if (canApprove(purchase)) {
            System.out.println("Manager approved purchase with id " + purchase.getId() + " that costs " + purchase.getCost());
            return;
        }

        System.out.println("Purchase with id " + purchase.getId() + " needs approval from higher position than Manager.");
        next.approve(purchase);
    }

    @Override
    protected boolean canApprove(Purchase purchase) {
        return purchase.canApprove(this.managerLimits);
    }
}
