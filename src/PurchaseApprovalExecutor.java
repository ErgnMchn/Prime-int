import common.PurchaseType;
import handlers.Approver;
import handlers.Manager;
import modals.SimplePurchase;

/**
 * Execution class of the application.
 * Be free to modify below line 14 (bellow comment line)
 */
public class PurchaseApprovalExecutor {

    public static void execute() {
        Approver manager = new Manager();
        ApprovalChainGenerator.generate(manager);
        //Be free to modify method below this line

        manager.approve(new SimplePurchase(1, 15000, PurchaseType.CONSUMABLES));
        manager.approve(new SimplePurchase(2, 5000, PurchaseType.PC));
        manager.approve(new SimplePurchase(3, 5000, PurchaseType.PC));
        manager.approve(new SimplePurchase(4, 3000, PurchaseType.CLERICAL));
    }
}
