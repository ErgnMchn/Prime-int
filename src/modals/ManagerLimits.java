package modals;

public class ManagerLimits implements Limits{
    private final long consumables;
    private final long clerical;
    private final long gadgets;
    private final long gaming;
    private final long pc;

    public ManagerLimits(long consumables, long clerical, long gadgets, long gaming, long pc) {
        this.consumables = consumables;
        this.clerical = clerical;
        this.gadgets = gadgets;
        this.gaming = gaming;
        this.pc = pc;
    }

    public long getConsumables() {
        return consumables;
    }

    public long getClerical() {
        return clerical;
    }

    public long getGadgets() {
        return gadgets;
    }

    public long getGaming() {
        return gaming;
    }


    public long getPc() {
        return pc;
    }

}
