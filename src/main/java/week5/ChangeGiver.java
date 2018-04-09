package week5;

import java.util.List;

public class ChangeGiver {

    public int numberOfCoins(int amount, List<Integer> denominations) {
        int[] changeTable = new int[amount+1];

        for(int currentAmount = 0; currentAmount < amount; currentAmount++) {
            for (Integer currentDenomination : denominations) {
                if(currentAmount+currentDenomination <= amount) {
                    if(changeTable[currentAmount+currentDenomination] == 0
                            || changeTable[currentAmount] + 1 < changeTable[currentAmount+currentDenomination]) {
                        changeTable[currentAmount+currentDenomination] = changeTable[currentAmount] + 1;
                    }
                }
            }
        }

        return changeTable[amount];
    }
}
