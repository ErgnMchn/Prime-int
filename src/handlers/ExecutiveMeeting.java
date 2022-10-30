package handlers;

import modals.Purchase;

/**
 * Used as a fallback in approval chain.
 * Should not contain any additional logic.
 * If abstract methods are changed, be free to edit signatures.
 */
public class ExecutiveMeeting extends Approver {
    private static final ExecutiveMeeting INSTANCE = new ExecutiveMeeting();

    public static ExecutiveMeeting getInstance() {
        return INSTANCE;
    }

    @Override
    public void approve(Purchase purchase) {
        System.out.println("Purchase with id " + purchase.getId() + " that costs " + purchase.getCost() + " requires an approval of executive meeting.");
    }

    @Override
    protected boolean canApprove(Purchase purchase) {
        return false;
    }
}
