package week3.loot;

import java.math.BigDecimal;
import java.util.Comparator;
import java.util.List;

public class MaximValueOfTheLoot {

    public static double maximumValue(final int sackCapacity, final List<Loot> loots) {
        if(sackCapacity <= 0) {
            return 0;
        }

        loots.sort(Comparator.comparing(Loot::getUnitValue).reversed());

        BigDecimal maximumValue = BigDecimal.ZERO;
        int sackCapacityLeft = sackCapacity;

        for(Loot loot: loots) {
            if(loot.getTotalWeight() <= sackCapacityLeft) {
                maximumValue = maximumValue.add(BigDecimal.valueOf(loot.getTotalValue()));
                sackCapacityLeft -= loot.getTotalWeight();
            } else {
                BigDecimal valueFromFractionlLoot = BigDecimal.valueOf(loot.getTotalValue())
                        .multiply(BigDecimal.valueOf(sackCapacityLeft))
                        .divide(BigDecimal.valueOf(loot.getTotalWeight()), 4, BigDecimal.ROUND_HALF_EVEN);
                maximumValue = maximumValue.add(valueFromFractionlLoot);
            }

            if(sackCapacityLeft == 0) {
                break;
            }
        }

        return maximumValue.doubleValue();
    }
}
