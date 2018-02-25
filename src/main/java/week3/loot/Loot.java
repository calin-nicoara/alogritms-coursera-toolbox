package week3.loot;

import java.math.BigDecimal;

public class Loot {

    private int totalValue;
    private int totalWeight;

    public Loot() {}

    public Loot(final int totalValue, final int totalWeight) {
        this.totalValue = totalValue;
        this.totalWeight = totalWeight;
    }

    public int getTotalValue() {
        return totalValue;
    }

    public int getTotalWeight() {
        return totalWeight;
    }

    public BigDecimal getUnitValue() {
        return BigDecimal.valueOf(totalValue)
                .divide(BigDecimal.valueOf(totalWeight), 5, BigDecimal.ROUND_HALF_EVEN);
    }
}
