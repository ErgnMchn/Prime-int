package modals;

public interface Purchase {
    boolean canApprove(Limits limits);
    long getId();
    long getCost();
}
