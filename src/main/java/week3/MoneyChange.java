package week3;

public class MoneyChange {

    public static int numberOfCoins(final int moneyValue) {
        if(moneyValue <= 0) {
            return 0;
        }

        int numberOfTenCoins = moneyValue / 10;
        int remainingMoneyAfterTenCoins = moneyValue - numberOfTenCoins * 10;

        int numberOfFiveCoins = remainingMoneyAfterTenCoins / 5;

        int numberOfOneCoins = remainingMoneyAfterTenCoins - numberOfFiveCoins * 5;

        return numberOfTenCoins + numberOfFiveCoins + numberOfOneCoins;
    }
}
